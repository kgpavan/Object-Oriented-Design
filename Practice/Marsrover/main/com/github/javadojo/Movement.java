package design.practice.designEx.marsrover.main.com.github.javadojo;


public enum Movement {

    STRAIGHT("s"), RIGHT("r"), LEFT("l");
    
    private String code;
    
    private Movement(String code) {
        this.code = code;
    }

    public static Movement getMovementByCode(String code) {
        for (Movement movement : values()) {
            if(movement.code.equals(code))
                return movement;
        }
        
        return null;
    } 
}
