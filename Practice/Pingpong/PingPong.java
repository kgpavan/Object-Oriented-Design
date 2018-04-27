package design.practice.designEx.pingpong;

import java.util.ArrayList;
import java.util.List;


public class PingPong {

    private List<Table> tables;
    
    public PingPong(int length) {
        this.tables = new ArrayList<Table>(length);
        initTables(length);
    }

    private void initTables(int length) {
        int ratioTableLength = 2;
        
        for (int tableOrder = 0; tableOrder < length; tableOrder++) {
            Table table = new Table(calculateLength(ratioTableLength, tableOrder));
            tables.add(table);
        }
    }

    private int calculateLength(int ratioTableLength, int tableOrder) {
        return tableOrder * ratioTableLength;
    }

    public String print() {
        String playerOne = "I";
        String playerTwo = "O";
        return Printer.printAllTables(tables, playerOne, playerTwo);
    }

}
