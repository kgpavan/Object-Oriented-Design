package design.practice.designEx.shapes;


public class Triangle implements Shape{

    private int height;
    private int base;
    
    
    public Triangle(int height, int base) {
        this.height = height;
        this.base = base;
    }


    @Override
    public int area() {
        return (height * base) / 2;
    }

}
