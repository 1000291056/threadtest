package threadtest.errorthought;

import java.util.Random;

/**
 * @deprecated
 */
public class Goods {
    private GoodsManager goodsManager;

    public Goods(GoodsManager goodsManager) {
        this.goodsManager = goodsManager;
    }

    private int count = 99;
    /**
     * 最大库存
     */
    public static final int MAX = 99;
    private Random random = new Random();

    /**
     * 生产
     */
    public void product() {
        count++;
//        if (count >= MAX) {//达到饱和值停止生产
//            goodsManager.awaitProduct();
//        }
//        goodsManager.signalConsume();
    }

    /**
     * 消费
     */
    public int consume() {
        int temp = random.nextInt(10) + 1;
        if (temp > count) {
            return 0;
        }
        count -= temp;
//        if (count <= 0) {//通知停止消费线程    若生产线程在等待则激活
//            goodsManager.awaitConsume();
//            goodsManager.signalProduct();
//        }
        return temp;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
