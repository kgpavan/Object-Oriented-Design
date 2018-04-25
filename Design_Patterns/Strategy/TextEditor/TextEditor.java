package com.javacodegeeks.patterns.strategypattern;

public class TextEditor {
	
	private final TextFormatter textFormatter;
	
	public TextEditor(TextFormatter textFormatter){
		this.textFormatter = textFormatter;
	}
	
	public void publishText(String text){
		textFormatter.format(text);
	}

}
