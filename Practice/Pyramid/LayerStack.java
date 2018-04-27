package design.practice.designEx.pyramid;

import java.util.ArrayList;
import java.util.List;

import design.practice.designEx.pyramid.interfaces.Printer;


public class LayerStack {
    
    private List<PyramidLayer> stackOfLayers = new ArrayList<PyramidLayer>();
    private Printer pyramidPrinter;
    
    public void addNewLayer(PyramidLayer newPyramidLayer){
        
            for (int i = 0; i < stackOfLayers.size(); i++) {
                if(newPyramidLayer.canCollapse(stackOfLayers.get(i))){
                    stackOfLayers.remove(i);
                    stackOfLayers.add(i, newPyramidLayer);
                    return;
                }
                else{
                    stackOfLayers.add(i, newPyramidLayer);
                    return;
                }
            }
            stackOfLayers.add(0, newPyramidLayer);
    }

    public String printStack() {
        pyramidPrinter = createDefaultPrinter();
        return pyramidPrinter.printPyramid(stackOfLayers);
    }

    public Printer createDefaultPrinter(){
        return new PyramidPrinter();
    }
}
