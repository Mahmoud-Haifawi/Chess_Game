package ChessGame.gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class BoardListener implements MouseListener {
    private final BoardGUI board;
    private MouseEvent startEvent;

    public BoardListener(BoardGUI board) {
        this.board = board;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (this.startEvent != null) {
            this.board.onDrag(this.startEvent.getPoint(), e.getPoint());
            this.startEvent = null;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.startEvent = e;
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.startEvent = null;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }
}

