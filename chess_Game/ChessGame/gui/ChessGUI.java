package ChessGame.gui;

import ChessGame.games.ChessGame;
import ChessGame.games.StandardChessGame;

import javax.swing.*;


public class ChessGUI {

    public ChessGUI() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            //silently ignore
        }

        JFrame window = new JFrame("Standard Chess Game");
        GameGUI gameGui;

        try {
            ChessGame game = new StandardChessGame();

            gameGui = new GameGUI(game);

            window.setSize(gameGui.getWidth(), gameGui.getHeight());
            window.setResizable(false);

            window.setContentPane(gameGui);

            window.setVisible(true);
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } catch (Exception e) {
            System.err.println(e.getStackTrace());
        }
    }

    public static void main(String[] args) {
        ChessGame chessGame = null;
        try {
            chessGame = new StandardChessGame();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        chessGame.start();
    }
}