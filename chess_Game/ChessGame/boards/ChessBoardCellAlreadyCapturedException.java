package ChessGame.boards;

import ChessGame.pieces.ChessPiece;

public class ChessBoardCellAlreadyCapturedException extends Exception {
    public ChessBoardCellAlreadyCapturedException(ChessPiece piece) {
        super("The piece '" + piece.getName() + " owned by player " + piece.getPlayer() + ") is captured;" +
                " it cannot be captured another time");
    }
}
