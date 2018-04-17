package design.practice.designEx.OperandPolonaise;

public class MultiOperation implements Operation {

	private static MultiOperation multiOperation = new MultiOperation();

	private MultiOperation() {
	}

	@Override
	public int evaluate(int v1, int v2) {
		return v1 * v2;
	}

	public static Operation getInstance() {
		return multiOperation;
	}

}
