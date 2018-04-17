package design.practice.designEx.train;

import java.util.List;


public class Train {

    private List<Wagon> wagons;
    
    public Train(String string) {
        this.wagons = Parser.getWagons(string);
    }

    public boolean fill() {
        for (int i = 0; i < wagons.size(); i++) {
            if(wagons.get(i).equals(Wagon.EmptyCargo)){
                wagons.set(i, Wagon.FilledCargo);
                return true;
            }
        }
        return false;
    }

    public String print() {
        StringBuilder builder = new StringBuilder();
        builder.append("<"+wagons.get(0).print());
        for (int i = 1; i < wagons.size(); i++) {
             builder.append("::|");
             builder.append(wagons.get(i).print());
             builder.append("|");
        } 
        return builder.toString();
    }

}
