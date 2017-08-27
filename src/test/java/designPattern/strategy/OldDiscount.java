package designPattern.strategy;

public class OldDiscount implements DiscountStrategy {

	@Override
	public double getDiscount(double originPrice) {
		System.out.println("使用旧书折扣...");
		return originPrice * 0.7;
	}

}
