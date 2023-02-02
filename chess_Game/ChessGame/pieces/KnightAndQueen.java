package ChessGame.pieces;

import ChessGame.Player;
import ChessGame.boards.Board;
import ChessGame.boards.Location;
import ChessGame.pieces.behaviors.Behavior;
import ChessGame.pieces.behaviors.KnightBehavior;
import ChessGame.pieces.behaviors.QueenBehavior;


public class KnightAndQueen extends ChessPiece {

    private final Behavior knightBehavior;
    private final Behavior queenBehavior;

    public KnightAndQueen(Player player) throws InvalidPlayerException {
        super(player);

        this.queenBehavior = new QueenBehavior();
        this.knightBehavior = new KnightBehavior();
    }

    public KnightAndQueen(KnightAndQueen other) {
        super(other);

        this.queenBehavior = new QueenBehavior();
        this.knightBehavior = new KnightBehavior();
    }

    public String getName() {
        return "Banshee";
    }

    public boolean canMove(Board board, Location origin, Location destination) {
        return this.queenBehavior.canMove(board, origin, destination) ||
                this.knightBehavior.canMove(board, origin, destination);
    }

    public ChessPiece copy() {
        return new KnightAndQueen(this);
    }

    public char getIconChar() {
        if (this.getPlayer() == Player.WHITE) return 'B';
        else
            return 'b';
    }
}
