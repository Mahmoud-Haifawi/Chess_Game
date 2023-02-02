package Tests;

import ChessGame.Player;
import ChessGame.boards.Board;
import ChessGame.boards.EmptyStandardBoard;
import ChessGame.pieces.Knight;
import org.junit.Assert;
import org.junit.Test;

public class KnightTest {
    @Test
    public void testCanMoveValid() throws Exception {

        Knight whiteKnight = new Knight(Player.WHITE);
        Knight blackKnight = new Knight(Player.BLACK);

        (new KnightBehaviorTest()).test(whiteKnight, blackKnight);
    }

    @Test
    public void testCanMoveInvalid() throws Exception {
        Knight whiteKnight = new Knight(Player.WHITE);
        Knight anotherWhiteKnight = new Knight(Player.WHITE);

        Board board = new EmptyStandardBoard();

        // Check that a white knight cannot move in lines
        Assert.assertFalse(whiteKnight.canMove(board, board.getCell(1, 1), board.getCell(0, 0)));
        Assert.assertFalse(whiteKnight.canMove(board, board.getCell(1, 1), board.getCell(0, 1)));
        Assert.assertFalse(whiteKnight.canMove(board, board.getCell(1, 1), board.getCell(1, 0)));

        // Check that a white knight must move
        Assert.assertFalse(whiteKnight.canMove(board, board.getCell(1, 1), board.getCell(1, 1)));

        // Check that a white knight cannot attack an allied knight
        board.setCell(1, 1, whiteKnight);
        board.setCell(3, 2, anotherWhiteKnight);
        Assert.assertFalse(whiteKnight.canMove(board, board.getCell(1, 1), board.getCell(3, 2)));
    }

    @Test
    public void testGetName() throws Exception {
        Assert.assertEquals("Knight", (new Knight(Player.WHITE)).getName());
    }
}
