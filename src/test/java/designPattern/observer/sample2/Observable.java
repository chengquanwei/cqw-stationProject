package designPattern.observer.sample2;

import java.util.ArrayList;
import java.util.List;

//所有被观察者的基类
public abstract class Observable {
	List<Observer> observers = new ArrayList<Observer>();
	
	public void registObserver(Observer o){
		observers.add(o);
	}
	
	public void removeObserver(Observer o){
		observers.remove(o);
	}
	
	public void notifyObservers(Object value){
		for(Observer o : observers){
			o.update(this, value);
		}
	}
}
