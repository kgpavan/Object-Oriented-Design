//package com.nespresso.sofa.recruitment.labyrinth;
//
//import static org.junit.Assert.assertEquals;
//
//import org.junit.Ignore;
//import org.junit.Test;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//public class LabyrinthShould {
//
//	//MyTests
//	  @Test
//	    public void be_Walkable_Till_The_End_MyTest() {
//	        Labyrinth labyrinth = new Labyrinth("A$B", "A$C", "C|E", "B$D", "B|E", "E$F", "D$F", "F|G");
//	        labyrinth.popIn("A");
//	        assertEquals("A", labyrinth.getCurrentPosition());
//	        labyrinth.walkTo("B");
//	        labyrinth.walkTo("E");
//	        labyrinth.walkTo("F");
//	        assertEquals("F", labyrinth.getCurrentPosition());
//	        labyrinth.walkTo("G");
//	        assertEquals("G", labyrinth.getCurrentPosition());
//	    }
//	  @Test(expected = IllegalMoveException.class)
//	    public void refuse_Move_Without_Path_MyTest() {
//	        Labyrinth labyrinth = new Labyrinth("A$B", "A$C", "B$D");
//	        labyrinth.popIn("A");
//	        labyrinth.walkTo("B");
//	        assertEquals("B", labyrinth.getCurrentPosition());
//	        labyrinth.walkTo("C"); // Can not reach C from B
//	        assertEquals("B", labyrinth.getCurrentPosition());
//	    }
//	   @Test(expected = IllegalMoveException.class)
//	    public void refuse_Illegal_Move_MyTest() {
//	        Labyrinth labyrinth = new Labyrinth("A$B", "A$C", "B$D");
//	        labyrinth.popIn("A");
//	        labyrinth.walkTo("B");
//	        assertEquals("B", labyrinth.getCurrentPosition());
//	        labyrinth.walkTo("E"); // room E does not exist in the labyrinth
//	        assertEquals("B", labyrinth.getCurrentPosition());
//	    }
//
//    /**
//     * each letter represent a room
//     * each | represent a gate between two room
//     * each $ represent a gate with a sensor on
//     */
//    @Test
//    public void be_Walkable_Till_The_End() {
//        Labyrinth labyrinth = new Labyrinth("A$B", "A$C", "C|E", "B$D", "B|E", "E$F", "D$F", "F|G");
//        labyrinth.popIn("A");
//        labyrinth.walkTo("B");
//        labyrinth.walkTo("E");
//        labyrinth.walkTo("F");
//        labyrinth.walkTo("G");
//    }
//
//    @Test(expected = IllegalMoveException.class)
//    public void refuse_Illegal_Move() {
//        Labyrinth labyrinth = new Labyrinth("A$B", "A$C", "B$D");
//        labyrinth.popIn("A");
//        labyrinth.walkTo("B");
//        labyrinth.walkTo("E"); // room E does not exist in the labyrinth
//    }
//
//    @Test(expected = IllegalMoveException.class)
//    public void refuse_Move_Without_Path() {
//        Labyrinth labyrinth = new Labyrinth("A$B", "A$C", "B$D");
//        labyrinth.popIn("A");
//        labyrinth.walkTo("B");
//        labyrinth.walkTo("C"); // Can not reach C from B
//    }
//
//    @Test
//    public void allow_Cyclic_Path() {
//        Labyrinth labyrinth = new Labyrinth("A$B", "A$C", "C|E", "B$D", "B|E", "E$F", "D$F", "F|G");
//        labyrinth.popIn("A");
//        labyrinth.walkTo("B");
//        labyrinth.walkTo("D");
//        labyrinth.walkTo("F");
//        labyrinth.walkTo("E");
//        labyrinth.walkTo("B");
//        labyrinth.walkTo("D");
//        labyrinth.walkTo("F");
//        labyrinth.walkTo("G");
//    }
//
//
//    @Test
//    public void allow_Back_And_Forth() {
//        Labyrinth labyrinth = new Labyrinth("A$B", "A$C", "C|E", "B$D", "B|E", "E$F", "D$F", "F|G");
//        labyrinth.popIn("A");
//        labyrinth.walkTo("C");
//        labyrinth.walkTo("A");
//        labyrinth.walkTo("B");
//        labyrinth.walkTo("D");
//    }
//
//
//    @Test
//    public void allow_Walker_To_Close_Passed_Door() {
//        Labyrinth labyrinth = new Labyrinth("A$B", "A$C", "C|E", "B$D", "B|E", "E$F", "D$F", "F|G");
//        labyrinth.popIn("A");
//        labyrinth.walkTo("B");
//        labyrinth.walkTo("D");
//        labyrinth.walkTo("F");
//        labyrinth.closeLastDoor();
//        labyrinth.walkTo("G");
//    }
//
//    @Test(expected = DoorAlreadyClosedException.class)
//    public void allow_Walker_To_Close_Only_Last_Door() {
//        Labyrinth labyrinth = new Labyrinth("A$B", "A$C", "C|E", "B$D", "B|E", "E$F", "D$F", "F|G");
//        labyrinth.popIn("A");
//        labyrinth.walkTo("B");
//        labyrinth.walkTo("D");
//        labyrinth.walkTo("F");
//        labyrinth.closeLastDoor();
//        labyrinth.closeLastDoor();
//        labyrinth.walkTo("G");
//    }
//
//    @Test(expected = ClosedDoorException.class)
//    public void not_Allow_Closed_Door_Crossing() {
//
//        Labyrinth labyrinth = new Labyrinth("A$B", "A$C", "C|E", "B$D", "B|E", "E$F", "D$F", "F|G");
//        labyrinth.popIn("A");
//        labyrinth.walkTo("B");
//        labyrinth.walkTo("D");
//        labyrinth.closeLastDoor();
//        labyrinth.walkTo("F");
//        labyrinth.walkTo("E");
//        labyrinth.walkTo("B");
//        labyrinth.walkTo("D");
//        labyrinth.walkTo("F");
//        labyrinth.walkTo("G");
//    }
//
//    @Test(expected = ClosedDoorException.class)
//    public void not_Allow_Turn_Back_Through_Closed_Door() {
//        Labyrinth labyrinth = new Labyrinth("A$B", "A$C", "C|E", "B$D", "B|E", "E$F", "D$F", "F|G");
//        labyrinth.popIn("A");
//        labyrinth.walkTo("B");
//        labyrinth.walkTo("D");
//        labyrinth.closeLastDoor();
//        labyrinth.walkTo("B");
//    }
//
//
//    @Test
//    public void follow_Walker() {
//        Labyrinth labyrinth = new Labyrinth("A$B", "A$C", "B$D", "D$E", "D$F", "F$H", "D$F");
//        labyrinth.popIn("A");
//        labyrinth.walkTo("B");
//        assertThat(labyrinth.readSensors()).isEqualTo("AB");
//        labyrinth.walkTo("D");
//        assertThat(labyrinth.readSensors()).isEqualTo("AB;BD");
//        labyrinth.walkTo("F");
//        assertThat(labyrinth.readSensors()).isEqualTo("AB;BD;DF");
//    }
//
//    @Test
//    public void follow_Walker_Through_Unmonitored_Path() {
//        Labyrinth labyrinth = new Labyrinth("A$B", "A$C", "C|E", "B$D", "B|E", "E$F", "D$F", "F|G");
//        labyrinth.popIn("A");
//        labyrinth.walkTo("B");
//        assertThat(labyrinth.readSensors()).isEqualTo("AB");
//        labyrinth.walkTo("E");
//        labyrinth.walkTo("F");
//        assertThat(labyrinth.readSensors()).isEqualTo("AB;EF");
//        labyrinth.walkTo("G");
//        assertThat(labyrinth.readSensors()).isEqualTo("AB;EF");
//    }
//
//
//}
