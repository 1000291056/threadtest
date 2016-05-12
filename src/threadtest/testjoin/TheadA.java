package threadtest.testjoin;

/**
 * Created by wufeifei on 2016/4/14.
 */
public class TheadA extends Thread {
    ThreadB b;

    public TheadA(ThreadB b) {
        this.b = b;
    }

    @Override
    public void run() {
        super.run();
        synchronized (b) {
            try {
                System.out.println("begin A ThreadName=" + Thread.currentThread().getName() + "\t" + System.currentTimeMillis());
                Thread.sleep(5000);
                System.out.println("begin A ThreadName=" + Thread.currentThread().getName() + "\t" + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
