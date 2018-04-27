package design.practice.designEx.FizzBuzz;

import java.io.StringWriter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FizzBuzz {

    Map<Integer, List<FizzBuzzNature>> numbers;

    public FizzBuzz(int start, int end) {
        numbers = new LinkedHashMap<Integer, List<FizzBuzzNature>>();
        for (int number = start; number <= end; number++) {
            List<FizzBuzzNature> natures = FizzBuzzNature.determineNatures(number);
            numbers.put(number, natures);
        }
    }

    public void generate(StringWriter out) {
        for(Integer number : numbers.keySet()) {
            out.append(number + ": ");
            for (FizzBuzzNature nature : numbers.get(number)) {
                out.append(nature.print());
            }
            out.append("\n");
        }
    }

}
