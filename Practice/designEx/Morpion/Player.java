package design.practice.designEx.Morpion;

public class Player {

    private String name;
    private String playingChararcter;
    
    public Player(String name, String playingChararcter) {
        this.name = name;
        this.playingChararcter = playingChararcter;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj != null && obj instanceof Player)
            return ((Player) obj).name.equals(this.name);
        return false;
    }
    
    @Override
    public int hashCode() {
        return name.hashCode() * 31 +playingChararcter.hashCode();
    }
    
    @Override
    public String toString() {
        return name;
    }

    public void print(StringBuilder builder) {
        builder.append(this.playingChararcter);
        
    }
    
}
