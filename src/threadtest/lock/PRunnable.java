package threadtest.lock;

/**
 * Created by wufeifei on 2016/4/14.
 */
public class PRunnable implements Runnable {
    private Goods goods;

    public PRunnable(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        while (true) {
            goods.p();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
