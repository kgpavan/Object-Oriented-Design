//package com.sqli.training.algorithm.postfix;
//
//import java.util.List;
//
//
//public class MathCalculator {
//
//    private List<Integer> operands;
//    private MathOperation mathOperationByCode;
//    public MathCalculator(List<Integer> operands, MathOperation mathOperation) {
//        this.operands = operands;
//        this.mathOperationByCode = mathOperation;
//    }
//    public void addOperand(int operand) {
//        this.operands.add(operand);
//    }
//    public int claculate() {
//        int result = operands.get(0);
//        for (int i = 1; i < operands.size(); i++) {
//            result = mathOperationByCode.calculate(result, operands.get(i));
//
//
//        }
//        return result;
//    }
//
//
//}
