package Tests;

import ChessGame.Player;
import ChessGame.boards.Board;
import ChessGame.boards.EmptyStandardBoard;
import ChessGame.pieces.Pawn;
import org.junit.Assert;
import org.junit.Test;

public class PawnTest {
    @Test
    public void testCanMoveValid() throws Exception {
        Pawn whitePawn = new Pawn(Player.WHITE);
        Pawn blackPawn = new Pawn(Player.BLACK);

        Board board = new EmptyStandardBoard();

        // Check that a white pawn can move forward two cells on its first move
        Assert.assertTrue(whitePawn.canMove(board, board.getCell(0, 1), board.getCell(0, 3)));

        // Check that a white pawn can move forward one cell on its first move
        Assert.assertTrue(whitePawn.canMove(board, board.getCell(0, 1), board.getCell(0, 2)));

        // Check that a black pawn can move forward two cells on its first move
        Assert.assertTrue(blackPawn.canMove(board, board.getCell(0, 6), board.getCell(0, 4)));

        // Check that a black pawn can move forward one cell on its first move
        Assert.assertTrue(blackPawn.canMove(board, board.getCell(0, 6), board.getCell(0, 5)));

        // Check that a white pawn can move diagonally to capture a black piece
        board.setCell(0, 1, whitePawn);
        board.setCell(1, 2, blackPawn);
        Assert.assertTrue(whitePawn.canMove(board, board.getCell(0, 1), board.getCell(1, 2)));
        board.setCell(0, 1, null);
        board.setCell(1, 2, null);
    }

    @Test
    public void testCanMoveInvalid() throws Exception {
        Pawn whitePawn = new Pawn(Player.WHITE);
        Pawn blackPawn = new Pawn(Player.BLACK);

        Board board = new EmptyStandardBoard();

        // Check that a white pawn cannot forward two cells on after its first move
        whitePawn.didMove(board, board.getCell(0, 1), board.getCell(0, 2));
        Assert.assertFalse(whitePawn.canMove(board, board.getCell(0, 1), board.getCell(0, 3)));

        // Check that a white pawn cannot move backwards
        Assert.assertFalse(whitePawn.canMove(board, board.getCell(0, 1), board.getCell(0, 0)));

        // Check that a black pawn cannot forward two cells on after its first move
        blackPawn.didMove(board, board.getCell(0, 6), board.getCell(0, 5));
        Assert.assertFalse(blackPawn.canMove(board, board.getCell(0, 6), board.getCell(0, 4)));

        // Check that a black pawn cannot move backwards
        Assert.assertFalse(blackPawn.canMove(board, board.getCell(0, 6), board.getCell(0, 7)));

        // Check that a pawn cannot move three cells
        Assert.assertFalse(whitePawn.canMove(board, board.getCell(0, 1), board.getCell(0, 4)));
    }

    @Test
    public void testGetName() throws Exception {
        Assert.assertEquals("Pawn", (new Pawn(Player.WHITE)).getName());
    }

}
