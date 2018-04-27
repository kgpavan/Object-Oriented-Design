//package com.nespresso.exercise.shadows;
//
//import static org.junit.Assert.assertEquals;
//
//import org.junit.Ignore;
//import org.junit.Test;
//
//public class ShadowsTest {
//
//    @Test
//    public void aBuildingProjectsShadowDependingOnSunHeight() {
//        final shadows shadows = new shadows(4f, 0f);
//        assertEquals("[0,6.93]", shadows.project(30));
//        assertEquals("[0,4.00]", shadows.project(45));
//        assertEquals("[0,2.31]", shadows.project(60));
//        assertEquals("[0,0.00]", shadows.project(90));
//    }
//
//    @Test
//    public void twoBuildingsProjectTwoShadows() {
//        final shadows shadows = new shadows(4f, 0f, 2f, 8f);
//        assertEquals("[0,6.93][8,11.46]", shadows.project(30));
//    }
//
//    @Test
//    public void closeBuildingsMergeTheirShadow() {
//        final shadows shadows = new shadows(4f, 0f, 2f, 6f);
//        assertEquals("[0,9.46]", shadows.project(30));
//    }
//
//}