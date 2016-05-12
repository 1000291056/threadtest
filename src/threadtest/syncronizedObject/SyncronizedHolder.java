package threadtest.syncronizedObject;

/**
 * Created by wufeifei on 2016/4/15.
 */
public class SyncronizedHolder {
    private SyncronizedOnject syncronizedOnject;

    public SyncronizedHolder(SyncronizedOnject syncronizedOnject) {
        this.syncronizedOnject = syncronizedOnject;
    }

    public void test() {
        synchronized (syncronizedOnject) {
            try {
                System.out.println(Thread.currentThread().getName() + "SyncronizedHolder begin");
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + "SyncronizedHolder end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
