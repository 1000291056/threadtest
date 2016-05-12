package threadtest.errorthought;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @deprecated
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService service=Executors.newFixedThreadPool(5);

		GoodsManager manager = new GoodsManager();
		Goods goods = new Goods(manager);
		ProductRunnable productRunnable = new ProductRunnable(goods, manager);
		ConsumeRunnable consumeRunnable = new ConsumeRunnable(goods, manager);
//		service.submit(productRunnable);
//		service.submit(consumeRunnable);
//		service.execute(productRunnable);
		service.execute(consumeRunnable);
		service.execute(consumeRunnable);
	}

}
