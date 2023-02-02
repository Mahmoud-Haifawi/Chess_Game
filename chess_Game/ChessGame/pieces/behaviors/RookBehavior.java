package ChessGame.pieces.behaviors;

import ChessGame.boards.Board;
import ChessGame.boards.Location;
import org.jetbrains.annotations.NotNull;


public class RookBehavior implements Behavior {

    private final UnobstructedBehavior unobstructedBehavior;

    public RookBehavior() {
        this.unobstructedBehavior = new UnobstructedBehavior();
    }


    public boolean canMove(Board board, @NotNull Location origin, @NotNull Location destination) {

        int xDist = origin.getX() - destination.getX();
        int yDist = origin.getY() - destination.getY();

        // Rooks can only move in straight lines
        if (xDist != 0 && yDist != 0)
            return false;

        // They still have to move, though!
        if (xDist == 0 && yDist == 0)
            return false;

        // Is the destination is occupied, we must be able to capture it
        if (destination.isOccupied()) {
            if (!origin.getPiece().canCapture(destination.getPiece()))
                return false;
        }

        return this.unobstructedBehavior.canMove(board, origin, destination);
    }

}
