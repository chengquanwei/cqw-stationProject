package designPattern.facade;

public class Facade {
	Payment pay;
	Cook cook;
	Waiter waiter;
	public Facade(){
		this.pay = new PaymentImpl();
		this.cook = new CookImpl();
		this.waiter = new WaiterImpl();
	}
	public void serveeFood(){
		String food = pay.pay();
		food = cook.cook(food);
		waiter.serve(food);
	}
}
