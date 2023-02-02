package ChessGame.pieces;

import ChessGame.Player;
import ChessGame.boards.Board;
import ChessGame.boards.Location;
import ChessGame.pieces.behaviors.KingBehavior;


public class King extends ChessPiece {

    //  private Behavior behavior;

    public King(Player player) throws InvalidPlayerException {
        super(player);

        this.behavior = new KingBehavior();
    }

    public King(King other) {
        super(other);

        this.behavior = new KingBehavior();
    }

    public String getName() {
        return "King";
    }

    public boolean canMove(Board board, Location origin, Location destination) {
        return this.behavior.canMove(board, origin, destination);
    }

    public ChessPiece copy() {
        return new King(this);
    }

    public char getIconChar() {
        if (this.getPlayer() == Player.WHITE)
            return '\u2654';
        else
            return '\u265A';
    }
}
