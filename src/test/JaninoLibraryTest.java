import org.codehaus.commons.compiler.CompileException;
import org.codehaus.janino.ExpressionEvaluator;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by 정민 on 2016-01-15.
 */
public class JaninoLibraryTest {

    public void test1() throws InvocationTargetException, CompileException {
        ExpressionEvaluator ee = new ExpressionEvaluator();
        ee.cook("1 + 2");
        System.out.println(ee.evaluate(null));
    }

    public void test2() throws CompileException, InvocationTargetException {
        ExpressionEvaluator ee = new ExpressionEvaluator(
                "c > d ? c : d",
                int.class,
                new String[] { "c", "d" },
                new Class[] { int.class, int.class }
        );

        Integer res = (Integer) ee.evaluate(
                new Object[] {
                        new Integer(10),
                        new Integer(11),
                }
        );
        System.out.println(res);
    }

    public void main() throws InvocationTargetException, CompileException {
        test1();
        test2();
    }

}
