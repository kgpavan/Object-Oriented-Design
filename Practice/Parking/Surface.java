package design.practice.designEx.parking;

public abstract class Surface {

	protected char surfaceDisplay;
	
	public Surface(char surfaceDisplay){
		this.surfaceDisplay = surfaceDisplay;
	}
	
	public void print(StringBuilder builder){
		builder.append(this.surfaceDisplay);
//		return builder;
	}
	
	public abstract boolean canAccept(Surface surface);
	
}
