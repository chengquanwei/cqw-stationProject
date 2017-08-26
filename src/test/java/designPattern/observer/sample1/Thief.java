package designPattern.observer.sample1;

public class Thief implements Watcher{  
	
    @Override  
    public void update() {  
         System.out.println("运输车有行动，强盗准备动手");  
    }  
}
