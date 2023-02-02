package ChessGame.boards;

import ChessGame.pieces.ChessPiece;

import java.awt.*;


public class Location {
    // x and y coordinates are immutable properties declared upon initialization
    private final int x;
    private final int y;
    private final boolean isValid;

    private ChessPiece piece;

    public Location(int x, int y, boolean isValid) {
        this(x, y, isValid, null);
    }

    public Location(int x, int y, boolean isValid, ChessPiece piece) {
        this.x = x;
        this.y = y;
        this.isValid = isValid;
        this.piece = piece;
    }


    public boolean isOccupied() {
        return this.piece != null;
    }


    public boolean isValid() {
        return this.isValid;
    }


    public ChessPiece getPiece() {
        return this.piece;
    }


    public void setPiece(ChessPiece piece)
            throws ChessBoardCellAlreadyCapturedException
            , ChessBoardCellAlreadyOccupiedException {

        if (this.piece != null && piece != null) {
            // Don't allow capture by the same player
            if (piece != null && this.piece.getPlayer() == piece.getPlayer())
                throw new ChessBoardCellAlreadyOccupiedException(this.piece);

            this.piece.setIsCaptured();
        }

        this.piece = piece;
    }


    public int getX() {
        return this.x;
    }


    public int getY() {
        return this.y;
    }

    public String toString() {
        return "(" + this.getX() + "," + this.getY() + ")";
    }

    public void paintComponent(Graphics2D g, int cellWidth, boolean isChecked) {
        int leftEdge = this.getX() * cellWidth;
        int topEdge = this.getY() * cellWidth;

        if ((this.getX() + this.getY()) % 2 == 0)
            g.setColor(Color.WHITE);
        else
            g.setColor(Color.GRAY);

        g.fillRect(leftEdge, topEdge, cellWidth, cellWidth);


        g.setColor(Color.BLACK);

        if (this.isOccupied())
            g.drawChars(new char[]{this.getPiece().getIconChar()}, 0, 1, leftEdge, topEdge + cellWidth - 10);


        if (isChecked) {
            Stroke oldStroke = g.getStroke();
            int strokeWidth = 4;
            g.setStroke(new BasicStroke(strokeWidth));
            g.setColor(Color.RED);
            g.drawRect(leftEdge + strokeWidth / 2 - 1, topEdge + strokeWidth / 2 - 1
                    , cellWidth - strokeWidth + 1, cellWidth - strokeWidth + 1);
            g.setStroke(oldStroke);
        }
    }
}
