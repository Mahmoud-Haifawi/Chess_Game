package ChessGame.pieces.behaviors;

import ChessGame.boards.Board;
import ChessGame.boards.Location;


public class QueenBehavior implements Behavior {

    BishopBehavior bishopBehavior;
    RookBehavior rookBehavior;

    public QueenBehavior() {
        this.bishopBehavior = new BishopBehavior();
        this.rookBehavior = new RookBehavior();
    }

    public boolean canMove(Board board, Location origin, Location destination) {
        return this.bishopBehavior.canMove(board, origin, destination)
                || this.rookBehavior.canMove(board, origin, destination);
    }
}
