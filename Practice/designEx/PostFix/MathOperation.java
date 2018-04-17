//package com.sqli.training.algorithm.postfix;
//
//
//public enum MathOperation {
//
//    SUB("-") {
//
//        @Override
//        public int calculate(int operand1, Integer operand2) {
//            return operand1 - operand2;
//        }
//    }, ADD("+") {
//
//        @Override
//        public int calculate(int operand1, Integer operand2) {
//            return operand1 + operand2;
//        }
//    }, MUL("*") {
//
//        @Override
//        public int calculate(int operand1, Integer operand2) {
//            return operand1 * operand2;
//        }
//    }, DIV("/") {
//
//        @Override
//        public int calculate(int operand1, Integer operand2) {
//            return operand1 / operand2;
//        }
//    };
//
//    private String code;
//
//
//    private MathOperation(String code) {
//        this.code = code;
//    }
//
//    public static MathOperation getMathOperationByCode(String code) {
//        for (MathOperation mathOperation : values()) {
//            if(mathOperation.code.equals(mathOperation)){
//                return mathOperation;
//            }
//        }
//        return null;
//    }
//
//    public static boolean isOperation(String code) {
//        if(code.equals("+") || code.equals("-") || code.equals("/") || code.equals("*") ){
//            return true;
//        }
//        return false;
//    }
//
//    public abstract int calculate(int result, Integer operand);
//
//}
