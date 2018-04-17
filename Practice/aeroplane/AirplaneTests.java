//package design.apps.aeroplane;
//
//import org.junit.Assert;
//import org.junit.Test;
//
///**
// *
// * @author Thorsten Meinl, University of Konstanz
// */
//public class AirplaneTests {
//
//    @Test
//    public void testCompare() {
//        Airplane p1 = new Airplane("LX1234", 100, 1);
//        Airplane p2 = new Airplane("LX1234", 100, 2);
//        Assert.assertTrue(p1.compareTo(p2) < 0); // Kriterium 1
//        Assert.assertTrue(p2.compareTo(p1) > 0);
//
//        p1 = new Airplane("LX1234", 100, 2.0);
//        p2 = new Airplane("LX1234", 99, 2.0);
//        Assert.assertTrue(p1.compareTo(p2) < 0); // Kriterium 2
//        Assert.assertTrue(p2.compareTo(p1) > 0);
//
//        p1 = new Airplane("AB1234", 100, 2.0);
//        p2 = new Airplane("LX1234", 100, 2.0);
//        Assert.assertTrue(p1.compareTo(p2) < 0); // Kriterium 3
//        Assert.assertTrue(p2.compareTo(p1) > 0);
//
//        Assert.assertTrue(p1.compareTo(p1) == 0); // Kriterium 3
//    }
//}
