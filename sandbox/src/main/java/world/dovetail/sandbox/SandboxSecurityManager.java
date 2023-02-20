package world.dovetail.sandbox;

import java.io.FilePermission;
import java.security.Permission;
import java.security.SecurityPermission;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

/**
 * Class extending the SecurityManager to create an own security profile.
 */
public class SandboxSecurityManager extends SecurityManager {

    private static final SandboxSecurityManager INSTANCE = new SandboxSecurityManager();

    private boolean sandbox;

    private List<UUID> uuids;
    private Collection<Permission> blacklist;

    private SandboxSecurityManager (){
        this.uuids = new ArrayList<>();
    }

    @Override
    public void checkPermission(Permission perm) {
        check(perm);
    }

    @Override
    public void checkPermission(Permission perm, Object context) {
        check(perm);
    }

    /**
     * Check if a permission can be granted by checking if it is blacklisted.
     * If blacklisted throw a SecurityException.
     *
     * @param perm to check.
     */
    private void check(Permission perm) {
        if (!sandbox) {
            return;
        }

        if (blacklisted(perm)) {
            throw new SecurityException("Permission denied for operation: " + perm.getName());
        }
    }

    public void secure(UUID uuid) {
        uuids.add(uuid);

        createBlacklist();
        sandbox = true;
    }


    public void unsecure(UUID uuid) {
        if (uuids.contains(uuid)){
            uuids.remove(uuid);

            if (uuids.size() == 0) {
                blacklist = new ArrayList<>();
                sandbox = false;
            }
        }
    }

    /**
     * Check if a permission is blacklisted.
     *
     * @param perm to check.
     * @return true if the permission is blacklisted.
     */
    private boolean blacklisted(Permission perm) {
        for (Permission p : blacklist) {
            if (p.implies(perm)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Create the permission blacklist.
     */
    private void createBlacklist() {
        blacklist = new ArrayList<>();
        blacklist.add(new RuntimePermission("exitVM.2"));
        blacklist.add(new RuntimePermission("exitVM.1"));
        blacklist.add(new RuntimePermission("exitVM.0"));
        blacklist.add(new FilePermission("<<ALL FILES>>", "write, execute"));
        blacklist.add(new RuntimePermission("accessClassInPackage.sun"));
        blacklist.add(new RuntimePermission("setSecurityManager"));
        blacklist.add(new SecurityPermission("setPolicy"));
        blacklist.add(new SecurityPermission("setProperty.package.access"));
    }

    public static SandboxSecurityManager getInstance() {
        return INSTANCE;
    }
}
