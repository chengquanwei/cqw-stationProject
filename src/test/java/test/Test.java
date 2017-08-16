package test;

import designPattern.singleton.Singleton1;
import designPattern.singleton.Singleton7;


public class Test {
		
		public static void main(String[] args) {
			Singleton1 s1 = Singleton1.getInstance();
			Singleton1 s2 = Singleton1.getInstance();
			System.out.println(s1 == s2);
			Singleton7 sin1 = Singleton7.getSingleton();
			Singleton7 sin2 = Singleton7.getSingleton();
			System.out.println(sin1 == sin2);
		}
}
