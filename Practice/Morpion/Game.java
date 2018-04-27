//package design.practice.designEx.Morpion;
//
//public class Game {
//
//    private Player[][] players;
//
//    public Game(int gameDimension) {
//        initGame(gameDimension);
//    }
//
//    private void initGame(int gameDimension) {
//        players = new Player[gameDimension][gameDimension];
//        for (int i = 0; i < players.length; i++) {
//            for (int j = 0; j < players[i].length; j++) {
//                players[i][j] = new NullPlayer();
//            }
//        }
//    }
//
//    public int getFreeGameCellCount() {
//        int freeCellCount = 0;
//        for (int i = 0; i < players.length; i++) {
//            for (int j = 0; j < players[i].length; j++) {
//                if (players[i][j] instanceof NullPlayer)
//                    freeCellCount++;
//            }
//        }
//        return freeCellCount;
//    }
//
//    public Player play(Player player, String gameCell) {
//        int[] gameCellIndex = getGameCell(gameCell);
//        int lineIndex = gameCellIndex[0];
//        int columnIndex = gameCellIndex[1];
//        if (players[lineIndex][columnIndex] instanceof NullPlayer) {
//            players[lineIndex][columnIndex] = player;
//        } else {
//            throw new BoxAlreadySelectedException();
//        }
//        return getWinner(player);
//    }
//
//    private Player getWinner(Player player) {
//        if (hasCompleteDiagonal(player) || hasCompleteLine(player) || hasCompleteColumn(player)) {
//            return player;
//        } else {
//            return new NullPlayer();
//        }
//    }
//
//    private boolean hasCompleteColumn(Player player) {
//
//        outerLoop:
//        for (int i = 0; i < players.length; i++) {
//            for (int j = 0; j < players[i].length; j++) {
//                if ( ! players[i][j].equals(player))
//                    continue outerLoop;
//            }
//            return true;
//        }
//        return false;
//    }
//
//    private boolean hasCompleteLine(Player player) {
//
//        outerLoop:
//        for (int i = 0; i < players.length; i++) {
//            for (int j = 0; j < players[i].length; j++) {
//                if ( ! players[j][i].equals(player))
//                    continue outerLoop;
//            }
//            return true;
//        }
//        return false;
//    }
//
//    private boolean hasCompleteDiagonal(Player player) {
//
//        for (int i = 0; i < players.length; i++) {
//            if(! players[i][i].equals(player)){
//                return false;
//            }
//        }
//        return true;
//    }
//
//    private int[] getGameCell(String gameCell) {
//        String[] gameCellElements = gameCell.split("x");
//        int[] gameCellIndex = { Integer.valueOf(gameCellElements[0]), Integer.valueOf(gameCellElements[1]) };
//        return gameCellIndex;
//    }
//
//    public String display() {
//        StringBuilder builder = new StringBuilder();
//        for (int i = 0; i < players.length; i++) {
//            for (int j = 0; j < players[i].length; j++) {
//                players[i][j].print(builder);
//                builder.append("|");
//            }
//            builder.setLength(builder.length() - 1);
//            builder.append(Morpion.LINE_SEPARATOR);
//        }
//        return builder.toString();
//    }
//}
