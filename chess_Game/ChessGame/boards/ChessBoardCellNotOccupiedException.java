package ChessGame.boards;


public class ChessBoardCellNotOccupiedException extends Exception {
    public ChessBoardCellNotOccupiedException(Location cell) {
        super("Cell (" + cell.getX() + "," + cell.getY() + ") is not occupied;" +
                " there is no piece to get");
    }
}
