package Tests;

import ChessGame.Player;
import ChessGame.boards.Board;
import ChessGame.boards.StandardBoard;
import ChessGame.pieces.Queen;
import org.junit.Assert;
import org.junit.Test;


public class QueenTest {
    @Test
    public void testCanMoveValid() throws Exception {

        Queen whiteQueen = new Queen(Player.WHITE);
        Queen blackQueen = new Queen(Player.BLACK);

        (new RookBehaviorTest()).test(whiteQueen, blackQueen);
        (new BishopBehaviorTest()).test(whiteQueen, blackQueen);
    }

    @Test
    public void testCanMoveInvalid() throws Exception {
        Queen whiteQueen = new Queen(Player.WHITE);
        Queen blackQueen = new Queen(Player.BLACK);

        Board board = new StandardBoard();

        // Check that moving in neither straight nor diagonal lines is invalid
        Assert.assertFalse(whiteQueen.canMove(board, board.getCell(4, 4), board.getCell(5, 6)));

        // Check that moving to the same position is invalid
        Assert.assertFalse(whiteQueen.canMove(board, board.getCell(4, 4), board.getCell(4, 4)));

        // Check that moving through another piece is invalid
        board.setCell(4, 4, whiteQueen);
        board.setCell(5, 5, blackQueen);
        Assert.assertFalse(whiteQueen.canMove(board, board.getCell(4, 4), board.getCell(6, 6)));
    }

    @Test
    public void testGetName() throws Exception {
        Assert.assertEquals("Queen", (new Queen(Player.WHITE)).getName());
    }
}
