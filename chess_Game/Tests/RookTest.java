package Tests;

import ChessGame.Player;
import ChessGame.boards.Board;
import ChessGame.boards.StandardBoard;
import ChessGame.pieces.Rook;
import org.junit.Assert;
import org.junit.Test;

public class RookTest {
    @Test
    public void testCanMoveValid() throws Exception {

        Rook whiteRook = new Rook(Player.WHITE);
        Rook blackRook = new Rook(Player.BLACK);

        (new RookBehaviorTest()).test(whiteRook, blackRook);
    }

    @Test
    public void testCanMoveInvalid() throws Exception {
        Rook whiteRook = new Rook(Player.WHITE);
        Rook blackRook = new Rook(Player.BLACK);

        Board board = new StandardBoard();

        // Check that moving diagonally is invalid
        Assert.assertFalse(whiteRook.canMove(board, board.getCell(4, 4), board.getCell(3, 3)));

        // Check that moving to the same position is invalid
        Assert.assertFalse(whiteRook.canMove(board, board.getCell(4, 4), board.getCell(4, 4)));

        // Check that moving through another piece is invalid
        board.setCell(4, 4, whiteRook);
        board.setCell(5, 4, blackRook);
        Assert.assertFalse(whiteRook.canMove(board, board.getCell(4, 4), board.getCell(6, 4)));
    }

    @Test
    public void testGetName() throws Exception {
        Assert.assertEquals("Rook", (new Rook(Player.WHITE)).getName());
    }
}
