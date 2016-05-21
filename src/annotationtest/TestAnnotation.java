package annotationtest;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by smq on 2016/5/21.
 */
public class TestAnnotation {
    @MyAnnotation(value = 99, methed = "setAge")
    private int age;

    private void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public static void main(String[] args) {
        TestAnnotation testAnnotation = new TestAnnotation();
        Class classTemp = testAnnotation.getClass();
        if (classTemp.isAnnotationPresent(MyAnnotation.class)) {

        }
        Annotation[] annotations = classTemp.getDeclaredAnnotations();
        Field[] fs = classTemp.getDeclaredFields();
        for (Field f : fs) {
            if (f.isAnnotationPresent(MyAnnotation.class)) {
                try {
                    MyAnnotation a= f.getDeclaredAnnotation(MyAnnotation.class);
                    Method m = classTemp.getDeclaredMethod(a.methed(),int.class);
                    m.setAccessible(true);
                    m.invoke(testAnnotation,a.value());
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.print("age" + testAnnotation.getAge());
    }
}
