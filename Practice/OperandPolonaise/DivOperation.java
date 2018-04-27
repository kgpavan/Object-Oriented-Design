package design.practice.designEx.OperandPolonaise;

public class DivOperation implements Operation {

	private static DivOperation divOperation = new DivOperation();

	private DivOperation() {
	}

	@Override
	public int evaluate(int v1, int v2) {
		return v1 / v2;
	}

	public static Operation getInstance() {
		return divOperation;
	}

}
