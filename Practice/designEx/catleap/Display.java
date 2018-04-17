package design.practice.designEx.catleap;


public class Display {

    public static String DisplayCatPath(int leapCounter, int maxLeapSize) {        
        StringBuilder builder = new StringBuilder("*");

        for (int leapSize = 0; leapSize < leapCounter; leapSize++) {
            
            if(leapSize < maxLeapSize){
                builder.append(DisplayLeap(leapSize));
            }else{
                builder.append(DisplayLeap(maxLeapSize - 1));
            }
        }
        
        return builder.toString();
    }

    private static String DisplayLeap(int leapSize) {
        StringBuilder builder = new StringBuilder();
        
        for (int i = 0; i <= leapSize; i++) {
            builder.append(".");
        }
        builder.append("*");
        return builder.toString();
    }

}
