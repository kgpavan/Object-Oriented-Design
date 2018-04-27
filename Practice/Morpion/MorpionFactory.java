//package design.practice.designEx.Morpion;
//
//public class MorpionFactory {
//
//    public Game getGame(String dimension) {
//        int gameDimension = Integer.valueOf(dimension.charAt(0)+"");
//        return new Game(gameDimension);
//    }
//
//    public Player getPlayer(String playerInput) {
//
//        String [] playerParameters = splitString(playerInput, ":");
//        String playerName = playerParameters[0];
//        String playingCharacter = playerParameters[1];
//        return new Player(playerName, playingCharacter);
//    }
//
//    private String[] splitString(String playerInput, String separator) {
//        return playerInput.split(separator);
//    }
//
//
//}
