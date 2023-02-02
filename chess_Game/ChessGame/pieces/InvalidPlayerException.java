package ChessGame.pieces;

public class InvalidPlayerException extends Exception {
    public InvalidPlayerException(ChessPiece piece, int player) {
        super("Cannot assign " + piece.getName() + " to player " + player + ";" +
                " valid player IDs are 0 and 1");
    }
}