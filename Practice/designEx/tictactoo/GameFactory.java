package design.practice.designEx.tictactoo;

import java.util.ArrayList;
import java.util.List;


public class GameFactory {

    public static List<Game> getGamesFromFile(String filePath){
        List<Game> games = new ArrayList<Game>();
        
        List<String> lines = TicTacToeReader.getLines(filePath);
        for (String line : lines) {
            Game game = getGame(line);
            games.add(game);
        }
        return games;
    }

    private static Game getGame(String line) {
        int gameSize = Integer.parseInt(line.split("\\s")[0]);
        Player [][] players = getPlayers(line.split("\\s")[1], gameSize);
        
        return new Game(gameSize, players);
    }

    private static Player[][] getPlayers(String playersMarks, int gameSize) {
        Player [][] players = new Player[gameSize][gameSize];
        
        for (int i = 0; i < gameSize; i++) {
            for (int j = 0; j < gameSize; j++) {
                if(playersMarks.charAt(i * gameSize + j) == 'e'){
                    players[i][j] = new NullPlayer();
                }else{
                    players[i][j] = new Player(playersMarks.charAt(i * gameSize + j));
                }
            }
        }
        return players;
    }
}
