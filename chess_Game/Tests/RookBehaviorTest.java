package Tests;

import ChessGame.boards.Board;
import ChessGame.boards.EmptyStandardBoard;
import ChessGame.pieces.ChessPiece;
import org.jetbrains.annotations.NotNull;
import org.junit.Assert;


public class RookBehaviorTest implements BehaviorTest {
    public void test(@NotNull ChessPiece whiteRook, ChessPiece blackRook) throws Exception {
        Board board = new EmptyStandardBoard();

        // Check that moving up to edge is valid
        Assert.assertTrue(whiteRook.canMove(board, board.getCell(4, 4), board.getCell(4, 0)));

        // Check that moving down to edge is valid
        Assert.assertTrue(whiteRook.canMove(board, board.getCell(4, 4), board.getCell(4, 7)));

        // Check that moving left to edge is valid
        Assert.assertTrue(whiteRook.canMove(board, board.getCell(4, 4), board.getCell(0, 4)));

        // Check that moving right to edge is valid
        Assert.assertTrue(whiteRook.canMove(board, board.getCell(4, 4), board.getCell(7, 4)));

        // Check that moving up by one is valid
        Assert.assertTrue(whiteRook.canMove(board, board.getCell(4, 4), board.getCell(4, 3)));

        // Check that moving down by one is valid
        Assert.assertTrue(whiteRook.canMove(board, board.getCell(4, 4), board.getCell(4, 5)));

        // Check that moving left by one is valid
        Assert.assertTrue(whiteRook.canMove(board, board.getCell(4, 4), board.getCell(3, 4)));

        // Check that moving right by one is valid
        Assert.assertTrue(whiteRook.canMove(board, board.getCell(4, 4), board.getCell(5, 4)));

        // Check that capturing an adjacent piece is valid
        board.setCell(4, 4, whiteRook);
        board.setCell(5, 4, blackRook);
        Assert.assertTrue(whiteRook.canMove(board, board.getCell(4, 4), board.getCell(5, 4)));
    }
}
