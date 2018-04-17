package design.practice.designEx.shapes;

import java.io.StringWriter;


public class Shapes {

    private StringWriter writer;
    
    public Shapes(StringWriter out) {
        this.writer = out;
    }

    public void area(String shapeName, String shapeParameters) {
        Shape shape = Factory.createShape(shapeName, shapeParameters);
        writer.append(shape.area()+"\n");
    }
}
