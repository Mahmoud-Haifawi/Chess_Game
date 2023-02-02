package ChessGame.pieces.behaviors;

import ChessGame.boards.Board;
import ChessGame.boards.Location;


public class BishopBehavior implements Behavior {

    private final UnobstructedBehavior unobstructedBehavior;

    public BishopBehavior() {
        this.unobstructedBehavior = new UnobstructedBehavior();
    }

    public boolean canMove(Board board, Location origin, Location destination) {

        int xDist = destination.getX() - origin.getX();
        int yDist = destination.getY() - origin.getY();

        // Bishops can only move in perfect diagonals
        if (Math.abs(xDist) != Math.abs(yDist))
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
