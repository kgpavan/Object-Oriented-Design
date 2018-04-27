//package com.sqli.test.dishes;
//
//import static org.junit.Assert.assertEquals;
//
//import org.junit.Test;
//
///**
// *
// * The objective of the exercise is to measure the signal quality for a canal of a given satellite on a scale of 10, depending on the available dishes.<br/>
// * Each deviation of 0.1� with the right satellite weakens the signal by -1. With more than 1� deviation, the signal is lost completely.<br/><br/>
// *
// * L'objectif de l'exercice est de mesurer la qualit� du signal pour une chaine d'un satellite donn� sur une �chelle de 10, en fonction des paraboles disponibles.<br/>
// * Chaque �cart de 0,1� avec le bon satellite affaiblit le signal par -1. Avec plus de 1� de d�viation, le signal est perdu compl�tement.<br/><br/>
// *
// * Used satellite in this exercise :<br/>
// * ASTRA (A) : 19.2�E <br/>
// * HOTBIRD (H) : 13.0�E <br/>
// * NILESAT (N) : 7.0�W <br/>
// *
// */
//public class DishesTest {
//
//	@Test
//	public void RTMShouldBeWellDisplayed() {
//		// FORMAT : "id,orientation"
//		Dishes dishes = new Dishes("1,7W");
//		// FORMAT : "name, SATELLITE"
//		assertEquals("|**********|", dishes.signal("RTM, N"));
//	}
//
//	@Test
//	public void ZDFShouldBeDisplayedBadlyAndEuronewsShouldNotBeDisplayed() {
//		Dishes dishes = new Dishes("1,7W", "2,19E");
//		assertEquals("No signal !", dishes.signal("Euronews, H"));
//		assertEquals("|********..|", dishes.signal("ZDF, A"));
//	}
//
//	@Test
//	public void shouldFindTheBestQuality() throws Exception {
//		Dishes dishes = new Dishes("1,19E", "2,19.3E");
//		assertEquals("|*********.|", dishes.signal("ZDF, A"));
//	}
//
//	@Test
//	public void EuronewsShouldBeDisplayedIfDishIsMoved() {
//		Dishes dishes = new Dishes("1,7W", "2,19E");
//		dishes.move("2", "6.7W");
//		assertEquals("|***.......|", dishes.signal("Euronews, H"));
//		dishes.move("2", "0.6E");
//		assertEquals("|*********.|", dishes.signal("Euronews, H"));
//	}
//
//	@Test
//	public void RTMShouldBeDisplayedIfDishIsMoved() {
//		Dishes dishes = new Dishes("1,13E");
//		dishes.move("1", "20.5W");
//		assertEquals("|*****.....|", dishes.signal("RTM, N"));
//	}
//
//}
