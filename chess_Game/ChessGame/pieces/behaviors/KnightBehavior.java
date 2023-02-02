package ChessGame.pieces.behaviors;

import ChessGame.boards.Board;
import ChessGame.boards.Location;
import org.jetbrains.annotations.NotNull;


public class KnightBehavior implements Behavior {
    public boolean canMove(Board board, @NotNull Location origin, @NotNull Location destination) {
        int verticalDistance = Math.abs(destination.getY() - origin.getY());
        int horizontalDistance = Math.abs(destination.getX() - origin.getX());

        // The piece can move two squares vertically and one horizontally
        boolean isTypeOne = (verticalDistance == 2 && horizontalDistance == 1);

        // Or two squares horizontally, and one square vertically
        boolean isTypeTwo = (verticalDistance == 1 && horizontalDistance == 2);

        // Otherwise it is an invalid move
        if (!isTypeOne && !isTypeTwo)
            return false;

        // It can jump over pieces, but we still have to check if it can capture its landing zone

        // Is the destination is occupied, we must be able to capture it
        if (destination.isOccupied()) {
            return origin.getPiece().canCapture(destination.getPiece());
        }

        return true;
    }
}
