package com.javacodegeeks.patterns.visitorpattern;

public interface Element {
	
	public void accept(Visitor visitor);
}
