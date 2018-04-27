package design.practice.designEx.pyramid;



public class LayerFactory {

    private static StoneFactory stoneFactory = new StoneFactory();
    
    public static PyramidLayer createLayer(int slavesCount, int anksCount) {
     
        int stonesCount = stoneFactory.getStonesCountFromSlavesCount(slavesCount);
        StoneQuality stoneQuality = stoneFactory.getStoneQuality(stonesCount, anksCount);
        PyramidLayer newPyramidLayer = new PyramidLayer(stoneQuality, stonesCount);
        
        return newPyramidLayer;
    }

}
