package game;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class OthelloController implements MouseListener {
    private static final ImageIcon BLACK = new ImageIcon("src/Othello_black.png"); //credits RodneyShag
    private static final ImageIcon WHITE = new ImageIcon("src/Othello_white.png"); //credits RodneyShag

    private final OthelloGUI gui;
    private final OthelloModel model;
    int x;
    int y;

    public OthelloController(OthelloGUI _gui, OthelloModel _model, int _x, int _y) {
        gui = _gui;
        model = _model;
        x = _x;
        y = _y;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (model.getCurrPlayer().equals(model.getPlayerOne())) {
            gui.getFields(x, y).setIcon(BLACK);
        } else {
            gui.getFields(x, y).setIcon(WHITE);
        }
        model.changeGamestate();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
