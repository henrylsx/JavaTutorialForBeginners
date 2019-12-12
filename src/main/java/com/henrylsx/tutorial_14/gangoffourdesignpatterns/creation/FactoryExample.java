package com.henrylsx.tutorial_14.gangoffourdesignpatterns.creation;

public class FactoryExample {
// for creating objects of various classes that inherit same superclass without specifying the class
	public static void main(String[] args) {
		System.out.println(PastaFactory.createPasta("BOLOGNESE"));
		System.out.println(PastaFactory.createPasta("CARBONARA"));
	}
	
}

class PastaFactory {
	public static Pasta createPasta(String pastaMenu) {
		if (pastaMenu.equals("CARBONARA")) {return new PastaCarbonara();}
		else if (pastaMenu.equals("BOLOGNESE")) {return new PastaBolognese();}
		else return null;
	}
}

abstract class Pasta {}
class PastaCarbonara extends Pasta {}
class PastaBolognese extends Pasta {}
