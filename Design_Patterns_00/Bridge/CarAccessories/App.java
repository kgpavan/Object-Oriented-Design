package com.car;

public class App{

   public static void main( String[] args ){

   	    System.out.println();
        System.out.println( "Hello! Bridge Design Pattern" );
        System.out.println();

        Product product = new CentralLocking("Central Locking System");
		Product product2 = new GearLocking("Gear Locking System");

		Car car = new BigWheel(product , "BigWheel xz model");

		car.produceProduct();
		car.assemble();
		car.printDetails();

		System.out.println();

		car = new BigWheel(product2 , "BigWheel xz model");
		car.produceProduct();
		car.assemble();
		car.printDetails();

		System.out.println("-----------------------------------------------------");

		car = new Motoren(product, "Motoren lm model");
		car.produceProduct();
		car.assemble();
		car.printDetails();

		System.out.println();

		car = new Motoren(product2, "Motoren lm model");
		car.produceProduct();
		car.assemble();
		car.printDetails();

		System.out.println();
   }
}
