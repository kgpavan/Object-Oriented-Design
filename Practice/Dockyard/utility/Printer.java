package design.practice.designEx.dockyard.utility;


public class Printer {

	public static String print(int contentSizeSourceShip, int contentSizeDockyard, int contentSizeDestinationShip) {

		String stringToPrint = "";
		int biggestStack = Math.getMaxValue(contentSizeSourceShip, contentSizeDockyard, contentSizeDestinationShip);
		for (int i = 0; i < biggestStack; i++) {
			stringToPrint = drawLevel(contentSizeSourceShip, contentSizeDockyard, contentSizeDestinationShip) + stringToPrint;

			if(contentSizeSourceShip > 0)		contentSizeSourceShip--;
			if(contentSizeDockyard > 0)			contentSizeDockyard--;
			if(contentSizeDestinationShip > 0)	contentSizeDestinationShip--;
		}

		return stringToPrint;
	}

	private static String drawLevel(int contentSizeSourceShip,
			int contentSizeDockyard, int contentSizeDestinationShip) {
		StringBuilder stackLevel = new StringBuilder("     \n");
		if(contentSizeSourceShip > 0){
			stackLevel.setCharAt(0, 'X');
		}
		if(contentSizeDockyard > 0){
			stackLevel.setCharAt(2, 'X');
		}
		if(contentSizeDestinationShip > 0){
			stackLevel.setCharAt(4, 'X');
		}
		return stackLevel.toString();
	}

}
