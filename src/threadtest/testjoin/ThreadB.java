package threadtest.testjoin;

/**
 * Created by wufeifei on 2016/4/14.
 */
public class ThreadB extends Thread {
    @Override
    synchronized public void run() {
        super.run();
        try {
            System.out.println("begin B ThreadName=" + Thread.currentThread().getName() + "\t" + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("end B ThreadName=" + Thread.currentThread().getName() + "\t" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
