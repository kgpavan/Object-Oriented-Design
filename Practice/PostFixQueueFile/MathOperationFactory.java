package design.practice.designEx.PostFixQueueFile;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MathOperationFactory {

	public static List<MathCalculator> getCalculators(String expression) {
		List<MathCalculator> calculators = new ArrayList<MathCalculator>();
		String [] expressionParts = expression.split("\\s");
		Queue<Integer> operands = new LinkedList<Integer>();
		for (int i = 0; i < expressionParts.length; i++) {
			if(MathOperation.isMathOperation(expressionParts[i])){
				MathOperation mathOperation = MathOperation.getMathOperationByCode(expressionParts[i]);
				MathCalculator newMathCalculator = new MathCalculator(operands, mathOperation); 
				calculators.add(newMathCalculator);
				int result = newMathCalculator.calculate();
				operands = new LinkedList<Integer>();
				operands.add(result);
			}else{
				operands.add(Integer.parseInt(expressionParts[i]));
			}
		}
		return calculators;
	}

}
