//package design.design_patterns.observer.weather;
//
//import java.util.*;
//import java.util.Observer;
//
//public class WeatherData implements Subject {
//	private ArrayList<java.util.Observer> observers;
//	private float temperature;
//	private float humidity;
//	private float pressure;
//
//	public WeatherData() {
//		observers = new ArrayList<java.util.Observer>();
//	}
//
//	public void registerObserver(java.util.Observer o) {
//		observers.add(o);
//	}
//
//	public void removeObserver(java.util.Observer o) {
//		int i = observers.indexOf(o);
//		if (i >= 0) {
//			observers.remove(i);
//		}
//	}
//
//	public void notifyObservers() {
//		for (Observer observer : observers) {
//			observer.update(temperature, humidity, pressure);
//		}
//	}
//
//	public void measurementsChanged() {
//		notifyObservers();
//	}
//
//	public void setMeasurements(float temperature, float humidity, float pressure) {
//		this.temperature = temperature;
//		this.humidity = humidity;
//		this.pressure = pressure;
//		measurementsChanged();
//	}
//
//	public float getTemperature() {
//		return temperature;
//	}
//
//	public float getHumidity() {
//		return humidity;
//	}
//
//	public float getPressure() {
//		return pressure;
//	}
//
//}
