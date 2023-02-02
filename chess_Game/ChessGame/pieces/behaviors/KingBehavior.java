package ChessGame.pieces.behaviors;

import ChessGame.boards.Board;
import ChessGame.boards.Location;

public class KingBehavior extends QueenBehavior {

    @Override
    public boolean canMove(Board board, Location origin, Location destination) {
        int xDist = Math.abs(origin.getX() - destination.getX());
        int yDist = Math.abs(origin.getY() - destination.getY());

        // Return true if the movement is no more than one square away in any direction
        return xDist <= 1 && yDist <= 1 && super.canMove(board, origin, destination);
    }
}
