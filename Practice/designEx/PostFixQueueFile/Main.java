//package com.sqli.training.algorithm.postfix;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Main {
//
//	public static void main(String[] args) {
//		String filePath = "C:/Users/ADIL/Desktop/PostFix.txt";
//
//		List<String> lines = MathExpressionReader.readFile(filePath);
//		List<ExpressionCalculator> listExpressionCalculators = new ArrayList<ExpressionCalculator>();
//
//		for (String line : lines) {
//			List<MathCalculator> calculators = MathOperationFactory.getCalculators(line);
//			ExpressionCalculator newExpression = new ExpressionCalculator(calculators);
//			listExpressionCalculators.add(newExpression);
//		}
//		for (ExpressionCalculator expressionCalculator : listExpressionCalculators) {
//			System.out.println(">"+expressionCalculator.evaluate());
//		}
//
//	}
//}
