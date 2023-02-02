package Tests;

import ChessGame.Player;
import ChessGame.boards.Board;
import ChessGame.boards.StandardBoard;
import ChessGame.pieces.KnightAndQueen;
import org.junit.Assert;
import org.junit.Test;


public class KnightAndQueenTest {
    @Test
    public void testCanMoveValid() throws Exception {

        KnightAndQueen whiteKnightAndQueen = new KnightAndQueen(Player.WHITE);
        KnightAndQueen blackKnightAndQueen = new KnightAndQueen(Player.BLACK);

        (new RookBehaviorTest()).test(whiteKnightAndQueen, blackKnightAndQueen);
        (new BishopBehaviorTest()).test(whiteKnightAndQueen, blackKnightAndQueen);
        (new KnightBehaviorTest()).test(whiteKnightAndQueen, blackKnightAndQueen);
    }

    @Test
    public void testCanMoveInvalid() throws Exception {
        KnightAndQueen whiteKnightAndQueen = new KnightAndQueen(Player.WHITE);
        KnightAndQueen blackKnightAndQueen = new KnightAndQueen(Player.BLACK);

        Board board = new StandardBoard();

        board.setCell(4, 4, whiteKnightAndQueen);

        // Check that moving in neither straight nor diagonal lines is invalid
        Assert.assertFalse(whiteKnightAndQueen.canMove(board, board.getCell(4, 4), board.getCell(7, 6)));

        // Check that moving to the same position is invalid
        Assert.assertFalse(whiteKnightAndQueen.canMove(board, board.getCell(4, 4), board.getCell(4, 4)));

        // Check that moving through another piece is invalid
        board.setCell(5, 5, blackKnightAndQueen);
        Assert.assertFalse(whiteKnightAndQueen.canMove(board, board.getCell(4, 4), board.getCell(6, 6)));
    }

    @Test
    public void testGetName() throws Exception {
        Assert.assertEquals("Banshee", (new KnightAndQueen(Player.WHITE)).getName());
    }
}
