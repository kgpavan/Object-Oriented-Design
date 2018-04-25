package design.design_patterns.combining.adapter;

public class DecoyDuck implements Quackable {

    public void quack() {
        System.out.println("<< Silence >>");
    }
}
