package test;

import designPattern.observer.sample1.Police;
import designPattern.observer.sample1.Security;
import designPattern.observer.sample1.Thief;
import designPattern.observer.sample1.Transporter;
import designPattern.proxy.dynamicProxy.IUserDao;
import designPattern.proxy.dynamicProxy.ProxyFactory;
import designPattern.proxy.staticProxy.UserDao;
import designPattern.proxy.staticProxy.UserDaoProxy;
import designPattern.singleton.Singleton1;
import designPattern.singleton.Singleton7;


public class Test {
		
		public static void main(String[] args) {
			//单例模式测试
			System.out.println("-----------------------单例模式--------------------------");
			Singleton1 s1 = Singleton1.getInstance();
			Singleton1 s2 = Singleton1.getInstance();
			System.out.println(s1 == s2);
			Singleton7 sin1 = Singleton7.getSingleton();
			Singleton7 sin2 = Singleton7.getSingleton();
			System.out.println(sin1 == sin2);
			
			//代理模式测试
			System.out.println("-----------------------静态代理--------------------------");
			//目标对象
	        UserDao target1 = new UserDao();
	        //代理对象,把目标对象传给代理对象,建立代理关系
	        UserDaoProxy proxy1 = new UserDaoProxy(target1);
	        proxy1.save();//执行的是代理的方法
	        System.out.println("-----------------------动态代理--------------------------");
	        // 目标对象
	        IUserDao target2 = new designPattern.proxy.dynamicProxy.UserDao();
	        // 【原始的类型 class cn.itcast.b_dynamic.UserDao】
	        System.out.println(target2.getClass());
	        // 给目标对象，创建代理对象
	        IUserDao proxy2 = (IUserDao) new ProxyFactory(target2).getProxyInstance();
	        // class $Proxy0   内存中动态生成的代理对象
	        System.out.println(proxy2.getClass());
	        // 执行方法   【代理对象】
	        proxy2.save();
	        
	        System.out.println("-----------------------Cglib子类代理--------------------------");
	        //目标对象
//	        designPattern.proxy.cglibProxy.UserDao target3 = new designPattern.proxy.cglibProxy.UserDao();
//	        //代理对象
//	        designPattern.proxy.cglibProxy.UserDao proxy3 = (designPattern.proxy.cglibProxy.UserDao)new ProxyFactory(target3).getProxyInstance();
//	        //执行代理对象的方法
//	        proxy3.save();
	        System.out.println("-----------------------观察者模式--------------------------");
	          Transporter transporter = new Transporter();  
	          Police police = new Police();  
	          Security security = new Security();  
	          Thief thief = new Thief();  
	          transporter.addWatcher(police);  
	          transporter.addWatcher(security);  
	          transporter.addWatcher(thief);  
	          transporter.notifyWatchers();
		}
}
