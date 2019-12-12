package com.henrylsx.tutorial_14.gangoffourdesignpatterns.creation;

public class AbstractFactoryExample {
//on top of abstracting the object to be created, abstract the factory itself 
//i.e. factory of factories, for creating families of objects
	public static void main(String[] args) {
		System.out.println("Italian factory creates: "+ new ItalianPizzaFactory().createPizzaDough());
		System.out.println("Italian factory creates: "+ new ItalianPizzaFactory().createPizzaTopping());
		System.out.println("American factory creates: "+ new AmericanPizzaFactory().createPizzaDough());
		System.out.println("American factory creates: "+ new AmericanPizzaFactory().createPizzaTopping());
	}
}


abstract class PizzaFactory{	//factory itself is abstract
	//create an object where different factory may implement it differently
	public abstract PizzaDough createPizzaDough();	
	public abstract PizzaTopping createPizzaTopping();
}

abstract class PizzaDough{}
class ThinPizzaDough extends PizzaDough{}
class ThickPizzaDough extends PizzaDough{}
class ItalianPizzaFactory extends PizzaFactory{
	public PizzaDough createPizzaDough() {return new ThinPizzaDough();}
	public PizzaTopping createPizzaTopping() {return new SalamiTopping();}
}

abstract class PizzaTopping{}
class SalamiTopping extends PizzaTopping{}
class PineappleTopping extends PizzaTopping{}
class AmericanPizzaFactory extends PizzaFactory{
	public PizzaDough createPizzaDough() { return new ThickPizzaDough();}
	public PizzaTopping createPizzaTopping() { return new PineappleTopping();}
}