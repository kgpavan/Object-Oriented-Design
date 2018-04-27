package design.practice.designEx.tictactoo;


public class Player {

    private char display;
    public Player(char display) {
        this.display = display;
    }

    
    @Override
    public boolean equals(Object obj) {
        return this.display == ((Player)obj).display;
    }
    
    @Override
    public int hashCode() {
        return 31 * display+"".hashCode();
    }
    
    @Override
    public String toString() {
        return "<"+display+">";
    }
}

