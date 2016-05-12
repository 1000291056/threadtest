package threadtest.errorthought;

/**
 * Created by wufeifei on 2016/4/11.
 * @deprecated
 */
public class InterruptTest extends Thread {
    @Override
    public void run() {
        int i = 50000;
        while (true) {
            if (this.isInterrupted()){
                break;
            }
            System.out.println(i--);
        }
        System.out.println("我被干了");
    }
}
