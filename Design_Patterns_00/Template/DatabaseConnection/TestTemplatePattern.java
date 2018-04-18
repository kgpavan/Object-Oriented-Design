package com.javacodegeeks.patterns.templatepattern;


/*
* The connection template pattern 
*/
public class TestTemplatePattern {

	public static void main(String[] args) {

		System.out.println("For MYSQL....");
		ConnectionTemplate template = new MySqLCSVCon();
		template.run();
		
		System.out.println("\nFor Oracle...");
		template = new OracleTxtCon();
		template.run();
	}
}
