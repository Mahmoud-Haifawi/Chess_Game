package ChessGame.pieces.behaviors;

import ChessGame.boards.Board;
import ChessGame.boards.Location;


public interface Behavior {

    boolean canMove(Board board, Location origin, Location destination);
}
