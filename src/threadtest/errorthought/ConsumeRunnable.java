package threadtest.errorthought;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @deprecated
 */
public class ConsumeRunnable implements Runnable {
    private Goods goods;
    private GoodsManager goodsManager;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private boolean pause;

    public ConsumeRunnable(Goods goods, GoodsManager goodsManager) {
        super();
        this.goods = goods;
        this.goodsManager = goodsManager;
        goodsManager.getListC().add(this);
    }

    @Override
    public void run() {
        while (true) {
            lock.lock();
            System.out.print(Thread.currentThread().getName() +"获得消费锁");
            try {
                System.out.print(Thread.currentThread().getName() + "消费      " + goods.consume() + "   个产品");
                System.out.print("------------------------剩余" + goods.getCount() + "-------------------------------");
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {

            } finally {

                lock.unlock();
				System.out.println(Thread.currentThread().getName() +"释放消费锁");
            }

        }

    }

    /**
     * ??????
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
     * ??????
     */
    public void resume() {
        if (pause) {
            this.condition.signal();
            pause = false;
        }

    }
}
