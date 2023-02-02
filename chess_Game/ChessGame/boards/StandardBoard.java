package ChessGame.boards;

import ChessGame.Player;
import ChessGame.pieces.PieceFactory;
import ChessGame.pieces.PieceType;


public class StandardBoard extends EmptyStandardBoard {

    public StandardBoard() throws Exception {
        super();

        PieceFactory pieceFactory = new PieceFactory();
        this.setCell(0, 0, pieceFactory.pieceFactory(PieceType.Rook, Player.WHITE));
        this.setCell(1, 0, pieceFactory.pieceFactory(PieceType.Knight, Player.WHITE));
        this.setCell(2, 0, pieceFactory.pieceFactory(PieceType.Bishop, Player.WHITE));
        this.setCell(3, 0, this.getWhiteKing());
        this.setCell(4, 0, pieceFactory.pieceFactory(PieceType.Queen, Player.WHITE));
        this.setCell(5, 0, pieceFactory.pieceFactory(PieceType.Bishop, Player.WHITE));
        this.setCell(6, 0, pieceFactory.pieceFactory(PieceType.Knight, Player.WHITE));
        this.setCell(7, 0, pieceFactory.pieceFactory(PieceType.Rook, Player.WHITE));
        this.setCell(0, 1, pieceFactory.pieceFactory(PieceType.Pawn, Player.WHITE));
        this.setCell(1, 1, pieceFactory.pieceFactory(PieceType.Pawn, Player.WHITE));
        this.setCell(2, 1, pieceFactory.pieceFactory(PieceType.Pawn, Player.WHITE));
        this.setCell(3, 1, pieceFactory.pieceFactory(PieceType.Pawn, Player.WHITE));
        this.setCell(4, 1, pieceFactory.pieceFactory(PieceType.Pawn, Player.WHITE));
        this.setCell(5, 1, pieceFactory.pieceFactory(PieceType.Pawn, Player.WHITE));
        this.setCell(6, 1, pieceFactory.pieceFactory(PieceType.Pawn, Player.WHITE));
        this.setCell(7, 1, pieceFactory.pieceFactory(PieceType.Pawn, Player.WHITE));


        this.setCell(0, 6, pieceFactory.pieceFactory(PieceType.Pawn, Player.BLACK));
        this.setCell(1, 6, pieceFactory.pieceFactory(PieceType.Pawn, Player.BLACK));
        this.setCell(2, 6, pieceFactory.pieceFactory(PieceType.Pawn, Player.BLACK));
        this.setCell(3, 6, pieceFactory.pieceFactory(PieceType.Pawn, Player.BLACK));
        this.setCell(4, 6, pieceFactory.pieceFactory(PieceType.Pawn, Player.BLACK));
        this.setCell(5, 6, pieceFactory.pieceFactory(PieceType.Pawn, Player.BLACK));
        this.setCell(6, 6, pieceFactory.pieceFactory(PieceType.Pawn, Player.BLACK));
        this.setCell(7, 6, pieceFactory.pieceFactory(PieceType.Pawn, Player.BLACK));

        this.setCell(0, 7, pieceFactory.pieceFactory(PieceType.Rook, Player.BLACK));


        this.setCell(1, 7, pieceFactory.pieceFactory(PieceType.Knight, Player.BLACK));


        this.setCell(2, 7, pieceFactory.pieceFactory(PieceType.Bishop, Player.BLACK));
        this.setCell(3, 7, this.getBlackKing());

        this.setCell(4, 7, pieceFactory.pieceFactory(PieceType.Queen, Player.BLACK));

        this.setCell(5, 7, pieceFactory.pieceFactory(PieceType.Bishop, Player.BLACK));

        this.setCell(6, 7, pieceFactory.pieceFactory(PieceType.Knight, Player.BLACK));

        this.setCell(7, 7, pieceFactory.pieceFactory(PieceType.Rook, Player.BLACK));
    }


}
