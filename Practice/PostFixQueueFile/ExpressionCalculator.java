package design.practice.designEx.PostFixQueueFile;

import java.util.List;

public class ExpressionCalculator {

	
	private List<MathCalculator> listCalculator;

	public ExpressionCalculator(List<MathCalculator> listCalculator) {
		this.listCalculator = listCalculator;
	}
	
	public int evaluate() {
		int indexLastCalculator = listCalculator.size() - 1;
		int result = listCalculator.get(indexLastCalculator).calculate();
		return result;
	}
}
