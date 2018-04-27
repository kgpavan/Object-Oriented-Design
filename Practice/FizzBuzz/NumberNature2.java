package design.practice.designEx.FizzBuzz;


public abstract class NumberNature2 {
    private int base;
    
    protected NumberNature2(int base) {
        this.base = base;
    }
    
//    public static List<NumberNature> determineNatures(int number) {
//        List<NumberNature> natures = new ArrayList<NumberNature>();
//        for (NumberNature nature : values()) {
//            if (nature.applicableTo(number)) {
//                natures.add(nature);
//            }
//        }
//        return natures;
//    }

    private boolean applicableTo(int number) {
        return number%base==0;
    }
    public abstract String print();

}
