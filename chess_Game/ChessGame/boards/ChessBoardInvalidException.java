package ChessGame.boards;


public class ChessBoardInvalidException extends Exception {

    public ChessBoardInvalidException() {
        super("This chess board has not been implemented correctly");
    }

    public ChessBoardInvalidException(String message) {
        super(message);
    }
}
