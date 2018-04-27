package design.practice.designEx.exceptionstest;


public class UncheckedException extends RuntimeException{

	@Override
	public String getMessage() {
		return "Message from Unchecked Exception";
	}
}
