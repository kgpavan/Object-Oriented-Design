//
//
///*Introduction*/
//abstract class Shape {
//
//	public void printMe() {
//
//		System.out.println("I am a shape.");
//	}
//
//	public abstract double computeArea();
//}
//
//
//class Ambiguous extends Shape {
//	private double area = 10;
//
//	public double computeArea() {
//		return area;
//	}
//}
//
//
//class Circle extends Shape {
//	private double rad = 5;
//	public void printMe() {
//		System.out.println("I am a circle.");
//	}
//
//	public double computeArea() {
//		return rad * rad * 3.15;
//	}
//}
//
//class Square extends Shape {
//	private double len = 5;
//	public void printMe() {
//		System.out.println("I am a square.");
//	}
//
//	public double computeArea() {
//		return len * len;
//	}
//}
//
//
//public class IntroductionCollections {
//	public static void main(String[] args) {
//		// ArrayList
//		ArrayList<String> myArr = new ArrayList<String>();
//		myArr.add("one");
//		myArr.add("two");
//		System.out.println(myArr.get(0));
//
//		// Vector
//		Vector<String> myVect = new Vector<String>();
//		myVect.add("one");
//		myVect.add("two");
//		System.out.println(myVect.get(0));
//
//		// Linked List
//		LinkedList<String> myLinkedList = new LinkedList<String>();
//		myLinkedList.add("two");
//		myLinkedList.addFirst("one");
//		Iterator<String> iter = myLinkedList.iterator();
//		while (iter.hasNext()) {
//			System.out.println(iter.next());
//		}
//
//		// Hash Map
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("one", "uno");
//		map.put("two", "dos");
//		System.out.println(map.get("one"));
//	}
//}
//
//
//public  class IntroductionOverriding {
//
//	public static void printArea(Circle c) {
//		System.out.println("The circle is " + c.computeArea());
//	}
//
//	public static void printArea(Square s) {
//		System.out.println("The square is " + s.computeArea());
//	}
//
//	public static void printArea(Ambiguous s) {
//		System.out.println("The ambiguous is undefined");
//	}
//
//	public static void main(String[] args) {
//		Shape[] shapes = new Shape[2];
//		Circle circle = new Circle();
//		Ambiguous ambiguous = new Ambiguous();
//
//		shapes[0] = circle;
//		shapes[1] = ambiguous;
//
//		for (Shape s : shapes) {
//			s.printMe();
//			System.out.println(s.computeArea());
//		}
//	}
//}
///*Introduction*/
//
//
//
//public   class myShape {
//
//		/*Introduction*/
//	public static String lem() {
//
//		System.out.println("lem");
//		return "return from lem";
//	}
//
//	public static String foo() {
//
//		int x = 0;
//		int y = 5;
//
//		try{
//
//			System.out.println("start try");
//			int b = y / x;
//			System.out.println("end try");
//			return "returned from try";
//		}
//
//		catch (Exception ex) {
//
//			System.out.println("catch");
//			return lem() + " | returned from catch";
//		}
//
//		finally {
//
//			System.out.println("finally");
//		}
//	}
//
//	public static void bar() {
//
//		System.out.println("start bar");
//		String v = foo();
//		System.out.println(v);
//		System.out.println("end bar");
//	}
//	/*Introduction*/
//
//
//	public static void main(String[] args) {
//		bar();
//	}
//}
