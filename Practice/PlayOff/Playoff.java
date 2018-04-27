//package design.practice.designEx.PlayOff;
//
//import java.util.Map;
//import java.util.TreeMap;
//
//
//public class Playoff {
//
//    private Map<Integer, String> qualificaionResults;
//
//    public Playoff(String[] qualificationsResults) {
//        this.qualificaionResults = Parser.getQualificationResult(qualificationsResults);
//
//    }
//
//    public String[] layout() {
//        Map<Integer, String> topFourTeams = getTopTeams(4);
//
//        return getPlayOffMatches(topFourTeams);
//    }
//
//    private Map<Integer, String> getTopTeams(int numberOfTeams) {
//        int counter = 0;
//        Map<Integer, String> target = new TreeMap<Integer, String>();
//
//        for (Map.Entry<Integer, String> entry: qualificaionResults.entrySet()) {
//           if (counter >= numberOfTeams) break;
//
//           target.put(entry.getKey(), entry.getValue());
//           counter++;
//        }
//        return target;
//    }
//
//    private String[] getPlayOffMatches(Map<Integer, String> topFourTeams) {
//
//        String firstPlayOffMatch = topFourTeams.keySet().toArray()[0]+" vs "+topFourTeams.keySet().toArray()[3];
//        String secondPlayOffMatch = topFourTeams.keySet().toArray()[1]+" vs "+topFourTeams.keySet().toArray()[2];
//        return new String[]{firstPlayOffMatch, secondPlayOffMatch};
//    }
//
//
//
//}