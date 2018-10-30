package threadtest.lock;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wufeifei on 2016/4/14.
 */
public class Goods {
    private int count = 0;
    private static final int MAX = 9;//??????
    private Random random = new Random();
    private Lock lock = new ReentrantLock();
    private Condition conditionP = lock.newCondition();
    private Condition conditionC = lock.newCondition();

    /**
     * ????
     */
    public void p() {
        lock.lock();
        try {
            while (count >= MAX) {
                conditionP.await();
            }
            count += 5;
            System.out.println(Thread.currentThread().getName() + "????" + 5 + "??" + "---------------------------------------???????" + count + "-----------------------------------");
            conditionC.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    /**
     * ????
     */
    public void c() {
        lock.lock();
        try {
            while (count <= 0) {
                conditionC.await();
            }
            int temp = (int) (2 + Math.random() * (count - 2 + 1));
            if (temp > 0 && temp <= count) {
                count -= temp;
                System.out.println(Thread.currentThread().getName() + "????" + temp + "??" + "---------------------------------------???????" + count + "-----------------------------------");
            }
            conditionP.signalAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    /**
     * ????????
     */
    public void signalP() {
        lock.lock();
        try {
            conditionP.notifyAll();
        } finally {
            lock.unlock();
        }

    }

    /**
     * ????????
     */
    public void signalC() {
        lock.lock();
        try {
            conditionC.notifyAll();
        } finally {
            lock.unlock();
        }
    }

    private void reportCount() {
        System.out.println(Thread.currentThread().getName() + "---------------------------------------???????" + count + "-----------------------------------");
    }
}
