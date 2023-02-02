package ChessGame.gui;

import ChessGame.Player;
import ChessGame.boards.Board;
import ChessGame.games.ChessGame;
import ChessGame.games.GameListener;

import javax.swing.*;
import java.awt.*;

public class GameGUI extends JPanel {

    private final ChessGame game;
    private final GameListener gameListener;
    private Board board;
    private BoardGUI boardGUI;
    private final JButton surrenderButton;
    private final JButton undoButton;

    public GameGUI(ChessGame game) {
        this.game = game;
        this.gameListener = new GameListener(this);
        this.board = game.getBoard();
        this.boardGUI = new BoardGUI(this, this.game, this.board);
        this.surrenderButton = new JButton("Surrender");
        this.surrenderButton.addActionListener(this.gameListener);
        this.undoButton = new JButton("Undo");
        this.undoButton.addActionListener(this.gameListener);

        this.restoreComponents();
    }

    public void onMove() {
        this.removeAll();
        this.restoreComponents();
        this.revalidate();
        this.repaint();
    }

    public void onSurrender() {
        String player = this.game.getTurn() == Player.WHITE ? "Black" : "White";

        int dialogResult = JOptionPane.showConfirmDialog(this, player + ", do you accept a tie?"
                , "Tie or Forfeit?", JOptionPane.YES_NO_OPTION);

        if (dialogResult == JOptionPane.YES_OPTION) {
            this.game.restart();
        } else {
            this.game.forfeit();
        }

        this.removeAll();

        this.revalidate();
        this.repaint();

        this.board = game.getBoard();
        this.boardGUI = new BoardGUI(this, this.game, this.board);

        this.restoreComponents();

        this.revalidate();
        this.repaint();
    }

    public void onUndo() {
        this.removeAll();

        this.revalidate();
        this.repaint();

        this.game.undo();
        this.board = game.getBoard();
        this.boardGUI = new BoardGUI(this, this.game, this.board);

        this.restoreComponents();

        this.revalidate();
        this.repaint();
    }

    private void restoreComponents() {
        String player = this.game.getTurn() == Player.WHITE ? "White" : "Black";

        this.add(new JLabel("It is " + player + "'s turn", SwingConstants.CENTER), BorderLayout.SOUTH);

        this.add(this.boardGUI);

        this.add(new JLabel("White: " + this.game.getWhiteWinCount(), SwingConstants.CENTER), BorderLayout.WEST);
        this.add(this.surrenderButton, BorderLayout.SOUTH);

        if (this.game.getCanUndo())
            this.add(this.undoButton, BorderLayout.SOUTH);

        this.add(new JLabel("Black: " + this.game.getBlackWinCount(), SwingConstants.CENTER), BorderLayout.EAST);
    }

    public int getWidth() {
        return this.boardGUI.getWidth();
    }

    public int getHeight() {
        return this.boardGUI.getHeight() + 100;
    }
}
