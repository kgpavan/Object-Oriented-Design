package design.practice.designEx.dockyard.utility;

public class NewPrinter {

    public static String print(int... contentSize) {
        String stringToPrint = "";
        int biggestStack = Math.getMaxValue(contentSize);
        for (int i = 0; i < biggestStack; i++) {
            System.out.println("i : " + i);
            stringToPrint = drawLevel(contentSize) + stringToPrint;
            contentSize = decreaseContentSize(contentSize);
        }
        return stringToPrint;
    }

    private static int[] decreaseContentSize(int[] contentSize) {

        int[] newContentSize = new int[contentSize.length];
        for (int i = 0; i < newContentSize.length; i++) {
            if (newContentSize[i] > 0)
                newContentSize[i]--;
        }
        return newContentSize;
    }

    private static String drawLevel(int... contentSize) {
        StringBuilder stackLevel = new StringBuilder("     \n");
        if (contentSize[0] > 0) {
            stackLevel.setCharAt(0, 'X');
        }
        if (contentSize[1] > 0) {
            stackLevel.setCharAt(2, 'X');
        }
        if (contentSize[2] > 0) {
            stackLevel.setCharAt(4, 'X');
        }
        return stackLevel.toString();
    }

}
