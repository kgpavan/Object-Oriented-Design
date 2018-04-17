//package Q7_08_Othello;
package design.practice.othello;

public class Question {

    public static void testOthello() {

        Game game = Game.getInstance();
        game.getBoard().initialize();
        game.getBoard().printBoard();
        Automator automator = Automator.getInstance();

        while (!automator.isOver() && automator.playRandom()) {
        }

        automator.printScores();
    }
}
