package designPattern.bridge;

public class BeefNoodle extends AbstractNoodle {

	public BeefNoodle(Peppery style) {
		super(style);
	}

	@Override
	public void eat() {
		System.out.println("牛肉面"+super.style.style());
	}

	@Override
	public void eat1() {
		// TODO Auto-generated method stub
		
	}

}
