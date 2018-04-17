package design.practice.designEx.tictactoo;

import java.util.List;


public class Main {

    public static void main(String[] args) {
        
        List<Game> games = GameFactory.getGamesFromFile("tictacotoe.txt");
        
        for (Game game : games) {
            System.out.println(game.getWinner());
        }
    }
}
