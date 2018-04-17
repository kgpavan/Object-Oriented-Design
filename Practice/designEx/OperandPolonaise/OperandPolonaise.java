package design.practice.designEx.OperandPolonaise;

import java.util.Collections;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OperandPolonaise {

	enum Operation {
		plus('+') {
			@Override
			public int operation(int a, int b) {
				return a + b;
			}
		},
		min('-') {
			@Override
			public int operation(int a, int b) {
				return a - b;
			}
		},
		Mult('x') {
			@Override
			public int operation(int a, int b) {
				return a * b;
			}
		},
		div('/') {
			@Override
			public int operation(int a, int b) {
				return a / b;
			}

		};

		public char operator;

		public static Operation getByCode(char c) {
			for (Operation operation : Operation.values()) {
				if (operation.operator == c)
					return operation;
			}
			return Operation.plus;
		}

		Operation(char op) {
			this.operator = op;
		}

		public abstract int operation(int a, int b);

	}

	public static void main(String[] args) {

		String s = "21 5 4 + 6 7 - 8 x 4 /";
		System.out.println(operationPolonaise(s));
	}

	public static int operationPolonaise(String str) {

		Pattern pattern = Pattern.compile("[0-9]+|[+-x/]");
		Matcher matcher = pattern.matcher(str);
		Stack<Integer> stack = new Stack<Integer>();
		int result = 0;
		while (matcher.find()) {
			String element = matcher.group();
			char op = element.charAt(0);
			if (isOperator(op)) {
				stack.push(Integer.parseInt(element));
			} else {
				Operation operation = Operation.getByCode(op);
				Collections.reverse(stack);
				result = stack.pop();
				while (!stack.isEmpty()) {
					result = operation.operation(result, stack.pop());
				}
				stack.push(result);
			}
		}
		return stack.pop();

	}

	private static boolean isOperator(char element) {
		return !Character.isDigit(element);
	}
}
