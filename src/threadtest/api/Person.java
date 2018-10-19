package threadtest.api;

import threadtest.Goods;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static threadtest.PrintTool.*;

public class Person<T> {
    T sex;
    List<Goods> cours = new ArrayList<>();
    Map<String, Integer> map;

    public <Y> void genericMethod(Y y) {
        println(y);
    }

    public T getSex() {
        return sex;
    }

    public void setSex(T sex) {
        this.sex = sex;
    }

    String name = "";
    int age = 0;

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
