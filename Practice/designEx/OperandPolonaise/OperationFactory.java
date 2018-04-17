package design.practice.designEx.OperandPolonaise;

public final class OperationFactory {

	private OperationFactory() {
	}
	public static Operation create(char op) {

		switch (op) {
		case '+':
			return AddOperation.getInstance();
		case '-':
			return MinusOperation.getInstance();
		case '*':
			return MultiOperation.getInstance();
		case '/':
			return DivOperation.getInstance();
		default:
			throw new RuntimeException("Invalid Operation");
		}
	}

}
