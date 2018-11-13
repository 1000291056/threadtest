package threadtest.api.clone;
import static threadtest.PrintTool.*;
public class CloneTest {
    public static void main(String[] args) {
        Person person=new Person();
        try {
            person.info=new Info(1,"f_n");
            Person personC= (Person) person.clone();
            personC.name="p_c";
            personC.info.f_c=2;
            personC.info.f_n="f_n_c";
            println(person.toString());
            println(personC.toString());
            println("person地址："+System.identityHashCode(person));
            println("personC地址："+System.identityHashCode(personC));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
