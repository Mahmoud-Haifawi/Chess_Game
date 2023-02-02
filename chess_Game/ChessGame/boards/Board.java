package ChessGame.boards;

import ChessGame.Player;
import ChessGame.pieces.ChessPiece;
import ChessGame.pieces.King;

import javax.swing.*;


public abstract class Board {
    protected Location[][] cells;
    protected JPanel panel;
    private King whiteKing;
    private King blackKing;

    public Board() throws Exception {
        this.cells = this.getBoard();
        this.whiteKing = new King(Player.WHITE);
        this.blackKing = new King(Player.BLACK);
    }

    public Board(Board other)
            throws ChessBoardOutOfBoundsException
            , ChessBoardCellNotOccupiedException
            , ChessBoardCellAlreadyCapturedException
            , ChessBoardCellAlreadyOccupiedException {

        int width = other.getWidth();
        int height = other.getHeight();

        this.cells = other.getBoard();

        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < height; ++j) {
                if (other.getCell(i, j).isOccupied()) {
                    ChessPiece temp = other.getCell(i, j).getPiece();

                    if (temp == other.getWhiteKing()) {
                        this.whiteKing = (King) temp;
                    } else if (temp == other.getBlackKing()) {
                        this.blackKing = (King) temp;
                    }

                    this.setCell(i, j, temp);

                }
            }
        }
    }

    abstract Location[][] getBoard();


    public Location getCell(int x, int y) throws ChessBoardOutOfBoundsException {
        for (int i = 0, ii = this.cells.length; i < ii; ++i) {
            for (int j = 0, jj = this.cells[i].length; j < jj; ++j) {
                if (x == i && y == j && this.cells[i][j].isValid()) {
                    return this.cells[i][j];
                }
            }
        }

        throw new ChessBoardOutOfBoundsException(x, y);
    }


    public void setCell(int x, int y, ChessPiece piece)
            throws ChessBoardOutOfBoundsException
            , ChessBoardCellAlreadyCapturedException
            , ChessBoardCellAlreadyOccupiedException {

        for (int i = 0, ii = this.cells.length; i < ii; ++i) {
            for (int j = 0, jj = this.cells[i].length; j < jj; ++j) {
                if (x == i && y == j && this.cells[i][j].isValid()) {
                    this.cells[i][j].setPiece(piece);
                    return;
                }
            }
        }

        throw new ChessBoardOutOfBoundsException(x, y);
    }


    public King getWhiteKing() {
        return this.whiteKing;
    }

    public King getBlackKing() {
        return this.blackKing;
    }

    public Location find(ChessPiece piece) throws ChessBoardInvalidException {
        try {
            for (int i = 0, ii = this.cells.length; i < ii; ++i) {
                for (int j = 0, jj = this.cells[i].length; j < jj; ++j) {
                    if (this.cells[i][j].isValid() &&
                            this.cells[i][j].isOccupied() &&
                            this.cells[i][j].getPiece() == piece)
                        return this.cells[i][j];
                }
            }
        } catch (Exception e) {
            throw new ChessBoardInvalidException("A cell said it was occupied, but getPiece failed");
        }

        return null;
    }

    public boolean isWhiteChecked() throws ChessBoardInvalidException {
        Location whiteKingPosition = this.find(this.getWhiteKing());

        return isCellThreatened(whiteKingPosition);
    }

    public boolean isBlackChecked() throws ChessBoardInvalidException {
        Location blackKingPosition = this.find(this.getBlackKing());

        return isCellThreatened(blackKingPosition);
    }

    public boolean isCellThreatened(Location cell) throws ChessBoardInvalidException {
        for (int i = 0, ii = this.cells.length; i < ii; ++i) {
            for (int j = 0, jj = this.cells[i].length; j < jj; ++j) {
                if (this.cells[i][j].isValid() &&
                        this.cells[i][j].isOccupied() &&
                        this.cells[i][j].getPiece().canMove(this, this.cells[i][j], cell)
                ) {
                    return true;
                }
            }
        }

        return false;
    }

    public int getWidth() {
        return this.cells.length;
    }

    public int getHeight() {
        return this.cells[0].length;
    }

    public int getCellWidth() {
        return 20;
    }

    public abstract Board copy() throws ChessBoardInvalidException;
}
