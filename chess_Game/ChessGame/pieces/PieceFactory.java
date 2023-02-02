package ChessGame.pieces;

import ChessGame.Player;

public class PieceFactory {
    public ChessPiece pieceFactory(PieceType pieceType, Player player) throws InvalidPlayerException {
        if (pieceType == PieceType.Bishop)
            return new Bishop(player);
        else if (pieceType == PieceType.King)
            return new King(player);
        else if (pieceType == PieceType.Knight)
            return new Knight(player);
        else if (pieceType == PieceType.Pawn)
            return new Pawn(player);
        else if (pieceType == PieceType.Queen)
            return new Queen(player);
        else if (pieceType == PieceType.Rook)
            return new Rook(player);
        return null;
    }
}
