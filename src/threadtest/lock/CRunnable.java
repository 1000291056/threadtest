package threadtest.lock;

/**
 * Created by wufeifei on 2016/4/14.
 */
public class CRunnable implements Runnable {
    private Goods goods;

    public CRunnable(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        while (true) {
            goods.c();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
