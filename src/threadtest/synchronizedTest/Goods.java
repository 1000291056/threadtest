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
    private static final int MAX = 99;//������
    private Random random = new Random();

    /**
     * ����
     */
    public void p() {
        synchronized (this) {
            try {
                while (count >= MAX) {
                    wait();
                }
                count += 5;
                System.out.println(Thread.currentThread().getName() + "����" + 5 + "��" + "---------------------------------------����ʣ��" + count + "-----------------------------------");
                notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * ����
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
                    System.out.println(Thread.currentThread().getName() + "����" + temp + "��" + "---------------------------------------����ʣ��" + count + "-----------------------------------");
                }
                notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    private void reportCount() {
        System.out.println(Thread.currentThread().getName() + "---------------------------------------����ʣ��" + count + "-----------------------------------");
    }
}
