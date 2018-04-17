package com.javacodegeeks.patterns.mediatorpattern;

public class Motor {
	
	public void startMotor(){
		System.out.println("Start motor...");
	}

	public void rotateDrum(int rpm){
		System.out.println("Rotating drum at "+rpm+" rpm.");
	}
}
