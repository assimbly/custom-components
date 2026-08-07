package org.assimbly.sandbox.executors;

import java.io.IOException;
import java.nio.file.*;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class ConfigurableWhitelist {

    private static final Logger LOG = Logger.getLogger(ConfigurableWhitelist.class.getName());
    private static final String BASE_PATH = System.getProperty("user.home");
    private static final String ASSIMBLY_PATH = "/.assimbly";
    private static final String GROOVY_PATH = "/groovy/";

    // class name -> method rule (allow-all-except / allow-only)
    // NOTE: a class is constructible via `new` iff it has an entry here (see isClassAllowed).
    private static final Map<String, MethodRule> METHOD_RULES = new ConcurrentHashMap<>();

    private static final Set<String> HARD_DENIED_METHODS = Set.of(
            "execute", "exec", "start", "exit", "halt",
            "forName", "newInstance", "invokeMethod", "invokeStaticMethod",
            "getMetaClass", "setMetaClass", "getClassLoader",
            "getDeclaredMethods", "getDeclaredFields", "setAccessible",
            "addShutdownHook"
    );

    // path can itself be overridden by env var at startup, that part's fine to be static
    private static final Path CONFIG_PATH = Paths.get(BASE_PATH + ASSIMBLY_PATH + GROOVY_PATH + "whitelist.conf");

    static {
        loadFromFile();
        startWatcher();
    }

    /**
     * Represents the method-access rule for a single class.
     * Either:
     *   - allowAll == true: every method is allowed EXCEPT those in `exceptions`
     *   - allowAll == false: ONLY methods in `allowed` are permitted
     */
    private static final class MethodRule {
        final boolean allowAll;
        final Set<String> exceptions; // used when allowAll == true
        final Set<String> allowed;    // used when allowAll == false

        private MethodRule(boolean allowAll, Set<String> exceptions, Set<String> allowed) {
            this.allowAll = allowAll;
            this.exceptions = exceptions;
            this.allowed = allowed;
        }

        static MethodRule allowAllExcept(Set<String> exceptions) {
            return new MethodRule(true, exceptions, Set.of());
        }

        static MethodRule allowOnly(Set<String> allowed) {
            return new MethodRule(false, Set.of(), allowed);
        }

        boolean permits(String method) {
            return allowAll ? !exceptions.contains(method) : allowed.contains(method);
        }
    }

    private static synchronized void loadFromFile() {
        if (!Files.exists(CONFIG_PATH)) {
            LOG.warning("Whitelist file not found at " + CONFIG_PATH);
            return;
        }
        try {
            Map<String, MethodRule> newRules = new ConcurrentHashMap<>();

            for (String raw : Files.readAllLines(CONFIG_PATH)) {
                String line = raw.trim();
                if (line.isEmpty() || line.startsWith("#")) continue;

                // strip trailing whitespace-separated comments
                line = line.split("\\s")[0];
                if (line.isEmpty()) continue;

                int hashIdx = line.indexOf('#');
                if (hashIdx > 0) {
                    String className = line.substring(0, hashIdx);
                    String rulePart = line.substring(hashIdx + 1);
                    parseMethodRule(className, rulePart, newRules, raw);
                } else {
                    LOG.warning("Ignoring whitelist line with no '#Class#method' rule: " + raw);
                }
            }

            METHOD_RULES.clear();
            METHOD_RULES.putAll(newRules);

            LOG.info("Whitelist reloaded: " + METHOD_RULES.size() + " classes with method rules.");
        } catch (IOException e) {
            LOG.severe("Failed to reload whitelist file, keeping previous config: " + e.getMessage());
        }
    }

    /**
     * Parses the portion of a line after "ClassName#" and merges it into newRules.
     * Supported forms:
     *   ClassName#*                  -> allow all methods
     *   ClassName#*,-foo,-bar        -> allow all methods except foo, bar
     *   ClassName#foo,bar            -> allow only foo, bar
     */
    private static void parseMethodRule(String className, String rulePart,
                                        Map<String, MethodRule> newRules, String originalLine) {
        String[] tokens = rulePart.split(",");
        if (tokens.length == 0) {
            LOG.warning("Ignoring malformed whitelist line (no methods specified): " + originalLine);
            return;
        }

        boolean wildcard = tokens[0].trim().equals("*");
        MethodRule existing = newRules.get(className);

        if (wildcard) {
            if (existing != null && !existing.allowAll) {
                LOG.warning("Class '" + className + "' has conflicting rules (both an explicit allow-list and a "
                        + "wildcard '*' rule). The wildcard rule takes precedence: " + originalLine);
            }
            Set<String> exceptions = new HashSet<>();
            for (int i = 1; i < tokens.length; i++) {
                String t = tokens[i].trim();
                if (t.startsWith("-")) {
                    exceptions.add(t.substring(1));
                } else if (!t.isEmpty()) {
                    LOG.warning("Ignoring malformed exception token '" + t + "' in line: " + originalLine);
                }
            }
            // if an earlier wildcard rule already exists for this class, merge exceptions (union)
            if (existing != null && existing.allowAll) {
                exceptions.addAll(existing.exceptions);
            }
            newRules.put(className, MethodRule.allowAllExcept(exceptions));
        } else {
            if (existing != null && existing.allowAll) {
                LOG.warning("Class '" + className + "' has conflicting rules (both a wildcard '*' rule and an "
                        + "explicit allow-list). The wildcard rule takes precedence, ignoring: " + originalLine);
                return;
            }
            Set<String> allowed = new HashSet<>();
            for (String t : tokens) {
                t = t.trim();
                if (!t.isEmpty()) allowed.add(t);
            }
            if (existing != null) {
                allowed.addAll(existing.allowed);
            }
            newRules.put(className, MethodRule.allowOnly(allowed));
        }
    }

    private static void startWatcher() {
        Path dir = CONFIG_PATH.getParent();
        if (dir == null || !Files.exists(dir)) {
            LOG.warning("Whitelist directory does not exist, skipping hot-reload watcher.");
            return;
        }
        Executors.newSingleThreadExecutor(r -> {
            Thread t = new Thread(r, "sandbox-whitelist-watcher");
            t.setDaemon(true);
            return t;
        }).submit(() -> {
            try (WatchService watcher = FileSystems.getDefault().newWatchService()) {
                dir.register(watcher, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_CREATE);
                while (true) {
                    WatchKey key = watcher.take(); // blocks
                    for (WatchEvent<?> event : key.pollEvents()) {
                        Path changed = dir.resolve((Path) event.context());
                        if (changed.equals(CONFIG_PATH)) {
                            LOG.info("Detected whitelist file change, reloading...");
                            loadFromFile();
                        }
                    }
                    if (!key.reset()) break;
                }
            } catch (IOException | InterruptedException e) {
                LOG.severe("Whitelist watcher stopped: " + e.getMessage());
            }
        });
    }

    /**
     * A class is constructible via `new` iff it has a method rule entry at all
     * (any of: allow-all, allow-all-except, or allow-only). There is no separate
     * "classes only" list anymore — presence in METHOD_RULES is what grants `new`.
     */
    public static boolean isClassAllowed(Class<?> clazz) {
        return METHOD_RULES.containsKey(clazz.getName());
    }

    public static boolean isMethodAllowed(Class<?> clazz, String method) {
        if (HARD_DENIED_METHODS.contains(method)) return false;

        Class<?> current = clazz;
        while (current != null) {
            MethodRule rule = METHOD_RULES.get(current.getName());
            if (rule != null && rule.permits(method)) {
                return true;
            }
            current = current.getSuperclass();
        }
        return false;
    }
}