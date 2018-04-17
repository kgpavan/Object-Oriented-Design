package design.practice.designEx.train;

import java.util.ArrayList;
import java.util.List;


public class Parser {

    public static List<Wagon> getWagons(String string) {
        List<Wagon> wagons = new ArrayList<Wagon>(string.length());
        
        for (int i = 0; i < string.length(); i++) {
            Wagon wagon = Wagon.getWagonByCode(string.charAt(i));
            wagons.add(wagon);
        }
        
        return wagons;
    }

    
    
}
