package design.practice.designEx.boxomatic;


public class Interval {

    private int startNumber;
    private int length;
    
    public Interval(int startNumber, int length){
        this.startNumber = startNumber;
        this.length = length;
    }
    
    public boolean isNumberInInterval(int number){
        return (number >= startNumber && number < endOfInterval());
    }

    private int endOfInterval() {
        return startNumber + length;
    }
    
    public int getNumberOrder(int number){
        return (number - startNumber)+1;
    }
    
}
