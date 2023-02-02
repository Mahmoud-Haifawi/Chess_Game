package ChessGame.pieces;

import ChessGame.Player;
import ChessGame.boards.Board;
import ChessGame.boards.Location;
import ChessGame.pieces.behaviors.Behavior;
import ChessGame.pieces.behaviors.KnightBehavior;

public class Knight extends ChessPiece {

    Behavior behavior;

    public Knight(Player player) throws InvalidPlayerException {
        super(player);

        this.behavior = new KnightBehavior();
    }

    public Knight(Knight other) {
        super(other);
    }

    public String getName() {
        return "Knight";
    }

    public boolean canMove(Board board, Location origin, Location destination) {
        return this.behavior.canMove(board, origin, destination);
    }

    public ChessPiece copy() {
        return new Knight(this);
    }

    public char getIconChar() {
        if (this.getPlayer() == Player.WHITE)
            return '\u2658';
        else
            return '\u265E';
    }
}
