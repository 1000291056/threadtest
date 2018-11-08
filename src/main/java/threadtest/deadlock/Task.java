package threadtest.deadlock;

import static threadtest.PrintTool.*;

public class Task implements Runnable {
    private Object lock1 = new Object();
    private Object lock2 = new Object();

    @Override
    public void run() {
        if ("a".equals(Thread.currentThread().getName())) {
            synchronized (lock1) {
                try {
                    println("线程a_111111111111111111");
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {
                    println("线程a_22222222222222222222");
                }
            }

        } else {
            synchronized (lock2) {
                try {
                    println("线程b_111111111111111111");
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1) {
                    println("线程b_22222222222222222222");
                }

            }

        }
    }
}