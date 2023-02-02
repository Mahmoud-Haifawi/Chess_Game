package ChessGame.pieces;

import ChessGame.Player;
import ChessGame.boards.Board;
import ChessGame.boards.Location;
import ChessGame.pieces.behaviors.Behavior;
import ChessGame.pieces.behaviors.QueenBehavior;

public class Queen extends ChessPiece {

    private final Behavior behavior;

    public Queen(Player player) throws InvalidPlayerException {
        super(player);

        this.behavior = new QueenBehavior();
    }

    public Queen(Queen other) {
        super(other);

        this.behavior = new QueenBehavior();
    }

    public String getName() {
        return "Queen";
    }

    public boolean canMove(Board board, Location origin, Location destination) {
        return this.behavior.canMove(board, origin, destination);
    }

    public ChessPiece copy() {
        return new Queen(this);
    }

    public char getIconChar() {
        if (this.getPlayer() == Player.WHITE)
            return '\u2655';
        else
            return '\u265B';
    }
}
