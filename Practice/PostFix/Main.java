//package design.practice.designEx.PostFix;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//public class Main {
//
//    public static void main(String[] args) {
//        String input = "21 5 4 + 6 7 - 8 * 4 /";
//        List<MathCalculator> calculators = new ArrayList<MathCalculator>();
//        calculators = getMathCalculators(input);
//        int result = calculators.get(0).claculate();
//        for (int i = 1; i < calculators.size(); i++) {
//            System.out.println(result);
//            result = calculators.get(i).claculate();
//
//            if(i != calculators.size() - 1){
//                calculators.get(i).addOperand(result);
//            }
//        }
//        System.out.println("Result is : "+result);
//    }
//
//    private static List<MathCalculator> getMathCalculators(String input) {
//        List<MathCalculator> calculators = new ArrayList<MathCalculator>();
//        String [] listOperand = input.split("\\s");
//        List<Integer> operands = new ArrayList<Integer>();
//        for (int i = 0; i < listOperand.length; i++) {
//            if(MathOperation.isOperation(listOperand[i])){
//                MathCalculator calculator =
//                        new MathCalculator(operands, MathOperation.getMathOperationByCode(listOperand[i]));
//                calculators.add(calculator);
//                operands.clear();
//            }
//            else{
//                operands.add(Integer.parseInt(listOperand[i]));
//            }
//        }
//        return calculators;
//    }
//}
