package design.practice.designEx.shapes;


public class Factory {

    public static Shape createShape(String shapeName, String shapeParameters){
        Shape shape;
        if(shapeName.equals("SQUARE")){
            int squareSide = Integer.parseInt(shapeParameters);
            shape = new Square(squareSide);
        }else if(shapeName.equals("RECTANGLE")){
            String [] rectangleParameters = shapeParameters.split(",");
            int width = Integer.parseInt(rectangleParameters[0]);
            int height = Integer.parseInt(rectangleParameters[1]);
            
            shape = new Rectangle(height, width);
        }else{
            String [] triangleParameters = shapeParameters.split(",");
            int height = Integer.parseInt(triangleParameters[0]);
            int base = Integer.parseInt(triangleParameters[1]);
            
            shape = new Triangle(height, base);
        }
        
        return shape;
    }
}
