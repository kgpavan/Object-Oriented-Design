package design.practice.designEx.dockyard;

import design.practice.designEx.dockyard.factory.Factory;
import design.practice.designEx.dockyard.utility.Printer;

public class Dockyard {

	private Ship sourceShip;
	private Ship destinationShip;
	private int depotSize;
	private int contentSize;
	private Factory factory;

	public Dockyard(int depotSize) {
		this.depotSize = depotSize;
		this.contentSize = 0;
		factory = new Factory();
	}

	public void sourceShip(int payload) {
		sourceShip = factory.getSourceShip(payload);
	}

	public void destinationShip(int cargoCapacity) {
		destinationShip = factory.getDestinationShip(cargoCapacity);
	}

	public String print() {
		if(destinationShip == null)
			return Printer.print(sourceShip.getContentSize(), this.contentSize, 0);
		else
			return Printer.print(sourceShip.getContentSize(), this.contentSize, destinationShip.getContentSize());
	}

	public void workForOneHour() {
		if(destinationShip == null && this.hasEmptyPlaces()){
			this.updateAllDepot(-1, 1, 0);
		}else if(destinationShip != null){
			if(sourceShip.getContentSize() > 0)
				this.updateAllDepot(-1, 0, 1);
			else 
				this.updateAllDepot(0, -1, 1);
		}
	}

	private void updateAllDepot(int valueSourceShip, int valueDockyard, int valueDestinationShip){
		sourceShip.loadOrUnloadOne(valueSourceShip);
		this.loadOrUnload(valueDockyard);

		if(destinationShip != null)
			destinationShip.loadOrUnloadOne(valueDestinationShip);
	}

	private void loadOrUnload(int value) {
		this.contentSize += value;
	}

	private boolean hasEmptyPlaces(){
		return this.contentSize < this.depotSize;
	}
}