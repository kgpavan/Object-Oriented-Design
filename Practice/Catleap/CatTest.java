package com.nespresso.exercice.cat;

import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class CatTest {

   @Test
   public void test() {
       Cat cat = new Cat();
       assertEquals("*", cat.path());
       cat.leap();
       assertEquals("*.*", cat.path());
       cat.leap();
       assertEquals("*.*..*", cat.path());
       cat.leap();
       assertEquals("*.*..*...*", cat.path());
       cat.leap();
       assertEquals("*.*..*...*....*", cat.path());
       cat.leap();
       assertEquals("*.*..*...*....*....*", cat.path());
   }
}