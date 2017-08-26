package designPattern.observer.sample2;

public class PriceObserver implements Observer {

	@Override
	public void update(Observable o, Object obj) {
		if(obj instanceof Double){
			System.out.println("价格观察者：" + o + "物品价格已经改变为：" + obj);
		}
	}

}
