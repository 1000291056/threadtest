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
//            System.out.println("���������");
            try {
                goods.product();
//                System.out.print(Thread.currentThread().getName() + "����     1   ��Ʒ");
//                System.out.println("------------------------ʣ��" + goods.getCount() + "-------------------------------");
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {

            } finally {
                lock.unlock();
//				System.out.println("�ͷ�������");
            }
        }
    }

    /**
     * �̹߳���
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
     * �̻߳���
     */
    public void resume() {
        if (pause) {
            System.out.println("�յ����������ź�");
            this.condition.signal();
            pause = false;
        }

    }
}
