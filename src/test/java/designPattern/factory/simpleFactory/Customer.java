package designPattern.factory.simpleFactory;

/**
 * 简单工厂模式又称静态工厂方法模式
 * 它存在的目的很简单：定义一个用于创建对象的接口
 *       先来看看它的组成： 
         1) 工厂类角色：这是本模式的核心，含有一定的商业逻辑和判断逻辑，用来创建产品
         2) 抽象产品角色：它一般是具体产品继承的父类或者实现的接口。         
         3) 具体产品角色：工厂类所创建的对象就是此角色的实例。在Java中由一个具体类实现。 
 */
public class Customer {

    public static void main(String[] args) {  
        Factory factory = new Factory();  
        BMW bmw320 = factory.createBMW(320);  
        BMW bmw523 = factory.createBMW(523);  
    } 
}
