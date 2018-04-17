package design.practice.designEx.dockyard;

public class Ship {

    private int depotSize;
    private int contentSize;

    public Ship(int depotSize, int contentSize) {
        this.depotSize = depotSize;
        this.contentSize = contentSize;
    }

    public int getDepotSize() {
        return depotSize;
    }

    public int getContentSize() {
        return contentSize;
    }

    public void loadOrUnloadOne(int value) {
        contentSize += value;
    }

    public boolean hasEmptyPlaces() {
        return this.contentSize < this.depotSize;
    }
}
