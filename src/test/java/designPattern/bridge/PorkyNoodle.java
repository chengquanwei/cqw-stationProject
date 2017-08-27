package designPattern.bridge;

public class PorkyNoodle extends AbstractNoodle {

	public PorkyNoodle(Peppery style) {
		super(style);
	}

	@Override
	public void eat() {
		System.out.println("猪肉面条"+super.style.style());
	}

	@Override
	public void eat1() {
		// TODO Auto-generated method stub
		
	}

}
