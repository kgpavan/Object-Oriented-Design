package design.practice.designEx.pyramid;

import java.util.List;

import design.practice.designEx.pyramid.interfaces.Printer;


public class PyramidPrinter implements Printer {


    public String printPyramid(List<PyramidLayer> pyramidLayers) {
        StringBuilder pyramidDisplay = new StringBuilder();
        int baseLayerIndex = pyramidLayers.size() - 1;
        PyramidLayer baseLayer = pyramidLayers.get(baseLayerIndex);
        
        for (int i = 0; i <= baseLayerIndex; i++) {
            int nextLayerIndex = i + 1;
            String printedLayer;
            if(nextLayerIndex <= baseLayerIndex && ! pyramidLayers.get(i+1).equals(baseLayer)){
                printedLayer = pyramidLayers.get(i).print(pyramidLayers.get(i+1), baseLayer);
                pyramidDisplay.append(printedLayer+"\n");
            }else if(nextLayerIndex <= baseLayerIndex){
                printedLayer = pyramidLayers.get(i).print(pyramidLayers.get(i+1));
                pyramidDisplay.append(printedLayer+"\n");
            }
            else{
                printedLayer = pyramidLayers.get(i).print();
                pyramidDisplay.append(printedLayer);
            }
        }
        return pyramidDisplay.toString();
    }
    
    public String printPyramidLayer(StoneQuality stoneQuality, int stonesCount, int emptyStonePlaces, int blankPlacesCount){
        StringBuilder layer = new StringBuilder();
        layer.append(printBlankSpaces(blankPlacesCount));
        layer.append(printEmptyStonePlaces(emptyStonePlaces));
        layer.append(printStones(stoneQuality, stonesCount));
        layer.append(printEmptyStonePlaces(emptyStonePlaces));
        layer.append(printBlankSpaces(blankPlacesCount));
        
        return layer.toString();
    }
    
    private String printBlankSpaces(int blankPlacesCount) {
        StringBuilder display = new StringBuilder();
        for (int i = 0; i < blankPlacesCount; i++) {
            display.append(" ");
        }
        return display.toString();
    }
    
    private String printStones(StoneQuality stoneQuality, int stonesCount) {
        StringBuilder display = new StringBuilder();
        for (int i = 0; i < stonesCount; i++) {
            display.append(stoneQuality.display);
        }
        return display.toString();
    }
    
    private String printEmptyStonePlaces(int emptyStonePlacesCount) {
        StringBuilder emptyStonesDisplay = new StringBuilder();
        for (int i = 0; i < emptyStonePlacesCount; i++) {
            emptyStonesDisplay.append("_");
        }
        return emptyStonesDisplay.toString();
    }
}
