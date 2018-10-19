package threadtest.api;

public class TestClass implements MyInterface1,MyInterface2 {
    @Override
    public void MyInterface1() {
        System.out.println("MyInterface1");
    }

    @Override
    public void MyInterface2() {
        System.out.println("MyInterface2");
    }
}
