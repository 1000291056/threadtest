package threadtest.api;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

import static threadtest.PrintTool.*;

public class Test {
    static public void main(String[] args) {
//        testProxy();
//        testReflect();
        testType();
    }

    static void testType() {
        Person<String> person = new Person<>();
        person.genericMethod(person);
        person.sex = "女";
        Class<Person<String>> personClass = (Class<Person<String>>) person.getClass();

        Person<List<String>> personL = new Person<>();
        personL.sex=new ArrayList<>();
        personL.sex.add("111");
        Class<Person<List<String>>> personListClass= (Class<Person<List<String>>>) personL.getClass();

        try {
            Field sexField = personListClass.getDeclaredField("sex");
            Type type=sexField.getGenericType();
            println("personListClass:" + type.getClass().getSimpleName());

            Field coursField = personListClass.getDeclaredField("cours");
            Type courstype=coursField.getGenericType();
            ParameterizedType parameterizedType= (ParameterizedType) courstype;
            for (Type t :
                    parameterizedType.getActualTypeArguments()) {
                println("getActualTypeArguments:"+t);
            }

            println("coursField:" + courstype.getClass().getSimpleName());

            Field mapField = personListClass.getDeclaredField("map");
            Type maptype=mapField.getGenericType();
            ParameterizedType parameterizedTypeM= (ParameterizedType) maptype;
            for (Type t :
                    parameterizedTypeM.getActualTypeArguments()) {
                println("maptype:"+t);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void testReflect() {
        Person person = new Person();
        try {
            Class personClass = Class.forName("threadtest.api.Person");
            Constructor constructor = personClass.getConstructor(String.class, int.class);
            Person person1 = (Person) constructor.newInstance("小米", 3);
            println(personClass.getTypeName());
            println(person1.toString());
            TypeVariable<Class<?>>[] typeVariables = personClass.getTypeParameters();
            Class<?> componentType = personClass.getComponentType();
            println("......end!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    static void testProxy() {
        TestClass testClass = new TestClass();
        Class tClass = testClass.getClass();
        Class<?>[] interfaces = tClass.getInterfaces();
        for (Class<?> c : interfaces
                ) {
            System.out.println(c.getName());

        }
        Object o = Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), interfaces, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("proxy in");
                return method.invoke(testClass, args);
            }
        });
        Class oCl = o.getClass();
        for (Method m : oCl.getDeclaredMethods()
                ) {
            if (m.getName().contains("MyInterface")) {
                try {
                    m.invoke(o, null);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        ;
    }
}
