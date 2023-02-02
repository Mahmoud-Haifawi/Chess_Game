package ChessGame.pieces;

import ChessGame.Player;
import ChessGame.boards.Board;
import ChessGame.boards.Location;
import ChessGame.pieces.behaviors.Behavior;
import ChessGame.pieces.behaviors.BishopBehavior;


public class Bishop extends ChessPiece {

    private final Behavior behavior;

    public Bishop(Player player) throws InvalidPlayerException {
        super(player);

        this.behavior = new BishopBehavior();
    }

    public Bishop(Bishop other) {
        super(other);

        this.behavior = new BishopBehavior();
    }

    public String getName() {
        return "Bishop";
    }

    public boolean canMove(Board board, Location origin, Location destination) {
        return this.behavior.canMove(board, origin, destination);
    }

    public ChessPiece copy() {
        return new Bishop(this);
    }

    public char getIconChar() {
        if (this.getPlayer() == Player.WHITE)
            return '\u2657';
        else
            return '\u265D';
    }
}
