package design.design_patterns.adapter.ducks;
import java.util.Random;

/**
* This class adapts a turkey to duck
*/
public class DuckAdapter implements Turkey {

	Duck duck;
	Random rand;
 
	public DuckAdapter(Duck duck) {
		this.duck = duck;
		rand = new Random();
	}
    
	public void gobble() {
		duck.quack();
	}
  
	public void fly() {
		if (rand.nextInt(5)  == 0) {
		     duck.fly();
		}
	}
}
