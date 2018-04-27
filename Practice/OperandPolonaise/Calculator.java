package design.practice.designEx.OperandPolonaise;

import java.util.LinkedList;
import java.util.Queue;

public class Calculator {

	public static void main(String[] args) {

		String s = "21 5 4 + 6 7 - 8 * 4 /";
		
		int x = polonaise(s);
		System.out.println(x);
	}

	private static int polonaise(String s) {

		Queue<Integer> queue = new LinkedList<Integer>();

		String elements[] = s.split("\\s");

		queue.add(Integer.parseInt(elements[0]));

		for (int i = 1; i < elements.length; i++) {

			char element = elements[i].charAt(0);
			
			if (isOperator(element)) {
				int result = queue.poll();
				Operation opetation = OperationFactory.create(element);
				while (!queue.isEmpty()) {
					result = opetation.evaluate(result, queue.poll());
				}
				queue.add(result);
			} else {
				queue.add(Integer.parseInt(elements[i]));
			}

		}
		return queue.poll();
	}

	private static boolean isOperator(char oper) {
		return !Character.isDigit(oper);
	}
}
