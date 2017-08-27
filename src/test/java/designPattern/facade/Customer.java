package designPattern.facade;

import org.junit.Test;

public class Customer {
	
	//在没用使用门面模式的情况下，顾客用餐流程
	@Test
	public void haveDinner(){
		Payment pay = new PaymentImpl();
		Cook cook = new CookImpl();
		Waiter waiter = new WaiterImpl();
		String food = pay.pay();
		food = cook.cook(food);
		waiter.serve(food);
	}
	
	//使用门面模式的情况下，顾客用餐流程
	@Test
	public void haveDinnerFacade(){
		Facade f = new Facade();
		f.serveeFood();
	}
	
}
