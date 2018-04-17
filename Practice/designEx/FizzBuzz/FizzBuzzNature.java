package design.practice.designEx.FizzBuzz;

import java.util.ArrayList;
import java.util.List;


public enum FizzBuzzNature {
    FIZZ(3) {

        @Override
        public String print() {
            return "Fizz";
        }
    }, BUZZ(5) {

        @Override
        public String print() {
            return "Buzz";
        }
    };

    private int base;
    
    private FizzBuzzNature(int base) {
        this.base = base;
    }
    
    public static List<FizzBuzzNature> determineNatures(int number) {
        List<FizzBuzzNature> natures = new ArrayList<FizzBuzzNature>();
        for (FizzBuzzNature nature : values()) {
            if (nature.applicableTo(number)) {
                natures.add(nature);
            }
        }
        return natures;
    }

    private boolean applicableTo(int number) {
        return number%base==0;
    }

    public abstract String print();
}
