package design.practice.designEx.satellites.dishes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import design.practice.designEx.satellites.factory.Factory;
import design.practice.designEx.satellites.model.Canal;
import design.practice.designEx.satellites.model.Dish;
import design.practice.designEx.satellites.utility.Utility;

public class Dishes {

	private Map<Integer, Dish> listOfDishes = new HashMap<Integer, Dish>();
	private Factory factory = new Factory();
	
	public Dishes(String... dishDescriptions) {
		
		listOfDishes = factory.getDishes(dishDescriptions);
	}

	/**
	 * Logic : Get the differences (in Degree) between the given Canal and all the Dishes,
	 * then select the best difference (Min) and display the result
	 * */
	public String signal(String canalDescription) {
		List<Double> signalDifferenceValues = new ArrayList<Double>();
		Canal canal = factory.getCanal(canalDescription);
		
		for(Dish dish: listOfDishes.values()){
			Double valueDifference = dish.getDishSatelliteSignalDifference(canal.getCanalSattelite());
			signalDifferenceValues.add(valueDifference);
		}
		
		return Utility.displaySignal(signalDifferenceValues);
	}

	public void move(String dishId, String movement) {

		Dish dishToMove = listOfDishes.get(Utility.stringToInt(dishId));
		String[] movementParameters = Utility.getDegreeAndOrientation(movement);
		
		Double movementDegree = Utility.stringToDouble(movementParameters[0]);
		String movementOrientation = movementParameters[1];
		
		dishToMove.move(movementDegree, movementOrientation);
		
	}

}
