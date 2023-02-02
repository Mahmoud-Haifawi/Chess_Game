package ChessGame.pieces;

import ChessGame.Player;
import ChessGame.boards.Board;
import ChessGame.boards.ChessBoardCellAlreadyCapturedException;
import ChessGame.boards.Location;
import ChessGame.pieces.behaviors.Behavior;


public abstract class ChessPiece {
    public Behavior behavior;
    private boolean isCaptured = false;
    private final Player player;
    private boolean firstMove;

    public ChessPiece(Player player) {
        this.player = player;
        this.firstMove = true;

    }

    public ChessPiece(ChessPiece other) {
        this.player = other.getPlayer();
        this.firstMove = other.isFirstMove();
    }

    public abstract boolean canMove(Board board, Location origin, Location destination);


    public void didMove(Board board, Location origin, Location destination) {
        this.firstMove = false;
    }

    public boolean canCapture(ChessPiece piece) {
        return piece.getPlayer() != this.getPlayer();
    }

    public void setIsCaptured() throws ChessBoardCellAlreadyCapturedException {
        if (this.isCaptured)
            throw new ChessBoardCellAlreadyCapturedException(this);

        this.isCaptured = true;
    }

    public abstract String getName();

    public Player getPlayer() {
        return this.player;
    }

    public boolean isFirstMove() {
        return this.firstMove;
    }

    public String toString() {
        return this.getName();
    }

    public abstract ChessPiece copy();

    public abstract char getIconChar();
}
