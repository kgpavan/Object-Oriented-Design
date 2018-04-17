//public class ChessPieceTurn {
//
//	// some code
//};
//
//public class GameManager {
//	void processTurn(PlayerBase player) { };
//	boolean acceptTurn(ChessPieceTurn turn) { return true; };
//	Position currentPosition;
//}
//
//public abstract class PlayerBase {
//	public abstract ChessPieceTurn getTurn(Position p);
//}
//
//
//class ComputerPlayer extends PlayerBase {
//	public ChessPieceTurn getTurn(Position p) { return null; }
//	public void setDifficulty() { };
//	public PositionEstimator estimater;
//	public PositionBackTracker backtracter;
//}
//
//
//
//public class HumanPlayer extends PlayerBase {
//	public ChessPieceTurn getTurn(Position p) {
//		return null;
//	}
//}
//
//public abstract class ChessPieceBase {
//	abstract boolean canBeChecked();
//	abstract boolean isSupportCastle();
//}
//
//
//public class King extends ChessPieceBase { ... }
//public class Queen extends ChessPieceBase { ... }
//
//
//
//public class Position { // represents chess positions in compact form ArrayList<ChessPieceBase> black;
//
//	ArrayList<ChessPieceBase> white;
//}
//
//
//public class PositionBackTracker {
//
//	public static Position getNext(Position p) {
//
//		return null;
//	}
//}
//
//public class PositionEstimator {
//
//	public static PositionPotentialValue estimate(Position p) { ... }
//}
//
//public abstract class PositionPotentialValue {
//
//	abstract boolean lessThan(PositionPotentialValue pv);
//}
//
