package Tests;

import ChessGame.boards.Board;
import ChessGame.boards.EmptyStandardBoard;
import ChessGame.pieces.ChessPiece;
import org.jetbrains.annotations.NotNull;
import org.junit.Assert;


public class BishopBehaviorTest implements BehaviorTest {
    public void test(@NotNull ChessPiece whiteBishop, ChessPiece blackBishop) throws Exception {
        Board board = new EmptyStandardBoard();

        // Check that moving up left to edge is valid
        Assert.assertTrue(whiteBishop.canMove(board, board.getCell(4, 4), board.getCell(0, 0)));

        // Check that moving up right to edge is valid
        Assert.assertTrue(whiteBishop.canMove(board, board.getCell(4, 4), board.getCell(7, 1)));

        // Check that moving down left to edge is valid
        Assert.assertTrue(whiteBishop.canMove(board, board.getCell(4, 4), board.getCell(1, 7)));

        // Check that moving down right to edge is valid
        Assert.assertTrue(whiteBishop.canMove(board, board.getCell(4, 4), board.getCell(7, 7)));

        // Check that moving up left by one is valid
        Assert.assertTrue(whiteBishop.canMove(board, board.getCell(4, 4), board.getCell(0, 0)));

        // Check that moving up right by one is valid
        Assert.assertTrue(whiteBishop.canMove(board, board.getCell(4, 4), board.getCell(7, 1)));

        // Check that moving down left by one is valid
        Assert.assertTrue(whiteBishop.canMove(board, board.getCell(4, 4), board.getCell(1, 7)));

        // Check that moving down right by one is valid
        Assert.assertTrue(whiteBishop.canMove(board, board.getCell(4, 4), board.getCell(7, 7)));

        // Check that capturing an adjacent piece is valid
        board.setCell(4, 4, whiteBishop);
        board.setCell(5, 5, blackBishop);
        Assert.assertTrue(whiteBishop.canMove(board, board.getCell(4, 4), board.getCell(5, 5)));
    }
}
