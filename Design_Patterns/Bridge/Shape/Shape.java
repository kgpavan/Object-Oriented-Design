package design.design_patterns.bridge.shapeAndColor;


/*
* Color is used to decorate the shapes This 
* means the shape is dependent of the color
*/ 
public abstract class Shape {

    //Composition - implementor
	protected Color color;
	
	//constructor with implementor as input argument
	public Shape(Color c){
		this.color=c;
	}
	
	abstract public void applyColor();
}