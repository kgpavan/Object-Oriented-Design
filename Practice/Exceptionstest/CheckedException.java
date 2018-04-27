package design.practice.designEx.exceptionstest;


public class CheckedException extends Exception{

	@Override
	public String getMessage() {
		return "Message from Checked Exception";
	}
    
}
