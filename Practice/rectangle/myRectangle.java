
package design.practice.rectangle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*14-5*/
class Rectangle {

    private double width;
    private double height;

    public Rectangle(double w, double h) {

        width = w;
        height = h;
    }

    public double area() {
        return width * height;
    }
}
/*14-5*/


public class myRectangle {

    public static void main(String[] args) {

		/*14-5*/
        try {
			/* Parameters */
            Object[] doubleArgs = new Object[]{4.2, 3.9};
			
			/* Get class */
            Class rectangleDefinition = Class.forName("Question14_5.rectangle");
			
			/* Equivalent: rectangle rectangle = new rectangle(4.2, 3.9); */
            Class[] doubleArgsClass = new Class[]{double.class, double.class};
            Constructor doubleArgsConstructor = rectangleDefinition.getConstructor(doubleArgsClass);
            Rectangle rectangle = (Rectangle) doubleArgsConstructor.newInstance(doubleArgs);
			
			/* Equivalent: Double area = rectangle.area(); */
            Method m = rectangleDefinition.getDeclaredMethod("area");
            Double area = (Double) m.invoke(rectangle);

            System.out.println(area);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (NoSuchMethodException e) {
            System.out.println(e);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        } catch (IllegalAccessException e) {
            System.out.println(e);
        } catch (InvocationTargetException e) {
            System.out.println(e);
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		/*14-5*/
    }
}