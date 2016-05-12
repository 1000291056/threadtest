package threadtest.syncronizedObject;

/**
 * Created by wufeifei on 2016/4/15.
 */
public class SyncronizedOnject {
    synchronized public void test() {
        try {
            System.out.println(Thread.currentThread().getName() + "test SyncronizedOnject begin");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "test SyncronizedOnject end");
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }

    synchronized public void test1() {
        try {
            System.out.println(Thread.currentThread().getName() + "test1 SyncronizedOnject begin");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "test1 SyncronizedOnject end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
