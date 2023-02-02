package ChessGame.games;

import ChessGame.gui.GameGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GameListener implements ActionListener {

    private final GameGUI gameGUI;

    public GameListener(GameGUI game) {
        this.gameGUI = game;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String action = actionEvent.getActionCommand();

        if (action.equals("Surrender"))
            this.gameGUI.onSurrender();
        else if (action.equals("Undo"))
            this.gameGUI.onUndo();
    }
}
