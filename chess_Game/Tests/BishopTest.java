package Tests;

import ChessGame.Player;
import ChessGame.boards.Board;
import ChessGame.boards.EmptyStandardBoard;
import ChessGame.pieces.Bishop;
import org.junit.Assert;
import org.junit.Test;


public class BishopTest {
    @Test
    public void testCanMoveValid() throws Exception {

        Bishop whiteBishop = new Bishop(Player.WHITE);
        Bishop blackBishop = new Bishop(Player.BLACK);

        (new BishopBehaviorTest()).test(whiteBishop, blackBishop);
    }

    @Test
    public void testCanMoveInvalid() throws Exception {
        Bishop whiteBishop = new Bishop(Player.WHITE);
        Bishop blackBishop = new Bishop(Player.BLACK);

        Board board = new EmptyStandardBoard();

        // Check that moving in straight lines is invalid
        Assert.assertFalse(whiteBishop.canMove(board, board.getCell(4, 4), board.getCell(4, 5)));

        // Check that moving to the same position is invalid
        Assert.assertFalse(whiteBishop.canMove(board, board.getCell(4, 4), board.getCell(4, 4)));

        // Check that moving through another piece is invalid
        board.setCell(4, 4, whiteBishop);
        board.setCell(5, 5, blackBishop);
        Assert.assertFalse(whiteBishop.canMove(board, board.getCell(4, 4), board.getCell(6, 6)));
    }

    @Test
    public void testGetName() throws Exception {
        Assert.assertEquals("Bishop", (new Bishop(Player.WHITE)).getName());
    }
}
