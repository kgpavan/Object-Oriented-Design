package design.practice.designEx.shadows;

import java.util.ArrayList;
import java.util.List;


public class Shadows {

    private List<Building> buildingList;
    
    public Shadows(float ...buildingsCordinates) {
        buildingList = createBuildingList(buildingsCordinates);
    }

    private static List<Building> createBuildingList(float[] buildingsCordinates) {
        List<Building> buildingList = new ArrayList<Building>();
        
        for (int i = 0; i < buildingsCordinates.length; i+=2) {
            Building building = new Building(buildingsCordinates[i], buildingsCordinates[i + 1]);
            buildingList.add(building);
        }
        return buildingList;
    }

    public String project(int angleInDegree) {
        StringBuilder shadowsProjection = new StringBuilder();
        for (int i = 0; i < buildingList.size(); i++) {
            if(buildingList.size() > i+1 && buildingList.get(i).isInMyShadowArea(buildingList.get(i+1), angleInDegree)){
                String shadowIntersection = buildingList.get(i).calculateShadowIntersection(buildingList.get(i+1), angleInDegree);
                shadowsProjection.append(shadowIntersection);
                i +=1; 
            }
            else
                shadowsProjection.append(buildingList.get(i).project(angleInDegree));
        }
        return shadowsProjection.toString();
    }
}
