package design.design_patterns.strategy.strategy;/*
Strategy is a behavioural software design pattern that enables 
an algorithm's behavior to be selected at runtime.
*/

interface TextFormatter {
	public void format(String text);
}

class CapTextFormatter implements TextFormatter {

	@Override
	public void format(String text) {
		System.out.println("[CapTextFormatter]: "+text.toUpperCase());
	}
}

class LowerTextFormatter implements TextFormatter {

	@Override
	public void format(String text) {
		System.out.println("[LowerTextFormatter]: "+text.toLowerCase());
	}
}

class TextEditor {

	private final TextFormatter textFormatter;
	public TextEditor(TextFormatter textFormatter){
		this.textFormatter = textFormatter;
	}

	public void publishText(String text){
		textFormatter.format(text);
	}
}

public class TestStrategyPattern {

	public static void main(String[] args) {
		
		
		TextFormatter formatter = new CapTextFormatter();
		TextEditor editor = new TextEditor(formatter);
		editor.publishText("Testing text in caps formatter");
		
		formatter = new LowerTextFormatter();
		editor = new TextEditor(formatter);
		editor.publishText("Testing text in lower formatter");
	}
}