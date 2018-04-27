//package com.nespresso.exercise.dockyard;
//
//import org.junit.Ignore;
//import org.junit.Test;
//
//import static org.junit.Assert.assertEquals;
//
//public class DockyardTest {
//
//    @Test
//    public void showsFullShipLoadOnArrival() throws Exception {
//        final Dockyard dockyard = new Dockyard(3);
//        dockyard.sourceShip(4);
//        assertEquals("X    \nX    \nX    \nX    \n", dockyard.print());
//    }
//
//    @Test
//    public void transfersOneContainerPerHourUpToDepotSize() throws Exception {
//        final Dockyard dockyard = new Dockyard(3);
//        dockyard.sourceShip(4);
//        assertEquals("X    \nX    \nX    \nX    \n", dockyard.print());
//        dockyard.workForOneHour();
//        assertEquals("X    \nX    \nX X  \n", dockyard.print());
//		dockyard.workForOneHour();
//		assertEquals("X X  \nX X  \n", dockyard.print());
//        dockyard.workForOneHour();
//        assertEquals("  X  \n  X  \nX X  \n", dockyard.print());
//        dockyard.workForOneHour();
//        assertEquals("  X  \n  X  \nX X  \n", dockyard.print());
//    }
//
//    @Test
//    public void transfersOneContainerPerHourFromDepotToDestinationShip() throws Exception {
//        final Dockyard dockyard = new Dockyard(3);
//        dockyard.sourceShip(4);
//        assertEquals("X    \nX    \nX    \nX    \n", dockyard.print());
//        dockyard.workForOneHour();
//        assertEquals("X    \nX    \nX X  \n", dockyard.print());
//        dockyard.destinationShip(4);
//        dockyard.workForOneHour();
//        assertEquals("X    \nX X X\n", dockyard.print());
//        dockyard.workForOneHour();
//        assertEquals("    X\nX X X\n", dockyard.print());
//        dockyard.workForOneHour();
//        assertEquals("    X\n    X\n  X X\n", dockyard.print());
//        dockyard.workForOneHour();
//        assertEquals("    X\n    X\n    X\n    X\n", dockyard.print());
//    }
//}
