package design.practice.designEx.parking;

public class DisabledBay extends Surface implements Fillable{

	
	private static final char EMPTY_DISABLED_BAY_DISPLAY = '@';
	private static final char OCCUPIED_DISABLED_BAY_DISPLAY = 'D';
	
	public DisabledBay(boolean isFull) {
		super(getDisabledBayDisplay(isFull));
	}


	private static char getDisabledBayDisplay(boolean isFull) {
		if(isFull)
			return OCCUPIED_DISABLED_BAY_DISPLAY;
		else
			return EMPTY_DISABLED_BAY_DISPLAY;
	}


//	@Override
	public void free() {
		this.surfaceDisplay = EMPTY_DISABLED_BAY_DISPLAY;
	}

//	@Override
	public boolean isEmpty() {
		return this.surfaceDisplay == EMPTY_DISABLED_BAY_DISPLAY;
	}


	@Override
	public boolean canAccept(Surface surface) {
		return surface instanceof DisabledBay;
	}

	
	
}
