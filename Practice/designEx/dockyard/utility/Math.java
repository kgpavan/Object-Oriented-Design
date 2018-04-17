package design.practice.designEx.dockyard.utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Math {

	public static int getMaxValue(int value1, int value2, int value3) {

		ArrayList<Integer> listInteger = new ArrayList<Integer>();
		listInteger.add(value1);
		listInteger.add(value2);
		listInteger.add(value3);

		return Collections.max(listInteger);
	}
	
	public static int getMaxValue(int ...values){

	    List<Integer> listInteger = new ArrayList<Integer>();
	    for (int i = 0; i < values.length; i++) {
            listInteger.add(values[i]);
        }
	    
	    return Collections.max(listInteger);

	}

}





