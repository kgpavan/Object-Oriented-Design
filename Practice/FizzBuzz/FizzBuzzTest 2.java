//package com.training.fizzbuzz;
//
//import static org.junit.Assert.assertEquals;
//
//import java.io.IOException;
//import java.io.StringWriter;
//
//import org.junit.Test;
//
//public final class FizzBuzzTest {
//
//    @Test
//    public void fizzBuzz() throws IOException {
//        StringWriter out = new StringWriter();
//        FizzBuzz fizzBuzz = new FizzBuzz(1, 100);
//        fizzBuzz.generate(out);
//        assertEquals("FAILED", EXPECTED_ONE_TO_100, out.toString().trim());
//        System.out.println("SUCCESS");
//    }
//
//    /* Regression en software programing ???
//
//    // Minimiser les variations en ettendre les axes de modifications le moins possible (rapprocher � OC)
//    // CO-----------------------$---OC
//    // XXXXXXXXXXXXXXXXXXXXXXXXXXX
//
//    // Au niveau design
//    // Class X herite de classe Abstraite depend de type objet
//    // Class X implemente de l'interface depende de comportement
//     La modelisation est dirig�e par le comportement
//
//
//
//     - Ioc : Invers the control : make sure to control dependencies of object, not in application itself
//
//     MVC - MVP ???
//
//
//
//
//    */
//    private static final String EXPECTED_ONE_TO_100 = "1: \n" +
//        "2: \n" +
//        "3: Fizz\n" +
//        "4: \n" +
//        "5: Buzz\n" +
//        "6: Fizz\n" +
//        "7: \n" +
//        "8: \n" +
//        "9: Fizz\n" +
//        "10: Buzz\n" +
//        "11: \n" +
//        "12: Fizz\n" +
//        "13: \n" +
//        "14: \n" +
//        "15: FizzBuzz\n" +
//        "16: \n" +
//        "17: \n" +
//        "18: Fizz\n" +
//        "19: \n" +
//        "20: Buzz\n" +
//        "21: Fizz\n" +
//        "22: \n" +
//        "23: \n" +
//        "24: Fizz\n" +
//        "25: Buzz\n" +
//        "26: \n" +
//        "27: Fizz\n" +
//        "28: \n" +
//        "29: \n" +
//        "30: FizzBuzz\n" +
//        "31: \n" +
//        "32: \n" +
//        "33: Fizz\n" +
//        "34: \n" +
//        "35: Buzz\n" +
//        "36: Fizz\n" +
//        "37: \n" +
//        "38: \n" +
//        "39: Fizz\n" +
//        "40: Buzz\n" +
//        "41: \n" +
//        "42: Fizz\n" +
//        "43: \n" +
//        "44: \n" +
//        "45: FizzBuzz\n" +
//        "46: \n" +
//        "47: \n" +
//        "48: Fizz\n" +
//        "49: \n" +
//        "50: Buzz\n" +
//        "51: Fizz\n" +
//        "52: \n" +
//        "53: \n" +
//        "54: Fizz\n" +
//        "55: Buzz\n" +
//        "56: \n" +
//        "57: Fizz\n" +
//        "58: \n" +
//        "59: \n" +
//        "60: FizzBuzz\n" +
//        "61: \n" +
//        "62: \n" +
//        "63: Fizz\n" +
//        "64: \n" +
//        "65: Buzz\n" +
//        "66: Fizz\n" +
//        "67: \n" +
//        "68: \n" +
//        "69: Fizz\n" +
//        "70: Buzz\n" +
//        "71: \n" +
//        "72: Fizz\n" +
//        "73: \n" +
//        "74: \n" +
//        "75: FizzBuzz\n" +
//        "76: \n" +
//        "77: \n" +
//        "78: Fizz\n" +
//        "79: \n" +
//        "80: Buzz\n" +
//        "81: Fizz\n" +
//        "82: \n" +
//        "83: \n" +
//        "84: Fizz\n" +
//        "85: Buzz\n" +
//        "86: \n" +
//        "87: Fizz\n" +
//        "88: \n" +
//        "89: \n" +
//        "90: FizzBuzz\n" +
//        "91: \n" +
//        "92: \n" +
//        "93: Fizz\n" +
//        "94: \n" +
//        "95: Buzz\n" +
//        "96: Fizz\n" +
//        "97: \n" +
//        "98: \n" +
//        "99: Fizz\n" +
//        "100: Buzz";
//}
