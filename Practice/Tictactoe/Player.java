package design.practice.designEx.tictactoe;



public class Player {

    private String display;
    
    public Player(String display) {
        this.display = display;
    }

    @Override
    public String toString() {
        return "<"+display+">";
    }
    
    @Override
    public boolean equals(Object obj) {
        return this.display.equals(((Player)obj).display);
    }
    
    @Override
    public int hashCode() {
        return 31 * display.hashCode();
    }
}
