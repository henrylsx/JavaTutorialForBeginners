package com.henrylsx.tutorial_14.gangoffourdesignpatterns.creation;

public class BuilderExample {
//have a builder class that is passed in to director class to construct the actual object
//for building very complex objects that require the creation to be in sequential step by step
	public static void main(String[] args) {
		HousingEngineer engineer1 = new HousingEngineer(new ConcreteHouseBuilder());
		System.out.println("House Engineer directing concrete house builder");
		engineer1.constructHouse();
		HousingEngineer engineer2 = new HousingEngineer(new TreeHouseBuilder());
		System.out.println("House Engineer directing tree house builder");
		engineer2.constructHouse();		
	}

}

class House {
	String roof, foundation;
	boolean painted;
}

class TreeHouse extends House {
}

class ConcreteHouse extends House {
}

abstract class HouseBuilder {
	House house;

	public House getHouse() {
		return house;
	}

	public abstract void createRoof();

	public abstract void createFoundation();

	public abstract void paintHouse();
}

class ConcreteHouseBuilder extends HouseBuilder {
	public ConcreteHouseBuilder() {
		this.house = new ConcreteHouse();
	}

	public void createRoof() {
		house.roof = "wood and stones";
		System.out.println("Creating roof from wood and stones");
	}

	public void createFoundation() {
		house.foundation = "bricks and cements";
		System.out.println("Creating foundation from bricks, cement and steel");
	}

	public void paintHouse() {
		house.painted = true;
		System.out.println("Painting the house");
	}
}

class TreeHouseBuilder extends HouseBuilder {
	public TreeHouseBuilder() {
		this.house = new TreeHouse();
	}

	public void createRoof() {
		house.roof = "wood and leaves";
		System.out.println("Creating roof from wood and leaves");
	}

	public void createFoundation() {
		house.foundation = "wood and ropes";
		System.out.println("Creating foundation from wood and ropes");
	}

	public void paintHouse() {
		house.painted = true;
		System.out.println("Painting the house");
	}
}

//director class
class HousingEngineer {
	HouseBuilder builder;

	private HousingEngineer() {
	}

	public HousingEngineer(HouseBuilder builder) {
		this.builder = builder;
	}

	public House constructHouse() {
		builder.createFoundation();
		builder.createRoof(); // cannot create the roof if no foundation
		builder.paintHouse(); // cannot paint the house if no house yet
		return builder.getHouse();
	}
}