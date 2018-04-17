package design.practice.designEx.tictactoe;

import java.util.ArrayList;
import java.util.List;


public class GameFactory {

    public List<Game> getGamesFromFile(String filePath){
        List<String> games = TicTacToeReader.getLinesFromFile(filePath);
        List<Game> listGames = new ArrayList<Game>();
        
        for (String oneGame : games) {
            Game game = getGameFromString(oneGame);
            game.toString();
            listGames.add(game);
        }
        
        return listGames;
    }

    private Game getGameFromString(String oneGame) {
        int gameSize = Integer.parseInt(oneGame.split(" ")[0]);
        Player [][] players = getPlayers(oneGame.split(" ")[1], gameSize);
        
        return new Game(gameSize, players);
    }

    private Player[][] getPlayers(String playersString, int gameSize) {
        Player [][] players = new Player[gameSize][gameSize];
        String [] playersMark  = playersString.split("");
        System.out.println(playersMark[0]);
        for (int i = 0; i < gameSize; i++) {
            for (int j = 0; j < gameSize; j++) {
                if(playersMark[i * gameSize +j + 1].equals("e")){
                    players[i][j] = new NullPlayer();
                }else{
                    Player player = new Player(playersMark[i * gameSize + j + 1]);
                    players[i][j] = player;
                }
            }
        }
        return players;
    }
}
