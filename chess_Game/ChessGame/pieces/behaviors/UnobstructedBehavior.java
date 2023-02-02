package ChessGame.pieces.behaviors;

import ChessGame.boards.Board;
import ChessGame.boards.ChessBoardOutOfBoundsException;
import ChessGame.boards.Location;


public class UnobstructedBehavior implements Behavior {

    public boolean canMove(Board board, Location origin, Location destination) {

        int xDist = destination.getX() - origin.getX();
        int yDist = destination.getY() - origin.getY();
        int originX = origin.getX();
        int originY = origin.getY();

        // Check the cells on the path and make sure they aren't obstructed
        try {
            // Each iteration will add this to the coordinate
            int yStep = (yDist == 0 ? 0 : Math.abs(yDist) / yDist);
            int xStep = (xDist == 0 ? 0 : Math.abs(xDist) / xDist);
            int iterations = Math.abs(xDist) - 1;

            originX += xStep;
            originY += yStep;

            for (int i = 0; i < iterations; ++i) {
                if (board.getCell(originX, originY).isOccupied())
                    return false;

                originX += xStep;
                originY += yStep;
            }
        } catch (ChessBoardOutOfBoundsException e) {
            return false;
        }

        return true;
    }
}
