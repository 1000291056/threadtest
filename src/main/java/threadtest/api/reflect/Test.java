package threadtest.api.reflect;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

import static threadtest.PrintTool.*;

public class Test {
    public static void main(String[] args) {
        ObjectA a = new ObjectA();
        ObjectB b = new ObjectB();
        Class<ObjectA> aClass = (Class<ObjectA>) a.getClass();
        Class<ObjectB> bClass = (Class<ObjectB>) b.getClass();
        try {
            Field fieldA = aClass.getDeclaredField("args");
            Field fieldB = bClass.getDeclaredField("args");

            String[] argsA = (String[]) fieldA.get(a);
            String[] argsB = (String[]) fieldB.get(b);
            String[] argsAB = new String[argsA.length + argsB.length];
            System.arraycopy(argsA, 0, argsAB, 0, argsA.length);
            System.arraycopy(argsB, 0, argsAB, argsA.length, argsB.length);
            for (String msg : argsAB
                    ) {
                println(msg);
            }
            fieldA.set(a,argsAB);
            println(a);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
