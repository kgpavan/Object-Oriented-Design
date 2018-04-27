package design.practice.designEx.pyramid.interfaces;

import java.util.List;

import design.practice.designEx.pyramid.PyramidLayer;
import design.practice.designEx.pyramid.StoneQuality;


public interface Printer {

    public String printPyramid(List<PyramidLayer> pyramidLayers);
    public String printPyramidLayer(StoneQuality stoneQuality, int stonesCount, 
                                    int emptyStonePlaces, int blankPlacesCount);
}
