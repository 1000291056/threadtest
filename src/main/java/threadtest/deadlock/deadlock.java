package threadtest.deadlock;

public class deadlock {
    public static void main(String[] args) {
        Task task=new Task();
        Thread thread_a = new Thread(task);
        thread_a.setName("a");
        Thread thread_b = new Thread(task);
        thread_b.setName("b");
        thread_a.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
             
        }
        thread_b.start();
    }
}
