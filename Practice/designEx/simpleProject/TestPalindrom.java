//package com.sqli.training.string.test;
//
//import static org.junit.Assert.assertEquals;
//
//import org.junit.Test;
//
//import com.nespresso.git.training.MyClass;
//
//
//
//public class TestPalindrom {
//
//
//    @Test
//    public void testIsPalindrom(){
//        assertEquals(true , MyClass.isPalindrom("aabbaa"));
//        assertEquals(true , MyClass.isPalindrom("A*b == b*A"));
//        assertEquals(false, MyClass.isPalindrom("abcdba"));
//
//    }
//
//    @Test
//    public void testExtractDigits(){
//        assertEquals(123, MyClass.extractDigits("AS1JK?2jd�3../jkqsnfjksnqdfknqsdfnqsdfnklmq"));
//    }
//
//    @Test
//    public void testFirstCharToUpperCase(){
//        assertEquals("The   Book", MyClass.firstLetterToUpperCase("the   book"));
//    }
//
//    @Test
//    public void testFirstCharToUpperCaseWithSperator(){
//        assertEquals("The____Book", MyClass.firstLetterToUpperCaseWithSeperator("the____book", '_'));
//        assertEquals("The-World--------War-Ii",
//                MyClass.firstLetterToUpperCaseWithSeperator("The-world--------war-ii", '-'));
////        assertEquals("The Book", MyClass.firstLetterToUpperCaseSplit("the book", " "));
//    }
//}
