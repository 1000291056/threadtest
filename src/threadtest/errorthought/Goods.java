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
     * �����
     */
    public static final int MAX = 99;
    private Random random = new Random();

    /**
     * ����
     */
    public void product() {
        count++;
//        if (count >= MAX) {//�ﵽ����ֵֹͣ����
//            goodsManager.awaitProduct();
//        }
//        goodsManager.signalConsume();
    }

    /**
     * ����
     */
    public int consume() {
        int temp = random.nextInt(10) + 1;
        if (temp > count) {
            return 0;
        }
        count -= temp;
//        if (count <= 0) {//ֹ֪ͨͣ�����߳�    �������߳��ڵȴ��򼤻�
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
