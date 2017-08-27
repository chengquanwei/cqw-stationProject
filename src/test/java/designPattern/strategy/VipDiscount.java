package designPattern.strategy;

public class VipDiscount implements DiscountStrategy {

	@Override
	public double getDiscount(double originPrice) {
		System.out.println("使用VIP折扣...");
		return originPrice * 0.5;
	}

}
