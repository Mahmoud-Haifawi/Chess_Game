package ChessGame.games;

import ChessGame.boards.ChessBoardCellNotOccupiedException;
import ChessGame.boards.Location;


public class MoveNotValidException extends Exception {
    public MoveNotValidException(String reason) {
        super(reason);
    }

    public MoveNotValidException(Location origin, Location destination)
            throws ChessBoardCellNotOccupiedException {
        super("Moving " + (origin.isOccupied() ? origin.getPiece() : "nothing") +
                " from " + origin + " to " + destination + " is not a valid move");
    }
}
