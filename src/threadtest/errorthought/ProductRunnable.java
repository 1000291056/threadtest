package threadtest.errorthought;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @deprecated
 */
public class ProductRunnable implements Runnable {
    private Goods goods;
    private GoodsManager goodsManager;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private boolean pause;

    public ProductRunnable(Goods goods, GoodsManager goodsManager) {
        super();
        this.goods = goods;
        this.goodsManager = goodsManager;
        goodsManager.getListP().add(this);
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        while (true) {
            lock.lock();
//            System.out.println("获得生产锁");
            try {
                goods.product();
//                System.out.print(Thread.currentThread().getName() + "生产     1   产品");
//                System.out.println("------------------------剩余" + goods.getCount() + "-------------------------------");
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {

            } finally {
                lock.unlock();
//				System.out.println("释放生产锁");
            }
        }
    }

    /**
     * 线程挂起
     */
    public void pause() {
        try {
            this.condition.await();
            pause = true;
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 线程唤醒
     */
    public void resume() {
        if (pause) {
            System.out.println("收到唤醒生产信号");
            this.condition.signal();
            pause = false;
        }

    }
}
