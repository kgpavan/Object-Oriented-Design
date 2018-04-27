package design.practice.designEx.pyramid;


public enum StoneQuality {

    highQuality("X"), lowQuality("V");
    
    public String display;
    
    StoneQuality(String display){
        this.display = display;
    }
}
