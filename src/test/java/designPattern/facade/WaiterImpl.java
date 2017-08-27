package designPattern.facade;

public class WaiterImpl implements Waiter {

	@Override
	public void serve(String food) {
		System.out.println("服务生已将"+ food +"端过来，请慢用...");
	}

}
