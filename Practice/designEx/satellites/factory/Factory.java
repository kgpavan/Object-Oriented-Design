package design.practice.designEx.satellites.factory;

import java.util.HashMap;

import design.practice.designEx.satellites.model.Canal;
import design.practice.designEx.satellites.model.Dish;
import design.practice.designEx.satellites.utility.Satellite;
import design.practice.designEx.satellites.utility.Utility;

public class Factory {

	public HashMap<Integer, Dish> getDishes(String... dishDescriptions){
		
		HashMap<Integer, Dish> listDishes = new HashMap<Integer, Dish>();
		String [] dishParametersInArray = new String[3];
		
		for(String oneDish: dishDescriptions){
			
			dishParametersInArray = Utility.getDishParameters(oneDish);
			int Id = Utility.stringToInt(dishParametersInArray[0]);
			Double OrientationDegree = Utility.stringToDouble(dishParametersInArray[1]);
			String Orientation = dishParametersInArray[2];
			
			Dish dish = new Dish(Id, OrientationDegree, Orientation);
			listDishes.put(Id, dish);
		}
		
		return listDishes;
	}
	
	public Canal getCanal(String canalDescription){
		String[] canalParameters = Utility.stringToArray(canalDescription, ",");
		Satellite satellite = Utility.getSatellite(canalParameters[1].trim());
		
		return new Canal(canalParameters[0], satellite);
	}
}
