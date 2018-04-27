
/**
 * AdvancedSorceress implements inversion of control. It depends 
 * on abstraction  that can be injected through its setter.
 */
public class AdvancedSorceress implements Wizard {

	private Tobacco tobacco;

	public void setTobacco(Tobacco tobacco) {
		this.tobacco = tobacco;
	}

	@Override
	public void smoke() {
		tobacco.smoke(this);
	}
}
