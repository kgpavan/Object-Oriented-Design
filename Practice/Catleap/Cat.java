package design.practice.designEx.catleap;


public class Cat {

    private int leapCounter;
    private final static int maxLeapSize = 4;

    public Cat(){
        leapCounter = 0;
    }

    public void leap() {
        leapCounter++;
       
    }

    public String path() {
        return Display.DisplayCatPath(leapCounter, maxLeapSize);
    }
}
