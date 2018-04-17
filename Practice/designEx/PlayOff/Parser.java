//package design.practice.designEx.PlayOff;
//
//import java.util.Map;
//import java.util.TreeMap;
//
//
//public class Parser {
//
//    public static Map<Integer, String> getQualificationResult(String[] qualificationsResults) {
//        Map<Integer, String> qualificationResults = new TreeMap<Integer, String>();
//        for (int i = 0; i < qualificationsResults.length; i++) {
//
//            String[] teams = getTeamsFromMatch(qualificationsResults[i]);
//
//            if(!isTeamsInQualificationResults(qualificationResults, teams))
//                addNewTeams(qualificationResults, teams);
//
//            increaseNumberOfWins(teams[0]);
//        }
//        return null;
//    }
//
//    private static boolean isTeamsInQualificationResults(Map<Integer, String> qualificationResults, String[] teams) {
//
//        return false;
//    }
//
//    private static String[] getTeamsFromMatch(String match) {
//        return match.split(" ");
//    }
//
//}
