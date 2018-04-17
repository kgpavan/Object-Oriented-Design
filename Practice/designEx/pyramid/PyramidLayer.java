package design.practice.designEx.pyramid;

import design.practice.designEx.pyramid.interfaces.Printer;


public class PyramidLayer {

    private StoneQuality stoneQuality;
    private int stonesCount;
    private Printer pyramidPrinter;
    
    public PyramidLayer(StoneQuality stone, int stonesCount){
        this.stoneQuality = stone;
        this.stonesCount  = stonesCount;
        pyramidPrinter    = createDefaultPrinter();
    }

    public String print(){
        return pyramidPrinter.printPyramidLayer(this.stoneQuality, this.stonesCount, 0, 0);
    }

    public String print(PyramidLayer belowPyramidLayer) {
        int emptyStonePlaces = (belowPyramidLayer.stonesCount - this.stonesCount) / 2;
        return pyramidPrinter.printPyramidLayer(this.stoneQuality, this.stonesCount, emptyStonePlaces, 0);
    }

    public String print(PyramidLayer belowPyramidLayer, PyramidLayer baseLayer) {
        int emptyStonePlaces = (belowPyramidLayer.stonesCount - this.stonesCount) / 2;
        int blankPlacesCount = (baseLayer.stonesCount / 2) - (belowPyramidLayer.stonesCount / 2);
        return pyramidPrinter.printPyramidLayer(this.stoneQuality, this.stonesCount, emptyStonePlaces, blankPlacesCount);
    }
    
    public boolean canCollapse(PyramidLayer pyramidLayer) {
        if(this.stonesCount > pyramidLayer.stonesCount){
            return true;
        }
        else if(this.stonesCount == pyramidLayer.stonesCount){
            if(this.stoneQuality == pyramidLayer.stoneQuality)
                return true;
            else if(this.stoneQuality == StoneQuality.highQuality && pyramidLayer.stoneQuality == StoneQuality.lowQuality)
               return true;
        }   
        return false;
    }
    
    public Printer createDefaultPrinter(){
        return new PyramidPrinter();
    }
}
