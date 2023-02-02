package ChessGame.boards;

import ChessGame.pieces.ChessPiece;


public class ChessBoardCellAlreadyOccupiedException extends Exception {
    public ChessBoardCellAlreadyOccupiedException(ChessPiece piece) {
        super("The piece '" + piece.getName() + " is owned by player " + piece.getPlayer() + ");" +
                " it cannot be captured by a piece from the same player");
    }
}
