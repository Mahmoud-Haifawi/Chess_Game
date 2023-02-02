package ChessGame.games;

import ChessGame.boards.Board;
import ChessGame.boards.StandardBoard;


public class StandardChessGame extends ChessGame {

    public StandardChessGame() throws Exception {
        super();
    }

    public Board getNewBoard() throws Exception {
        return new StandardBoard();
    }
}
