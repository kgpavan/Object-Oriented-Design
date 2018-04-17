//package com.nespresso.exercices.pyramid;
//import static org.junit.Assert.assertEquals;
//
//import org.junit.Ignore;
//import org.junit.Test;
//
//public class PyramidTest {
//
//    @Test
//    public void buildSimplePyramid() {
//        Pyramid pyramid = new Pyramid();
//        pyramid.addLayer("250 Slaves, 10 Anks");
//        assertEquals("XXXXX", pyramid.print());
//        pyramid.addLayer("150 Slaves, 4 Anks");
//        assertEquals("_VVV_\n"
//                   + "XXXXX", pyramid.print());
//        pyramid.addLayer("50 Slaves, 2 Anks");
//        assertEquals(" _X_ \n"
//                   + "_VVV_\n"
//                   + "XXXXX", pyramid.print());
//    }
//
//    @Test
//    public void collapseLayers() {
//        Pyramid pyramid = new Pyramid();
//        pyramid.addLayer("250 Slaves, 10 Anks");
//        pyramid.addLayer("50 Slaves, 3 Anks");
//        assertEquals("__X__\n"
//                   + "XXXXX", pyramid.print());
//        pyramid.addLayer("150 Slaves, 6 Anks");
//        assertEquals("_XXX_\n"
//                   + "XXXXX", pyramid.print());
//        pyramid.addLayer("150 Slaves, 3 Anks");
//        assertEquals(" VVV \n"
//                   + "_XXX_\n"
//                   + "XXXXX", pyramid.print());
//        pyramid.addLayer("150 Slaves, 3 Anks");
//        assertEquals(" VVV \n"
//                   + "_XXX_\n"
//                   + "XXXXX", pyramid.print());
//    }
//
//}
//
