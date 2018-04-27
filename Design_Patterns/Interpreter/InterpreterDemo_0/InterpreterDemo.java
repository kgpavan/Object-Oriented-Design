package com.sourcemaking.interpretator.second_example;

/**
 * "The pattern doesn't address parsing."
 * "When the grammar is very complex, other techniques (such as a parser)
 * are more appropriate."
 */

class StkChar {
    private char[] arr = new char[9];
    private int sp  = -1;

    void push(char ch) {
        if (!isFull()) {
            arr[++sp] = ch;
        }
    }

    char pop() {
        if (isEmpty()) {
            return '\0';
        }
        return arr[sp--];
    }

    boolean isFull() {
        return sp == arr.length-1;
    }

    boolean isEmpty() {
        return sp == -1;
    }
}

class StkInt {
    private int[] arr = new int[9];
    private int   sp  = -1;

    void push(int ch) {
        if (!isFull()) {
            arr[++sp] = ch;
        }
    }

    int pop() {
        if (isEmpty()) {
            return 0;
        }
        return arr[sp--];
    }

    boolean isFull() {
        return sp == arr.length-1;
    }

    boolean isEmpty() {
        return sp == -1;
    }
}

public class InterpreterDemo {
    public static com.sourcemaking.interpretator.first_example.before.InterpreterDemo interpreter
            = new com.sourcemaking.interpretator.first_example.before.InterpreterDemo();

    public static String convertToPostfix(String in) {
        StkChar operationsStack  = new StkChar();
        StringBuilder out = new StringBuilder();
        String operations  = "+-*/()";
        char topSymbol = '+';
        boolean empty;
        for (int i = 0; i < in.length(); i++) {
            if (operations.indexOf(in.charAt(i)) == -1)
                out.append(in.charAt(i));
            else {
                while (!(empty = operationsStack.isEmpty())
                        && interpreter.precedence(topSymbol = operationsStack.pop(), in.charAt(i)))
                    out.append(topSymbol);
                if (!empty) {
                    operationsStack.push(topSymbol);
                }
                if (empty || in.charAt(i) != ')') {
                    operationsStack.push(in.charAt(i));
                }
                else topSymbol = operationsStack.pop();
            }
        }
        while (!operationsStack.isEmpty()) {
            out.append( operationsStack.pop() );
        }
        return out.toString();
    }

    public static int evaluate( String in ) {
        StkInt stkInt = new StkInt();
        String operations = "+-*/";
        for (int a, b, i=0; i < in.length(); i++) {
            if (operations.indexOf(in.charAt(i)) == -1) {
                stkInt.push(in.charAt(i) - 48);
            } else {
                b = stkInt.pop();
                a = stkInt.pop();
                if (in.charAt(i) == '+') {
                    a = a + b;
                }
                if (in.charAt(i) == '-') {
                    a = a - b;
                }
                if (in.charAt(i) == '*') {
                    a = a * b;
                }
                if (in.charAt(i) == '/') {
                    a = a / b;
                }
                stkInt.push(a);
            }
        }
        return stkInt.pop();
    }

    public static void main( String[] args ) {
        System.out.print(args[0]);
        String postfix = convertToPostfix(args[0]);
        System.out.print( " -- " + postfix );
        System.out.println( " -- " + evaluate( postfix ) );
    }
}
