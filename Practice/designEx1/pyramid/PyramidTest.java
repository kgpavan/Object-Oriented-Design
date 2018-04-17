//package com.nespresso.exercise.pyramid;
//
//import static org.junit.Assert.assertEquals;
//
//import org.junit.Ignore;
//import org.junit.Test;
//
//public class PyramidTest {
//
//	@Test
//	public void buildSimplePyramid() {
//		Pyramid pyramid = new Pyramid();
//		pyramid.addLayer("250 Slaves, 10 Anks");
//		assertEquals("XXXXX", pyramid.print());
//		pyramid.addLayer("150 Slaves, 4 Anks");
//		assertEquals("_VVV_\nXXXXX", pyramid.print());
//		pyramid.addLayer("50 Slaves, 2 Anks");
//		assertEquals(" _X_ \n_VVV_\nXXXXX", pyramid.print());
//	}
//
//	@Test
//	public void collapseLayers() {
//		Pyramid pyramid = new Pyramid();
//		pyramid.addLayer("250 Slaves, 10 Anks");
//		pyramid.addLayer("50 Slaves, 3 Anks");
//		assertEquals("__X__\nXXXXX", pyramid.print());
//		pyramid.addLayer("150 Slaves, 6 Anks");
//		assertEquals("_XXX_\nXXXXX", pyramid.print());
//		pyramid.addLayer("150 Slaves, 3 Anks");
//		assertEquals(" VVV \n_XXX_\nXXXXX", pyramid.print());
//		pyramid.addLayer("150 Slaves, 3 Anks");
//		assertEquals(" VVV \n_XXX_\nXXXXX", pyramid.print());
//	}
//
//}
