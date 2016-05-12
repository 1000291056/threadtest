package threadtest.p_r_test;

/**
 * Created by wufeifei on 2016/4/13.
 * 生产者
 */
public class P {
    private String lock;

    public P(String lock) {
        this.lock = lock;
    }

    public void setValue() {
        try {
            synchronized (lock) {
                if (ValueObject.value.endsWith("")) {
                    lock.wait();
                }
                String value = System.currentTimeMillis() + "_" + System.nanoTime();
                System.out.println("set 的值是" + value);
                ValueObject.value = value;
                lock.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
