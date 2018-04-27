//import java.util.LinkedList;
//import java.util.Queue;
//
//
//
//public class Main {
//
//    public static void main(String[] args) {
//        String input = "21 5 4 + 6 7 - 8 * 4 /";
//
//        System.out.println(getResultOperation(input));
//    }
//
//    private static Integer getResultOperation(String input) {
//
//        String [] opElements = input.split("\\s");
//        Queue<Integer>  queue = new LinkedList<Integer>();
//        int result = Integer.parseInt(opElements[0]);
//        queue.add(Integer.parseInt(opElements[0]));
//        for (int i = 1; i < opElements.length; i++) {
//            if(isOperation(opElements[i].charAt(0))){
//                result = calculate(queue, opElements[i]);
//                queue.add(result);
//            }else{
//                queue.add(Integer.parseInt(opElements[i]));
//            }
//        }
//        return result;
//    }
//
//    private static int calculate(Queue<Integer> queue, String mathOperation) {
//        int result = queue.poll();
//        while( ! queue.isEmpty()){
//            result = caclulateExpression(result, queue.poll(), mathOperation.charAt(0));
//        }
//        return result;
//
//    }
//
//    private static int caclulateExpression(int operand1, Integer operand2, char mathOperation) {
//
//        switch(mathOperation){
//        case '+': return Add(operand1, operand2);
//        case '-': return Sub(operand1, operand2);
//        case '*': return Mul(operand1, operand2);
//        case '/': return Div(operand1, operand2);
//        }
//        return 0;
//    }
//
//    private static int Div(int operand1, Integer operand2) {
//        return operand1 / operand2;
//    }
//
//    private static int Mul(int operand1, Integer operand2) {
//        return operand1 * operand2;
//    }
//
//    private static int Sub(int operand1, Integer operand2) {
//        return operand1 - operand2;
//    }
//
//    private static int Add(int operand1, Integer operand2) {
//        return operand1 + operand2;
//    }
//
//    private static boolean isOperation(char operation) {
//        return "+-/*".indexOf(operation) != -1;
//    }
//
//
//}
