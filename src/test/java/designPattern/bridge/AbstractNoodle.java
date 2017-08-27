package designPattern.bridge;

public abstract class AbstractNoodle {
	protected Peppery style;
	public AbstractNoodle(Peppery style){
		this.style = style;
	}
	public abstract void eat();
	public abstract void eat1();
}
