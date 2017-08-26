package designPattern.observer.sample1;

public class Police implements Watcher{  
	
    @Override  
    public void update(){  
         System.out.println("运输车有行动，警察护航");  
    }  
}
