package ChessGame.boards;


public class EmptyStandardBoard extends Board {

    public EmptyStandardBoard() throws Exception {
        super();
    }

    public EmptyStandardBoard(EmptyStandardBoard other)
            throws ChessBoardOutOfBoundsException
            , ChessBoardCellNotOccupiedException
            , ChessBoardCellAlreadyCapturedException
            , ChessBoardCellAlreadyOccupiedException {
        super(other);
    }

    public Location[][] getBoard() {
        Location[][] board = new Location[8][8];

        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                board[i][j] = new Location(i, j, true);
            }
        }

        return board;
    }

    public Board copy() throws ChessBoardInvalidException {
        try {
            return new EmptyStandardBoard(this);
        } catch (Exception e) {
            throw new ChessBoardInvalidException(e.toString());
        }
    }
}
