package design.practice.designEx.tictactoe;

import java.util.ArrayList;
import java.util.List;


public class Game {

    private int gameSize;
    private Player [][] players;
    public Game(int gameSize, Player[][] players) {
        this.gameSize = gameSize;
        this.players = players;
    }
    
    
    public Player getWinner() {
        List<Player> distinctPlayer = getTheTwoPlayers();
        Player firstPlayer = distinctPlayer.get(0);
        Player secondPlayer = distinctPlayer.get(1);
        if(winnerByLine(firstPlayer) || winnerByColumn(firstPlayer) || winnerByDiagonal(firstPlayer)){
            return firstPlayer;
        }else if(winnerByLine(secondPlayer) || winnerByColumn(secondPlayer) || winnerByDiagonal(secondPlayer)){
            return secondPlayer;
        }else{
            return new NullPlayer();
        }

    }


    private boolean winnerByDiagonal(Player player) {
        boolean winnerByFirstDiagonal = true;
        for (int i = 0; i < players.length; i++) {
            if( ! players[i][i].equals(player)){
                winnerByFirstDiagonal = false;
            }
        }
        if(winnerByFirstDiagonal){
            return true;
        }
        for (int i = 0; i < players.length; i++) {
            if( ! players[i][players.length - 1 - i].equals(player)){
                return false;
            }
        }
        return true;
    }

    private boolean winnerByColumn(Player player) {
        outerLoop:
        for (int i = 0; i < players.length; i++) {
            for (int j = 0; j < players.length; j++) {
                if( ! players[j][i].equals(player)){
                    continue outerLoop;
                }
            }
            return true;
        }
        return false;
    }

    private boolean winnerByLine(Player player) {
        outerLoop:
        for (int i = 0; i < players.length; i++) {
            for (int j = 0; j < players.length; j++) {
                if( ! players[i][j].equals(player)){
                    continue outerLoop;
                }
            }
            return true;
        }
        return false;
    }


    private List<Player> getTheTwoPlayers() {
        List<Player> distinctPlayers = new ArrayList<Player>();
        outerLoop:
        for (int i = 0; i < players.length; i++) {
            for (int j = 0; j < players.length; j++) {
                if( ! distinctPlayers.contains(players[i][j]) && !(players[i][j] instanceof NullPlayer)){
                    distinctPlayers.add(players[i][j]);
                }else if(distinctPlayers.size() == 2){
                    break outerLoop;
                }
            }
        }
        return distinctPlayers;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < players.length; i++) {
            for (int j = 0; j < players.length; j++) {
                builder.append(players[i][j].toString()+"|");
            }
            builder.append("\n");
        }
        return builder.toString();
    }

}
