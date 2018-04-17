package design.practice.designEx.FizzBuzz;

import java.io.StringWriter;


public class FizzBuzz2 {

    private int start;
    private int end;
    private static final String fizzString = "Fizz";
    private static final String buzzString = "Buzz";
    private static final int fizzLeap = 3;
    private static final int buzzLeap = 5;
    
    
    public FizzBuzz2(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public void generate(StringWriter out) {
        for (int line = this.start; line <= this.end; line++) {
            lineStart(out, line);
            appendFizzBuzz(out, line);
            lineEnd(out);
        }
        
    }

    private void lineEnd(StringWriter out) {
        out.append("\n");
    }

    private void lineStart(StringWriter out, int line) {
        out.append(line+": ");
    }

    private void appendFizzBuzz(StringWriter out, int line) {
        if(line % fizzLeap == 0)
            out.append(fizzString);
        if(line % buzzLeap == 0)
            out.append(buzzString);
    }
    
    

}
