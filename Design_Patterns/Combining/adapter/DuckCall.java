package design.design_patterns.combining.adapter;

public class DuckCall implements Quackable {

	public void quack() {
		System.out.println("Kwak");
	}
}
