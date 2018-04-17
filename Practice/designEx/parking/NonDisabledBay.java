package design.practice.designEx.parking;

public class NonDisabledBay extends Surface implements Fillable{

	private static final char EMPTY_NON_DISABLED_BAY_DISPLAY = 'U';
	
	public NonDisabledBay(){
		super(EMPTY_NON_DISABLED_BAY_DISPLAY);
	}
	
	public NonDisabledBay(char carType){
		super(carType);
	}

//	@Override
	public void free() {
		this.surfaceDisplay = EMPTY_NON_DISABLED_BAY_DISPLAY;
	}

//	@Override
	public boolean isEmpty() {
		return this.surfaceDisplay == EMPTY_NON_DISABLED_BAY_DISPLAY;
	}

	@Override
	public boolean canAccept(Surface surface) {
		return surface instanceof NonDisabledBay;
	}

	
}
