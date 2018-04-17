package design.practice.designEx.OperandPolonaise;

public class AddOperation implements Operation {


	private static AddOperation addOperation = new AddOperation();

	private AddOperation() {
	}

	@Override
	public int evaluate(int v1, int v2) {
		return v1 + v2;
	}

	public static Operation getInstance() {
		return addOperation;
	}

}
