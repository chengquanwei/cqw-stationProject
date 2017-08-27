package designPattern.bridge;

//桥接模式
public class Test {
	public static void main(String[] args){
		AbstractNoodle noodle = new BeefNoodle(new PepperyStyle());
		noodle.eat();
		AbstractNoodle noodle1 = new BeefNoodle(new PlainStyle());
		noodle1.eat();
		
	}
}
