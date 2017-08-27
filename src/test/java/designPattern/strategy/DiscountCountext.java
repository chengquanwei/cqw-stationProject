package designPattern.strategy;

/**
 * 决策者
 * 为客户端代码选择合适折扣策略
 *
 */
public class DiscountCountext {
	private DiscountStrategy strategy;
	public DiscountCountext(DiscountStrategy strategy){
		this.strategy = strategy;
	}
	public double getDiscountPrice(double price){
		if(strategy == null){
			strategy = new OldDiscount();
		}
		return this.strategy.getDiscount(price);
	}
	//提供切换算法的方法
	public void changeDiscount(DiscountStrategy strategy){
		this.strategy = strategy;
	}
	public DiscountStrategy getStrategy() {
		return strategy;
	}
}
