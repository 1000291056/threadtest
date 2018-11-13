package threadtest.api.clone;

public class Person implements Cloneable {
    int age;
    String name = "";
    Info info;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person p= (Person) super.clone();
        if (info!=null){
            p.info= (Info) info.clone();
        }
        return p;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", info=" + info +
                '}';
    }
}
