package design.practice.designEx.shapes;


public class Square implements Shape{

    private int side;

    public Square(int side) {
        this.side = side;
    }

    @Override
    public int area() {
        return side * side;
    }
}
