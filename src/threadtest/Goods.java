package threadtest;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wufeifei on 2016/4/14.
 */
public class Goods {
    private int count = 0;
    private static final int MAX = 99;//最大产量
    private Random random = new Random();
    private Lock lock = new ReentrantLock();
    private Condition conditionP = lock.newCondition();
    private Condition conditionC = lock.newCondition();

    /**
     * 生产
     */
    public void p() {
        lock.lock();
        try {
            while (count >= MAX) {
                conditionP.await();
            }
            count+=5;
            System.out.println(Thread.currentThread().getName() + "生产"+5+"个"+"---------------------------------------产库剩余" + count + "-----------------------------------");
            conditionC.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    /**
     * 消费
     */
    public void c() {
        lock.lock();
        try {
            while (count <= 0) {
                conditionC.await();
            }
            int temp = (int) (2 + Math.random() * (count - 2+ 1));
            if (temp > 0 && temp <= count) {
                count -= temp;
                System.out.println(Thread.currentThread().getName() + "消费" + temp + "个"+"---------------------------------------产库剩余" + count + "-----------------------------------");
            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    /**
     * 唤醒消费
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
     * 唤醒生产
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
        System.out.println(Thread.currentThread().getName() + "---------------------------------------产库剩余" + count + "-----------------------------------");
    }
}
