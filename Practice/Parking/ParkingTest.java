//package com.nespresso.sofa.interview.parking;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;
//
//import org.junit.Before;
//import org.junit.Ignore;
//import org.junit.Test;
//
//public class ParkingTest {
//    private static final int FIRST_PEDESTRIAN_EXIT_INDEX = 8;
//    private Parking parking;
//
//    @Before
//    public void setUp() {
//        parking = new ParkingBuilder().withSquareSize(5).withPedestrianExit(FIRST_PEDESTRIAN_EXIT_INDEX).withPedestrianExit(12).withDisabledBay(5)
//            .withDisabledBay(10).build();
//    }
//
//    @Test
//    public void testGetAvailableBays() {
//        assertEquals(23, parking.getAvailableBays());
//    }
//
//    @Test
//    public void testParkCarVehiculeTypeC() {
//        assertEquals(7, parking.parkCar('C'));
//        assertEquals(22, parking.getAvailableBays());
//    }
//
//    @Test
//    public void testParkCarVehiculeTypeM() {
//        assertEquals(7, parking.parkCar('M'));
//        assertEquals(22, parking.getAvailableBays());
//    }
//
//    @Test
//    public void testParkCarTwoVehicules() {
//        assertEquals(7, parking.parkCar('C'));
//        assertEquals(22, parking.getAvailableBays());
//
//        assertEquals(9, parking.parkCar('M'));
//        assertEquals(21, parking.getAvailableBays());
//    }
//
//    @Test
//    public void testParkCarDisabled() {
//        assertEquals(10, parking.parkCar('D'));
//        assertEquals(22, parking.getAvailableBays());
//
//        assertEquals(5, parking.parkCar('D'));
//        assertEquals(21, parking.getAvailableBays());
//
//        assertEquals(-1, parking.parkCar('D'));
//        assertEquals(21, parking.getAvailableBays());
//    }
//
//    @Test
//    public void testUnparkCar() {
//        final int firstCarBayIndex = parking.parkCar('C');
//        assertTrue(parking.unparkCar(firstCarBayIndex));
//        assertEquals(23, parking.getAvailableBays());
//        assertFalse(parking.unparkCar(firstCarBayIndex));
//
//        final int secondCarBayIndex = parking.parkCar('D');
//        assertTrue(parking.unparkCar(secondCarBayIndex));
//        assertEquals(23, parking.getAvailableBays());
//        assertFalse(parking.unparkCar(secondCarBayIndex));
//
//        assertFalse(parking.unparkCar(FIRST_PEDESTRIAN_EXIT_INDEX));
//    }
//
//    @Test
//    public void testToString() {
//        assertEquals("UUUUU\n"
//        		   + "U=UU@\n"
//        		   + "@U=UU\n"
//        		   + "UUUUU\n"
//        		   + "UUUUU", parking.toString());
//    }
//
//    @Test
//    public void testCompleteSolution() {
//        assertEquals(7, parking.parkCar('C'));
//        assertEquals("UUUUU\n"
//        		   + "U=CU@\n"
//        		   + "@U=UU\n"
//        		   + "UUUUU\n"
//        		   + "UUUUU", parking.toString());
//        assertEquals(22, parking.getAvailableBays());
//
//        assertEquals(9, parking.parkCar('C'));
//        assertEquals("UUUUU\n"
//        		   + "C=CU@\n"
//        		   + "@U=UU\n"
//        		   + "UUUUU\n"
//        		   + "UUUUU", parking.toString());
//        assertEquals(21, parking.getAvailableBays());
//
//        assertEquals(11, parking.parkCar('M'));
//        assertEquals("UUUUU\n"
//        		   + "C=CU@\n"
//        		   + "@M=UU\n"
//        		   + "UUUUU\n"
//        		   + "UUUUU", parking.toString());
//        assertEquals(20, parking.getAvailableBays());
//
//        assertEquals(13, parking.parkCar('M'));
//        assertEquals("UUUUU\n"
//        		   + "C=CU@\n"
//        		   + "@M=MU\n"
//        		   + "UUUUU\n"
//        		   + "UUUUU", parking.toString());
//        assertEquals(19, parking.getAvailableBays());
//
//        assertEquals(10, parking.parkCar('D'));
//        assertEquals("UUUUU\n"
//        		   + "C=CU@\n"
//        		   + "DM=MU\n"
//        		   + "UUUUU\n"
//        		   + "UUUUU", parking.toString());
//        assertEquals(18, parking.getAvailableBays());
//
//        assertEquals(5, parking.parkCar('D'));
//        assertEquals("UUUUU\n"
//                   + "C=CUD\n"
//                   + "DM=MU\n"
//                   + "UUUUU\n"
//                   + "UUUUU", parking.toString());
//        assertEquals(17, parking.getAvailableBays());
//
//        assertEquals(-1, parking.parkCar('D'));
//        assertEquals("UUUUU\n"
//                   + "C=CUD\n"
//                   + "DM=MU\n"
//                   + "UUUUU\n"
//                   + "UUUUU", parking.toString());
//        assertEquals(17, parking.getAvailableBays());
//
//        assertFalse(parking.unparkCar(3));
//        assertEquals("UUUUU\n"
//                   + "C=CUD\n"
//                   + "DM=MU\n"
//                   + "UUUUU\n"
//                   + "UUUUU", parking.toString());
//        assertEquals(17, parking.getAvailableBays());
//
//        assertTrue(parking.unparkCar(13));
//        assertEquals("UUUUU\n"
//                   + "C=CUD\n"
//                   + "DM=UU\n"
//                   + "UUUUU\n"
//                   + "UUUUU", parking.toString());
//        assertEquals(18, parking.getAvailableBays());
//    }
//}
