package designPattern.observer.sample2;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class NameObserver implements Observer {

	@Override
	public void update(Observable o, Object obj) {
		if(obj instanceof String){
			String name = (String) obj;
			JFrame f = new JFrame("观察者");
			JLabel l = new JLabel("名称改变为：" + name);
			f.add(l);
			f.pack();
			f.setVisible(true);
			System.out.println("名称观察者：" + o + "物品名称已经改变为：" + name);
		}
	}

}
