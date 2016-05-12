package threadtest.synchronizedTest;

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

    /**
     * 生产
     */
    public void p() {
        synchronized (this) {
            try {
                while (count >= MAX) {
                    wait();
                }
                count += 5;
                System.out.println(Thread.currentThread().getName() + "生产" + 5 + "个" + "---------------------------------------产库剩余" + count + "-----------------------------------");
                notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 消费
     */
    public void c() {
        synchronized (this) {
            try {
                while (count <= 0) {
                    wait();
                }
                int temp = (int) (2 + Math.random() * (count - 2 + 1));
                if (temp > 0 && temp <= count) {
                    count -= temp;
                    System.out.println(Thread.currentThread().getName() + "消费" + temp + "个" + "---------------------------------------产库剩余" + count + "-----------------------------------");
                }
                notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    private void reportCount() {
        System.out.println(Thread.currentThread().getName() + "---------------------------------------产库剩余" + count + "-----------------------------------");
    }
}
