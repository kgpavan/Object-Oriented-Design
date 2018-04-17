//import org.hamcrest.Matcher;
//
//
//public class Morpion {
//
//	public static final String LINE_SEPARATOR = System.getProperty("line.separator");
//	private Player firstPlayer;
//	private Player secondPlayer;
//	private Player winnerPlayer;
//	private Game game;
//	private static final MorpionFactory morpionFactory = new MorpionFactory();
//
//	public Morpion(String gameDimension, String firstPlayer, String secondPlayer) {
//		this.game = morpionFactory.getGame(gameDimension);
//		this.firstPlayer = morpionFactory.getPlayer(firstPlayer);
//		this.secondPlayer = morpionFactory.getPlayer(secondPlayer);
//	}
//
//	public void play(String playerName, String gameCell) {
//	    Player currentPlayer = new Player(playerName, "");
//
//	    if(currentPlayer.equals(firstPlayer)){
//	        winnerPlayer = game.play(firstPlayer, gameCell);
//	    }else{
//	        winnerPlayer = game.play(secondPlayer, gameCell);
//	    }
//	}
//
//	public String report() {
//		int freeCellCount = game.getFreeGameCellCount();
//		if( ! (winnerPlayer instanceof NullPlayer)){
//		    return reportGameOver();
//		}
//		if(freeCellCount != 0){
//		    return reportOngoingGame(freeCellCount);
//		}else{
//		    return "Game Over, equality";
//		}
//	}
//
//	private String reportGameOver() {
//        return "Game Over, "+winnerPlayer.toString()+" is a winner";
//    }
//
//    private String reportOngoingGame(int freeCellCount) {
//	    int remainingPlaysFirstPlayer = freeCellCount / 2 + 1;
//	    int remainingPlaysSecondPlayer = freeCellCount / 2;
//	    return remainingPlaysFirstPlayer+" games for "+firstPlayer.toString()+", "
//	            + remainingPlaysSecondPlayer+" games for "+secondPlayer.toString();
//    }
//
//    public String display() {
//		return game.display();
//	}
//
//}
