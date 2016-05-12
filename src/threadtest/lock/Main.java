package threadtest.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wufeifei on 2016/4/14.
 */
public class Main {
    private static ExecutorService service = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        Goods goods = new Goods();
        PRunnable p = new PRunnable(goods);
        CRunnable c = new CRunnable(goods);
        service.execute(p);
        service.execute(p);
        service.execute(c);
        service.execute(c);
        service.execute(c);

    }
}
