package com.henrylsx.tutorial_14.gangoffourdesignpatterns.creation;

public class SingletonExample {
//for ensuring only one single object of this type in memory
	public static void main(String[] args) {
		System.out.println(InnerStaticClassSingleton.getInstance());//By Bill Pugh
		System.out.println(SynchronizedStaticSingleton.getInstance());	
		System.out.println(StaticBlockSingleton.INSTANCE);
		System.out.println(EnumSingleton.INSTANCE);
	}
}

class InnerStaticClassSingleton {
	private InnerStaticClassSingleton() {
	}

	//the most perfect singleton so far, but may have issue with hashcode so don't insert into hashmap(why would you anyway?)
	private static class SingletonHolder {
		public static final InnerStaticClassSingleton instance = new InnerStaticClassSingleton();
	}

	public static InnerStaticClassSingleton getInstance() {
		return SingletonHolder.instance;
	}
}

class SynchronizedStaticSingleton {
	private static SynchronizedStaticSingleton INSTANCE;
	private SynchronizedStaticSingleton() {}
	
	//synchronized keyword make it thread safe, problem is it is not very optimized
	public synchronized static SynchronizedStaticSingleton getInstance() {
		return (INSTANCE == null) ? new SynchronizedStaticSingleton() : INSTANCE; 
	}
}

enum EnumSingleton {
	INSTANCE;
	//instance is part of enumerations, problem is this class is not extendable
	
	public EnumSingleton getInstance() {
		return INSTANCE;
	}
}

class StaticBlockSingleton{
	public static StaticBlockSingleton INSTANCE;
	private StaticBlockSingleton() {}
	
	//static block executed immediately, problem is it always gets created no matter what
	{
		INSTANCE = new StaticBlockSingleton();
	}
}