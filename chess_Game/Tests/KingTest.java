package Tests;

import ChessGame.Player;
import ChessGame.boards.Board;
import ChessGame.boards.EmptyStandardBoard;
import ChessGame.boards.Location;
import ChessGame.pieces.King;
import org.junit.Assert;
import org.junit.Test;

public class KingTest {
    @Test
    public void testCanMoveValid() throws Exception {
        King fixture = new King(Player.WHITE);

        Board board = new EmptyStandardBoard();
        Location origin = board.getCell(1, 1);

        Assert.assertTrue(fixture.canMove(board, origin, board.getCell(0, 0)));
        Assert.assertTrue(fixture.canMove(board, origin, board.getCell(1, 0)));
        Assert.assertTrue(fixture.canMove(board, origin, board.getCell(2, 0)));
        Assert.assertTrue(fixture.canMove(board, origin, board.getCell(0, 1)));
        Assert.assertTrue(fixture.canMove(board, origin, board.getCell(2, 1)));
        Assert.assertTrue(fixture.canMove(board, origin, board.getCell(0, 2)));
        Assert.assertTrue(fixture.canMove(board, origin, board.getCell(1, 2)));
        Assert.assertTrue(fixture.canMove(board, origin, board.getCell(2, 2)));
    }

    @Test
    public void testCanMoveInvalid() throws Exception {
        King fixture = new King(Player.WHITE);

        Board board = new EmptyStandardBoard();
        Location origin = board.getCell(1, 1);

        // Try going too far away
        Assert.assertFalse(fixture.canMove(board, origin, board.getCell(3, 0)));

        // Try going to the same cell
        Assert.assertFalse(fixture.canMove(board, origin, board.getCell(1, 1)));
    }

    @Test
    public void testGetName() throws Exception {
        Assert.assertEquals("King", (new King(Player.WHITE)).getName());
    }
}
