package design.practice.designEx.shadows;

import java.util.Locale;


public class Building {
    
    private float height;
    private float xPosition;
    
    public Building(float height, float xPosition){
        this.height = height;
        this.xPosition = xPosition;
    }

    public String project(int angleInDegree) {

        float shadowEndPosition = calculateShadowEndPosition(angleInDegree);
        String xPostionString = floatsToString(this.xPosition, 0);
        String shadowLengthString = floatsToString(shadowEndPosition, 2);
        
        return printShadowArea(xPostionString, shadowLengthString);
    }

   
    private String floatsToString(float floatNumber, int dicemalPositionCount) {
        return String.format(Locale.ENGLISH, "%."+dicemalPositionCount+"f", floatNumber);
    }

    private float calculateShadowLength(int angleInDegree) {
        double angleInRadians = Math.toRadians(angleInDegree);
        float tangent = (float) Math.tan(angleInRadians);
        
        return height / tangent;
    }
    
    public float calculateShadowEndPosition(int angleInDegree){
        float shadowLength = calculateShadowLength(angleInDegree);
        float shadowEndPosition = (float) Math.round((shadowLength + xPosition) * 100) / 100;
        
        return shadowEndPosition;
    }
    
    public boolean isInMyShadowArea(Building building, int angleInDegree){
        float thisShadowEndPosition = calculateShadowEndPosition(angleInDegree);
        float buildingShadowEndPosition = calculateShadowEndPosition(angleInDegree);
        
        if(this.xPosition >= building.xPosition && this.xPosition <= buildingShadowEndPosition ||
                thisShadowEndPosition >= building.xPosition && thisShadowEndPosition <= buildingShadowEndPosition)
            return true;
        else
            return false;
    }
    
    public String calculateShadowIntersection(Building building, int angleInDegree) {
        float thisShadowEndPosition = this.calculateShadowEndPosition(angleInDegree);
        float buildingShadowEndPosition = building.calculateShadowEndPosition(angleInDegree);
        
        float minXPosition = Math.min(this.xPosition, building.xPosition);
        String minXPositionAsString = floatsToString(minXPosition, 0);
        
        float maxShadowEndPosition = Math.max(thisShadowEndPosition, buildingShadowEndPosition);
        String maxShadowEndPositionAsString = floatsToString(maxShadowEndPosition, 2);
        
        return printShadowArea(minXPositionAsString, maxShadowEndPositionAsString);
    } 
    
    private String printShadowArea(String xPostionString, String shadowLengthString) {
        return "["+xPostionString+","+shadowLengthString+"]";
    }

}
