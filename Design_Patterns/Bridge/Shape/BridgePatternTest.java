package design.design_patterns.bridge.shapeAndColor;

public class BridgePatternTest {

	public static void main(String[] args) {
        Shape triangle = new Triangle(new RedColor());
		triangle.applyColor();

		Shape pentagon = new Pentagon(new GreenColor());
		pentagon.applyColor();
	}
}