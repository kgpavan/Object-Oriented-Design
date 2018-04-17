package design.practice.designEx.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    public static void main(String[] args) {
//        String string = "00ASDA872HNjnjkz7DH";
//        System.out.println(getUpperCase(string));
//
//        String intervals = "[2.2, 21] [1,3.3]";
//        List<Double> listDoubles = getDouble(intervals);
//        for (Double d : listDoubles) {
//            System.out.println(d);
//        }
        
        String stringWithEmails = "envoyer ce text aux personne suivante: person1@gmail.net, "
                                    + "person2@yahoo.com, pe_ure@msn.org le plutot possible";

        List<String> listEmails = getEmail(stringWithEmails);
        
        for (String email : listEmails) {
            System.out.println(email);
        }
        
        String inputWithDateAndHour = "document recu le 21/05/2015 a l'heure 13:14";// => "21/05/2015 @ 13:14";
        System.out.println(getDates(inputWithDateAndHour));
    }

    private static String getUpperCase(String input) {
        return input.replaceAll("[^A-Z]", "");
    }

    private static List<Double> getDouble(String string) {
        Pattern pattern = Pattern.compile("\\d+(\\.\\d+)?");
        Matcher matcher = pattern.matcher(string);

        List<Double> listDoubles = new ArrayList<Double>();
        while (matcher.find()) {
            listDoubles.add(Double.parseDouble(matcher.group()));
        }

        return listDoubles;
    }

    private static List<String> getEmail(String string) {
        List<String> listEmails = new ArrayList<String>();
//        Pattern pattern = Pattern.compile("\\w+@\\w+\\.\\w+");
        Pattern pattern = Pattern.compile("\\w+@\\w+\\.(com|net|org)");
        Matcher matcher = pattern.matcher(string);

        while (matcher.find()) {
            listEmails.add(matcher.group());
        }
        return listEmails;
    }
    
    
    private static String getDates(String input) {
        //"document recu le 21/05/2015 a l'heure 13:14"
        Pattern patternDate = Pattern.compile("\\d{1,2}/\\d{1,2}/\\d{4}");
        Pattern patternHour = Pattern.compile("\\d{1,2}:\\d{1,2}");
        Matcher matcherDate = patternDate.matcher(input);
        Matcher matcherHour = patternHour.matcher(input);
        if(matcherDate.find() && matcherHour.find()){
            return matcherDate.group()+" @ "+matcherHour.group();
        }
        return null;
    }
    
    public void getSmallerThatMatch() {

        String str = "abc1cef253";
//        Pattern pattern = Pattern.compile(".?\\d"); // return abc1cef253 
        Pattern pattern = Pattern.compile(".+?\\d");  //return abc1
        Matcher matcher = pattern.matcher(str);
        List<String> b = new ArrayList<String>();

        while (matcher.find()) {
            String a = matcher.group();
            b.add(a);

        }
        System.out.println(b);
    }
}
