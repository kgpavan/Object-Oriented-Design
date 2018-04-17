package design.practice.designEx.pyramid;

import design.practice.designEx.pyramid.interfaces.Parser;


public class Pyramid {

    private LayerStack pyramidStack = new LayerStack();
    private Parser pyramidParser;
    
    public void addLayer(String layerIngredients) {
        pyramidParser = createDefaultParser();
        int slavesCount = pyramidParser.getSlavesCount(layerIngredients);
        int anksCount   = pyramidParser.getAnksCount(layerIngredients);
        
        PyramidLayer newPyramidLayer = LayerFactory.createLayer(slavesCount, anksCount);
        pyramidStack.addNewLayer(newPyramidLayer);
        
    }

    public String print() {
        return pyramidStack.printStack();
        
    }
    
    public Parser createDefaultParser(){
        return new PyramidParser();
    }

}
