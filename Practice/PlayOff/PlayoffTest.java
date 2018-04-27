//package com.nespresso.exercices.playoff;
//
//import static org.junit.Assert.assertArrayEquals;
//import org.junit.Test;
//
//
//public class PlayoffTest {
//
//    @Test
//    public void shouldOrganizeOtherMatches() {
//        //"A B" means that team A has won against team B,
//        // the winner gets 1 point and the looser 0 points
//        String[] qualificationsResults = {
//                    "A B", "A F", "A C", "A E",
//                    "B C", "B E", "B C",
//                    "C B", "C E",
//                    "D C" };
//
//        Playoff playoff = new Playoff(qualificationsResults);
//
//        // //In the playoffs only the first four best teams are selected
//        // //The strongest team plays against the weakest and the second strongest plays against the second weakest.
//        String[] expectedPlayoffMatches = {"A vs D", "B vs C"};
//
//        assertArrayEquals(expectedPlayoffMatches, playoff.layout());
//    }
//
//
//    @Test
//    public void shouldOrganize4Matches() {
//        //"A B" means that team A has won against team B,
//        // the winner gets 1 point and the looser 0 points
//        String[] qualificationsResults = {
//                    "A B", "A F", "A C", "A E", "A D",
//                    "B C", "D E", "D C", "D E", "D B",
//                    "E B", "E F", "F B", "F C", "F D"
//        };
//
//        Playoff playoff = new Playoff(qualificationsResults);
//
//        // //In the playoffs only the first four best teams are selected
//        // //The strongest team plays against the weakest and the second strongest plays against the second weakest.
//        String[] expectedPlayoffMatches = {"A vs E", "D vs F"};
//
//        assertArrayEquals(expectedPlayoffMatches, playoff.layout());
//    }
//
//}