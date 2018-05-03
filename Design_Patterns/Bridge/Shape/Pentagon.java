package design.design_patterns.bridge.shapeAndColor;

public class Pentagon extends Shape{

	public Pentagon(Color c) {
        super(c);
	}

	@Override
	public void applyColor() {
		System.out.print("Pentagon filled with color ");
		color.applyColor();
	} 

}