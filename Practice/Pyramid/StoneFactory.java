package design.practice.designEx.pyramid;


public class StoneFactory {
    
    private static final int NUMBER_OF_SLAVES_FOR_ONE_STONE = 50;

    public StoneQuality getStoneQuality(int stonesCount, int anksCount) {
        int stoneUnitPrice = anksCount / stonesCount; 
        if( stoneUnitPrice >= 2)
            return StoneQuality.highQuality;
        else
            return StoneQuality.lowQuality;
    }

    public int getStonesCountFromSlavesCount(int slavesCount){
        return (int)(slavesCount / NUMBER_OF_SLAVES_FOR_ONE_STONE);
    }
}
