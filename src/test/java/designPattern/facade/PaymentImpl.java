package designPattern.facade;

public class PaymentImpl implements Payment{
	public String pay(){
		String food = "快餐";
		System.out.println("你已向收银员支付了费用，您购买的食物是：" + food);
		return food;
	}
}
