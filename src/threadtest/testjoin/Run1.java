package threadtest.testjoin;

/**
 * Created by wufeifei on 2016/4/14.
 */
public class Run1 {
    public static void main(String[] args) {
        try {
            ThreadB b = new ThreadB();
            TheadA a = new TheadA(b);
            a.start();
            b.start();
            b.join(2000);
            System.out.println("\t main end"+System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
