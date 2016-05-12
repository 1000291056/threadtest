package threadtest.errorthought;

import java.util.ArrayList;
import java.util.List;

/**
 * @deprecated
 */
public class GoodsManager {
	private List<ConsumeRunnable> listC = new ArrayList<>();
	private List<ProductRunnable> listP = new ArrayList<>();

	public List<ConsumeRunnable> getListC() {
		return listC;
	}

	public void setListC(List<ConsumeRunnable> listC) {
		this.listC = listC;
	}

	public List<ProductRunnable> getListP() {
		return listP;
	}

	public void setListP(List<ProductRunnable> listP) {
		this.listP = listP;
	}

	/**
	 *通知消费
	 */
	public void signalConsume() {
		for (int i = 0; i < listC.size(); i++) {
			ConsumeRunnable runnable = listC.get(i);
			runnable.resume();
		}
	}

	/**
	 * ֪ͨ通知生产
	 */
	public void signalProduct() {
		for (int i = 0; i < listP.size(); i++) {
			ProductRunnable runnable = listP.get(i);
			runnable.resume();
		}
	}
	/**
	 * ֪ͨ暂停消费
	 */
	public void awaitConsume() {
		for (int i = 0; i < listC.size(); i++) {
			ConsumeRunnable runnable = listC.get(i);
			runnable.pause();
		}
	}

	/**
	 * ֪ͨ暂停生产
	 */
	public void awaitProduct() {
		for (int i = 0; i < listP.size(); i++) {
			ProductRunnable runnable = listP.get(i);
			runnable.pause();
		}
	}
	public void singnalAll() {
		signalConsume();
		signalProduct();
	}
}
