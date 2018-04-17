package design.practice.designEx.OperandPolonaise;

public class MinusOperation implements Operation {

	private static MinusOperation minusOperation = new MinusOperation();

	private MinusOperation() {
	}

	@Override
	public int evaluate(int v1, int v2) {
		return v1 - v2;
	}

	public static Operation getInstance() {
		return minusOperation;
	}
}
