//package com.nespresso.recruitment.gossip;
//
//import org.junit.Ignore;
//import org.junit.Test;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//public class GossipsShould {
//
//    @Test
//    public void bePropagatedByAnyMister() {
//
//        Gossips gossips = new Gossips("Mr White", "Mr Black", "Mr Blue")
//                .from("White").to("Black")
//                .from("Black").to("Blue");
//
//        gossips.say("Hello").to("White");
//
//        assertThat(gossips.ask("White")).isEqualTo("Hello");
//
//        gossips.spread();
//
//        assertThat(gossips.ask("White")).isEqualTo("");
//        assertThat(gossips.ask("Black")).isEqualTo("Hello");
//
//        gossips.spread();
//
//        assertThat(gossips.ask("Black")).isEqualTo("");
//        assertThat(gossips.ask("Blue")).isEqualTo("Hello");
//
//    }
//
//    @Test
//    public void beRetainedIfRecipientHasAlreadyAGossip() {
//
//        Gossips gossips = new Gossips("Mr White", "Mr Black", "Mr Blue")
//                .from("White").to("Black")
//                .from("Blue").to("Black");
//
//        gossips.say("Hello").to("White");
//        gossips.say("Secret").to("Blue");
//
//        assertThat(gossips.ask("White")).isEqualTo("Hello");
//        assertThat(gossips.ask("Blue")).isEqualTo("Secret");
//
//        gossips.spread();
//
//        assertThat(gossips.ask("White")).isEqualTo("");
//        assertThat(gossips.ask("Black")).isEqualTo("Hello");
//        assertThat(gossips.ask("Blue")).isEqualTo("Secret");
//
//        gossips.spread();
//
//        assertThat(gossips.ask("White")).isEqualTo("");
//        assertThat(gossips.ask("Black")).isEqualTo("Secret");
//        assertThat(gossips.ask("Blue")).isEqualTo("");
//
//    }
//
//    @Test
//    public void beRememberedByDoctors() {
//
//        Gossips gossips = new Gossips("Mr White", "Mr Black", "Dr Brown", "Mr Pink")
//                .from("White").to("Brown")
//                .from("Black").to("Brown")
//                .from("Brown").to("Pink");
//
//
//        gossips.say("Hello").to("White");
//        gossips.say("ByeBye").to("Black");
//
//        gossips.spread();
//
//        assertThat(gossips.ask("Brown")).isEqualTo("Hello");
//        assertThat(gossips.ask("Pink")).isEqualTo("");
//
//        gossips.spread();
//        assertThat(gossips.ask("Brown")).isEqualTo("Hello, ByeBye");
//        assertThat(gossips.ask("Pink")).isEqualTo("Hello");
//
//        gossips.spread();
//
//        assertThat(gossips.ask("Brown")).isEqualTo("Hello, ByeBye");
//        assertThat(gossips.ask("Pink")).isEqualTo("ByeBye");
//
//    }
//
//
//    @Test
//    public void alwaysBeListenedByAnAgent() {
//
//        Gossips gossips = new Gossips("Mr White", "Mr Grey", "Agent Pink","Mr Blue")
//                .from("White").to("Pink")
//                .from("Grey").to("Pink")
//                .from("Pink").to("Blue");
//
//        gossips.say("Hello").to("White");
//        gossips.say("Shade").to("Grey");
//
//        gossips.spread();
//
//        assertThat(gossips.ask("Blue")).isEqualTo("");
//        assertThat(gossips.ask("Blue")).isEqualTo("");
//        assertThat(gossips.ask("Pink")).isEqualTo("Hello, Shade");
//
//        gossips.spread();
//
//        assertThat(gossips.ask("Pink")).isEqualTo("");
//        assertThat(gossips.ask("Blue")).isEqualTo("");
//    }
//
//    @Test
//    public void beStoppedByAnAgent() {
//
//        Gossips gossips = new Gossips("Mr White", "Agent Pink","Mr Blue")
//                .from("White").to("Pink")
//                .from("Pink").to("Blue");
//
//        gossips.say("Hello").to("White");
//
//        gossips.spread();
//
//        assertThat(gossips.ask("Pink")).isEqualTo("Hello");
//        assertThat(gossips.ask("Blue")).isEqualTo("");
//
//        gossips.spread();
//
//        assertThat(gossips.ask("Pink")).isEqualTo("");
//        assertThat(gossips.ask("Blue")).isEqualTo("");
//    }
//
//    @Test
//    public void beDelayedOneTurnByAProfessor() {
//
//        Gossips gossips = new Gossips("Mr White", "Pr Pink", "Mr Blue")
//                .from("White").to("Pink")
//                .from("Pink").to("Blue");
//
//        gossips.say("Hello").to("White");
//
//        gossips.spread();
//
//        assertThat(gossips.ask("Pink")).isEqualTo("Hello");
//        assertThat(gossips.ask("Blue")).isEqualTo("");
//
//        gossips.spread();
//
//        assertThat(gossips.ask("Pink")).isEqualTo("Hello");
//        assertThat(gossips.ask("Blue")).isEqualTo("");
//
//        gossips.spread();
//
//        assertThat(gossips.ask("Pink")).isEqualTo("");
//        assertThat(gossips.ask("Blue")).isEqualTo("Hello");
//    }
//
//    @Test
//    public void bePropagatedByALadyWhenComingFromADoctor() {
//
//        Gossips gossips = new Gossips("Dr Black", "Lady Green", "Agent Pink")
//                .from("Black").to("Green")
//                .from("Green").to("Pink");
//
//        gossips.say("Secret").to("Black");
//
//        gossips.spread();
//
//        assertThat(gossips.ask("Green")).isEqualTo("Secret");
//
//        gossips.spread();
//
//        assertThat(gossips.ask("Pink")).isEqualTo("Secret");
//
//    }
//
//    @Test@Ignore
//    public void notBePropagatedByALadyWhenComingAMister() {
//
//        Gossips gossips = new Gossips("Mr White", "Lady Green", "Agent Pink")
//                .from("White").to("Green")
//                .from("Green").to("Pink");
//
//        gossips.say("Hello").to("White");
//
//        gossips.spread();
//
//        assertThat(gossips.ask("Green")).isEqualTo("Hello");
//
//        gossips.spread();
//
//        assertThat(gossips.ask("Pink")).isEqualTo("");
//
//    }
//
//    @Test@Ignore
//    public void beReturnedAndInvertedByGentlemen() {
//
//        Gossips gossips = new Gossips("Mr White", "Sir Rose", "Mr Black")
//                .from("White").to("Rose")
//                .from("Rose").to("Black");
//
//
//        gossips.say("Hello").to("White");
//
//        gossips.spread();
//
//        assertThat(gossips.ask("White")).isEqualTo("");
//        assertThat(gossips.ask("Rose")).isEqualTo("Hello");
//        assertThat(gossips.ask("Black")).isEqualTo("");
//
//        gossips.spread();
//
//        assertThat(gossips.ask("White")).isEqualTo("olleH");
//        assertThat(gossips.ask("Rose")).isEqualTo("");
//        assertThat(gossips.ask("Black")).isEqualTo("");
//
//        gossips.spread();
//
//        assertThat(gossips.ask("White")).isEqualTo("");
//        assertThat(gossips.ask("Rose")).isEqualTo("olleH");
//        assertThat(gossips.ask("Black")).isEqualTo("");
//    }
//
//
//}