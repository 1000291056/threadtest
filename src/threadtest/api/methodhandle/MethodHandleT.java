package threadtest.api.methodhandle;

import java.lang.invoke.ConstantCallSite;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static threadtest.PrintTool.*;

public class MethodHandleT {
    public static void main(String[] args) {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        try {
            MethodHandle methodHandle = lookup.findStatic(Test.class, "test", MethodType.methodType(void.class, String.class));
            methodHandle.invoke("小三");
            ConstantCallSite constantCallSite=new ConstantCallSite(methodHandle);
            constantCallSite.dynamicInvoker().invoke("小四");
            MethodHandle tarMethodHandle= constantCallSite.getTarget();
            tarMethodHandle.invoke("aa");
//            Object o=new Object();
//           // methodHandle.bindTo(o);
//            for (Method m:o.getClass().getDeclaredMethods()
//                 ) {
//               println(m.getName());
//            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    static class Test {
        public static void test(String name) {
            println("test:" + name);
        }
    }
}
