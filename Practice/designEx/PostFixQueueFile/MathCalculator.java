package design.practice.designEx.PostFixQueueFile;

import java.util.LinkedList;
import java.util.Queue;

public class MathCalculator {

	private Queue<Integer> operands;
	private MathOperation mathOperation;
	
	public MathCalculator(Queue<Integer> operands, MathOperation mathOperation) {
		this.operands = operands;
		this.mathOperation = mathOperation;
	}
	
	public int calculate() {
		Queue<Integer> queue = new LinkedList<Integer>(operands);
		int result = queue.poll();
		while( ! queue.isEmpty()){
			result = mathOperation.evalute(result, queue.poll());
		}
		return result;
	}

	public void addOperand(int operand) {
		operands.add(operand);
	}
	
}
