

public  class Usage {
	
	Map<String, Object> source = ...;
	Car car = new Car(source);
	String model = car.getModel();
	int price = car.getPrice();
	List<Wheel> wheels = car.children("wheel", Wheel::new)
	    .collect(Collections.toList());
}