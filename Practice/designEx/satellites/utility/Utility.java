package design.practice.designEx.satellites.utility;

import java.util.Collections;
import java.util.List;


public class Utility {

	public static String[] getDishParameters(String disheDescription){
		String [] returnArray = new String[3];

		//Getting dish Id
		String tmp1[] = stringToArray(disheDescription, ",");
		returnArray[0] = tmp1[0];

		//Getting separate Degree and Orientation values
		String tmp2[] = getDegreeAndOrientation(tmp1[1].trim());
		returnArray[1] = tmp2[0];
		returnArray[2] = tmp2[1];

		return returnArray;
	}

	public static String[] getDegreeAndOrientation(String DegreeAndOrientation){
		String returnArray[] = new String[2];

		returnArray[0] = DegreeAndOrientation.substring(0, DegreeAndOrientation.length()-1);
		returnArray[1] = DegreeAndOrientation.substring(DegreeAndOrientation.length()-1);
		
		return returnArray;
	}

	public static String[] stringToArray(String string, String separator){
		String array[] = string.split(separator);
		return array;
	}

	public static int stringToInt(String string){
		return Integer.parseInt(string);
	}
	public static Double stringToDouble(String string){
		return Double.parseDouble(string);
	}

	public static Satellite getSatellite(String SatelliteAbreviation) {

		if(SatelliteAbreviation.equals("A")){
			return Satellite.ASTRA;
		}
		else if(SatelliteAbreviation.equals("H")){
			return Satellite.HOTBIRD;
		}
		else{
			return Satellite.NILESAT;
		}

	}

	public static String displaySignal(List<Double> signalDifferenceValues) {
		Double BestSignalDifference = Collections.min(signalDifferenceValues);

		if(BestSignalDifference == 0.0){
			return "|**********|";
		}else if(BestSignalDifference == 0.1){
			return "|*********.|";
		}else if(BestSignalDifference == 0.2){
			return "|********..|";
		}else if(BestSignalDifference == 0.3){
			return "|*******...|";
		}else if(BestSignalDifference == 0.4){
			return "|******....|";
		}else if(BestSignalDifference == 0.5){
			return "|*****.....|";
		}else if(BestSignalDifference == 0.6){
			return "|****......|";
		}else if(BestSignalDifference == 0.7){
			return "|***.......|";
		}else if(BestSignalDifference == 0.8){
			return "|**........|";
		}else if(BestSignalDifference == 0.9){
			return "|*.........|";
		}else{
			return "No signal !";
		}
	}
}
