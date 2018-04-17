package design.practice.designEx.FizzBuzz;


public class Fizz extends NumberNature2 {

    public static final Fizz INSTANCE = new Fizz();  
    
    private Fizz() {
        super(3);
    }
 
    @Override
    public String print() {
        return "Fizz";
    }
}
