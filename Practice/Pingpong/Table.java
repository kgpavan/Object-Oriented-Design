package design.practice.designEx.pingpong;


public class Table {

    private int length;
    private String drawUnity = ".";
    
    public Table(int length) {
        this.length = length;
    }

    public String print() {
        return Printer.printOneTable(length, drawUnity);
    }
}
