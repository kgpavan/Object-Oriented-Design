//package Q7_12_Hash_Table;

package design.practice.hashTable;

public class Dummy {

	private String name;
	private int age;
	
	public Dummy(String n, int a) {
	
		name = n;
		age = a;
	}
	
	@Override 
	public String toString() {
	
		return "(" + name + ", " + age + ")";
	}
	
	public int getAge() {
		return age;
	}
	
	public String getName() {
		return name;
	}
}
