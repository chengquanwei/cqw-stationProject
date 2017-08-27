package designPattern.strategy;

public class Test {

	public static void main(String[] args) {
		DiscountCountext dc = new DiscountCountext(null);
		double price1 = 79;
		System.out.println("79元的书默认打折后的价格：" + dc.getDiscountPrice(price1));
		
		dc.changeDiscount(new VipDiscount());
		double price2 = 89;
		System.out.println("89元的书VIP打折后的价格：" + dc.getDiscountPrice(price2));
		
	}

}
