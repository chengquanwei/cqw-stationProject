package designPattern.observer;

import designPattern.observer.sample2.NameObserver;
import designPattern.observer.sample2.PriceObserver; 
import designPattern.observer.sample2.Product;

public class Test {
	
	public static void main(String[] arg){
		Product p = new Product("电视机",176);
		NameObserver no = new NameObserver();
		PriceObserver po = new PriceObserver();
		p.registObserver(po);
		p.registObserver(no);
		p.setName("书桌");
		p.setPrice(345);
	}
}
