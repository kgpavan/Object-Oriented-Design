package design.practice.designEx.PostFixQueueFile;

public enum MathOperation {

	ADD("+") {
		@Override
		public int evalute(int operand1, int operand2) {
			return operand1 + operand2;
		}
	}, SUB("-") {
		@Override
		public int evalute(int operand1, int operand2) {
			return operand1 - operand2;
		}
	}, DIV("/") {
		@Override
		public int evalute(int operand1, int operand2) {
			return operand1 / operand2;
		}
	}, MUL("*") {
		@Override
		public int evalute(int operand1, int operand2) {
			return operand1 * operand2;
		}
	};
	
	private String code;
	
	private MathOperation(String code) {
		this.code = code;
	}
	
	public static MathOperation getMathOperationByCode(String code){
		for (MathOperation mathOperation : values()) {
			if(mathOperation.code.equals(code)){
				return mathOperation;
			}
		}
		return null;
	}

	public abstract int evalute(int operand1, int operand2);

	public static boolean isMathOperation(String code) {
		return "+-*/".indexOf(code) != -1;
	}
}
