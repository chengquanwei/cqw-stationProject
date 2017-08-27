package designPattern.facade;

public class CookImpl implements Cook {

	@Override
	public String cook(String food) {
		System.out.println("厨师正在烹饪：" + food);
		return food;
	}

}
