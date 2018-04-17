package design.practice.designEx.tictactoo;


public class Game {

    private int gameSize;
    private Player[][] players;
    
    public Game(int gameSize, Player[][] players) {
        this.gameSize = gameSize;
        this.players = players;
    }

    public Player getWinner() {
        Player firstPlayer = new Player('x');
        Player secondPlayer = new Player('o');
        
        if(winnerByLine(firstPlayer) || winnerByColumn(firstPlayer) || winnerByDiagonal(firstPlayer)){
            return firstPlayer;
        }else if(winnerByLine(secondPlayer) || winnerByColumn(secondPlayer) || winnerByDiagonal(secondPlayer)){
            return secondPlayer;
        }else{
            return new NullPlayer();
        }
    }

    private boolean winnerByDiagonal(Player player) {
        boolean winnerByFirstColumn = true;
        for (int i = 0; i < players.length; i++) {
            if( ! players[i][i].equals(player)){
                winnerByFirstColumn = false;
            }
        }
        if(winnerByFirstColumn){
            return true;
        }
        for (int i = 0; i < players.length; i++) {
            if( ! players[i][gameSize - 1 - i ].equals(player)){
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
    
    

}
