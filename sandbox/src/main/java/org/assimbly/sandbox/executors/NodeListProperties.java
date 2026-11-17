package org.assimbly.sandbox.executors;

import groovy.util.Node;
import groovy.util.NodeList;
import org.codehaus.groovy.ast.ClassCodeExpressionTransformer;
import org.codehaus.groovy.ast.ClassHelper;
import org.codehaus.groovy.ast.ClassNode;
import org.codehaus.groovy.ast.expr.ClosureExpression;
import org.codehaus.groovy.ast.expr.Expression;
import org.codehaus.groovy.ast.expr.StaticMethodCallExpression;
import org.codehaus.groovy.classgen.GeneratorContext;
import org.codehaus.groovy.control.CompilePhase;
import org.codehaus.groovy.control.SourceUnit;
import org.codehaus.groovy.control.customizers.CompilationCustomizer;
import org.kohsuke.groovy.sandbox.impl.Checker;

import java.util.Collection;

/**
 * GPath property reads on an XmlParser NodeList, e.g. root.Header.HeaderText.text().
 * <p>
 * Checker.checkedGetProperty spreads a property read on any Collection over its elements into a plain ArrayList,
 * so a NodeList loses its type and the next .text() fails. Groovy itself reads nodeList.name as
 * nodeList.getAt(name): the named children of every node, as one NodeList. This does the same,
 * with each child read still going through Checker.checkedGetProperty.
 */
public final class NodeListProperties {

    private NodeListProperties() {
        // utility class
    }

    public static Object checkedGetProperty(Object receiver, boolean safe, boolean spread, Object property) throws Throwable {
        if (!spread && receiver instanceof NodeList nodes) {
            NodeList answer = new NodeList();
            for (Object child : nodes) {
                if (child instanceof Node) {
                    Object value = Checker.checkedGetProperty(child, false, false, property);
                    if (value instanceof Collection<?> children) {
                        answer.addAll(children);
                    } else {
                        answer.add(value);
                    }
                }
            }
            return answer;
        }
        return Checker.checkedGetProperty(receiver, safe, spread, property);
    }

    /**
     * Runs after SandboxTransformer and points its Checker.checkedGetProperty calls to {@link #checkedGetProperty}.
     */
    static final class Redirect extends CompilationCustomizer {

        private static final String CHECKER = Checker.class.getName();
        private static final ClassNode SELF = ClassHelper.make(NodeListProperties.class);

        Redirect() {
            super(CompilePhase.CANONICALIZATION);
        }

        @Override
        public void call(SourceUnit source, GeneratorContext context, ClassNode classNode) {
            new ClassCodeExpressionTransformer() {
                @Override
                protected SourceUnit getSourceUnit() {
                    return source;
                }

                @Override
                public Expression transform(Expression exp) {
                    if (exp == null) {
                        return null;
                    }
                    if (exp instanceof ClosureExpression closure) {
                        // ClosureExpression.transformExpression doesn't visit the code inside
                        closure.getCode().visit(this);
                        return closure;
                    }
                    if (exp instanceof StaticMethodCallExpression call
                            && call.getOwnerType().getName().equals(CHECKER) && "checkedGetProperty".equals(call.getMethod())) {
                        StaticMethodCallExpression redirected = new StaticMethodCallExpression(SELF, "checkedGetProperty", transform(call.getArguments()));
                        redirected.setSourcePosition(call);
                        return redirected;
                    }
                    return exp.transformExpression(this);
                }
            }.visitClass(classNode);
        }
    }
}
