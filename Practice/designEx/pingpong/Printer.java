package design.practice.designEx.pingpong;

import java.util.List;


public class Printer {

    public static String printAllTables(List<Table> tables, String playerOne, String playerTwo) {
        StringBuilder builder = new StringBuilder();
        for (Table table : tables) {
            builder.append(playerOne);
            builder.append(table.print());
            builder.append(playerTwo);
        }
        return builder.toString();
    }

    public static String printOneTable(int length, String drawUnity) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append(drawUnity);
        }
        
        return builder.toString();
    }
}