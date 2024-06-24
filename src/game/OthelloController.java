package game;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class OthelloController implements MouseListener {
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
            try {
                gui.placeDisc(x, y);
            } catch (IllegalAccessException ex) {
                ex.printStackTrace();
            }
        } else {
            try {
                gui.placeDisc(x, y);
            } catch (IllegalAccessException ex) {
                ex.printStackTrace();
            }
        }
        gui.legalMoveHighlight();
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
