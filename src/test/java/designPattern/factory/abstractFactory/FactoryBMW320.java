package designPattern.factory.abstractFactory;

public class FactoryBMW320 implements AbstractFactory{    
    
	@Override    
	public Engine createEngine() {      
	    return new EngineA();    
	}    
	@Override    
	public Aircondition createAircondition() {    
	    return new AirconditionA();    
	}    
}
