package com.henrylsx.tutorial_01.language.scope;

@SuppressWarnings("unused")
public class ScopeExample {
	int defaultScope = -1;	//package scope: accessible by class in same package only
	private int priv = 0;
	public int pub = 1;
	protected int prot = 2;	//package scope + subclasses anywhere
	
	public void testScope() {
		int x = defaultScope;
	}
}