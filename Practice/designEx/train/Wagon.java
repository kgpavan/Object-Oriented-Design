package design.practice.designEx.train;


public enum Wagon {
    
    Head("HHHH", 'H'), Passenger("OOOO",'P'), Restaurant("hThT", 'R'), EmptyCargo("____", 'C'), FilledCargo("^^^^", 'G');
    
    private String display;
    private char code;
    
    Wagon(String display, char code){
        this.code    = code;
        this.display = display;
    }
    
    public String print(){
        return this.display;
    };
    
    private char getCode(){
        return this.code;
    }
    
    public static Wagon getWagonByCode(char code){

        if(code == Head.getCode())
            return Head;
        else if(code == Passenger.getCode())
            return Passenger;
        else if(code == Restaurant.getCode())
            return Restaurant;
        else if(code == EmptyCargo.getCode())
            return EmptyCargo;
        else if(code == FilledCargo.getCode())
            return FilledCargo;
        else{
            return null;
        }
    }
    
 

}
