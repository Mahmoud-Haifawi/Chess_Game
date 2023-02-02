package ChessGame.pieces;

import ChessGame.Player;
import ChessGame.boards.Board;
import ChessGame.boards.Location;
import ChessGame.pieces.behaviors.Behavior;
import ChessGame.pieces.behaviors.RookBehavior;

public class Rook extends ChessPiece {

    private final Behavior behavior;

    public Rook(Player player) throws InvalidPlayerException {
        super(player);

        this.behavior = new RookBehavior();
    }

    public Rook(Rook other) {
        super(other);

        this.behavior = new RookBehavior();
    }

    public String getName() {
        return "Rook";
    }

    public boolean canMove(Board board, Location origin, Location destination) {
        return this.behavior.canMove(board, origin, destination);
    }

    public ChessPiece copy() {
        return new Rook(this);
    }

    public char getIconChar() {
        if (this.getPlayer() == Player.WHITE)
            return '\u2656';
        else
            return '\u265C';
    }
}
