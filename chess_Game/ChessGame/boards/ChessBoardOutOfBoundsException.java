package ChessGame.boards;


public class ChessBoardOutOfBoundsException extends Exception {
    public ChessBoardOutOfBoundsException(int x, int y) {
        super("Cell (" + x + "," + y + ") is not on the board");
    }
}
