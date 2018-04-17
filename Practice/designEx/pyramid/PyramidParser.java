package design.practice.designEx.pyramid;

import design.practice.designEx.pyramid.interfaces.Parser;


public class PyramidParser implements Parser {
    
    public int getAnksCount(String layerIngredients) {
        String anksPart = getLayerIngredientPart(layerIngredients, 2);
        String numberOfAnksAsString = anksPart.split(" ")[0].trim();
        return new Integer(numberOfAnksAsString);
    }

    public int getSlavesCount(String layerIngredients) {
        String slavesPart = getLayerIngredientPart(layerIngredients, 1);
        String numberOfSlavesAsString = slavesPart.split(" ")[0].trim();
        
        return new Integer(numberOfSlavesAsString);
    }
    
    private String getLayerIngredientPart(String layerIngredients, int index) {
        return layerIngredients.split(",")[index - 1].trim();
    }

}
