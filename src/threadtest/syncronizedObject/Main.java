package threadtest.syncronizedObject;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wufeifei on 2016/4/15.
 * syncronized(x),其他对象执行x的syncronized方法
 */
public class Main {
    private static ExecutorService service = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        SyncronizedOnject syncronizedOnject = new SyncronizedOnject();
        SyncronizedHolder syncronizedHolder = new SyncronizedHolder(syncronizedOnject);
        Runnable run0 = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    syncronizedOnject.test();
                }
            }
        };
        Runnable run1 = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    syncronizedOnject.test1();
                }
            }
        };
        service.execute(run0);service.execute(run0);
        service.execute(run1);service.execute(run1);
    }
}
