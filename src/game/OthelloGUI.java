package game;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

public class OthelloGUI extends JFrame {
    private static final int SIZE_OF_ONE_SIDE = 8;
    private static final Border LEGAL = new LineBorder(Color.RED);
    private static final ImageIcon BLACK_DISC = new ImageIcon("src/Othello_black.png"); //credits RodneyShag
    private static final ImageIcon WHITE_DISC = new ImageIcon("src/Othello_white.png"); //credits RodneyShag

    private final OthelloModel model = new OthelloModel();

    private final JLabel[][] fields = new JLabel[SIZE_OF_ONE_SIDE][SIZE_OF_ONE_SIDE];

    private final JLabel p1 = new JLabel("remaining discs Player 1: " + model.getPlayerOne().getDiscs().size());
    private final JLabel p2 = new JLabel("remaining discs Player 2: " + model.getPlayerOne().getDiscs().size());


    public OthelloGUI() {
        setTitle("Othello");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(SIZE_OF_ONE_SIDE, SIZE_OF_ONE_SIDE));

        for (int i = 0; i < SIZE_OF_ONE_SIDE; i++) {
            for(int j = 0; j < SIZE_OF_ONE_SIDE; j++) {
                JLabel field = getjLabel(i, j);
                fields[i][j] = field;
                if ((i == 3 && j == 3) || (i == 4 && j == 4)) {
                    fields[i][j].setIcon(WHITE_DISC);
                    addDiscToPlayerAndModel(i, j);
                } else if ((i == 4 && j == 3) || (i == 3 && j == 4)) {
                    fields[i][j].setIcon(BLACK_DISC);
                    addDiscToPlayerAndModel(i, j);
                }
                panel.add(fields[i][j]);
            }
        }

        add(p1, BorderLayout.NORTH);
        add(panel,BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        legalMoveHighlight();
    }

    public void legalMoveHighlight() {
        for (int i = 0; i < SIZE_OF_ONE_SIDE; i++) {
            for (int j = 0; j < SIZE_OF_ONE_SIDE; j++) {
                if (model.getCurrPlayer().getColor().equalsIgnoreCase("white")) {
                    checkNeighboursAndSetBorder(i, j, WHITE_DISC);
                } else {
                    checkNeighboursAndSetBorder(i, j, BLACK_DISC);
                }
            }
        }
    }

    public void placeDisc(int x, int y) throws IllegalAccessException {
        if(isLegal(x, y)) {
            setBordersBlack();
            addDiscToPlayerAndModel(x, y);

            if (model.getCurrPlayer().getColor().equalsIgnoreCase("white")) {
                fields[x][y].setIcon(WHITE_DISC);
            } else {
                fields[x][y].setIcon(BLACK_DISC);
            }
        } else {
            throw new IllegalAccessException("This move is illegal");
        }
    }

    private void checkNeighboursAndSetBorder(int i, int j, ImageIcon disc) {
        if(fields[i][j].getIcon() != null && fields[i][j].getIcon().equals(disc)) {
            for (int k = -1; k < 2; k++) {
                for (int h = -1; h < 2; h++) {
                    if (isOutOfBounds(i, j, k, h)
                            && checkCrossOnly(k, h)
                                && fields[i + k][j + h].getIcon() == null) {
                        fields[i + k][j + h].setBorder(LEGAL);
                    }
                }
            }
        }
    }

    private JLabel getjLabel(int x, int y) {
        JLabel field = new JLabel("");
        field.setBorder(new LineBorder(Color.BLACK));
        field.addMouseListener(new OthelloController(this, model, x, y));
        return field;
    }

    private void addDiscToPlayerAndModel(int x, int y) {
        Disc disc = new Disc(model.getCurrPlayer().getColor());
        disc.setPosX(x);
        disc.setPosY(y);
        model.getCurrPlayer().placeDisc(disc);

        if(model.getCurrPlayer() == model.getPlayerOne()) {
            p1.setText("remaining discs Player 1: " + model.getCurrPlayer().getDiscs().size());
        } else {
            p2.setText("remaining discs Player 2: " + model.getCurrPlayer().getDiscs().size());
        }

        model.changeGamestate();
    }

    private void setBordersBlack() {
        for (int i = 0; i < SIZE_OF_ONE_SIDE; i++) {
            for (int j = 0; j < SIZE_OF_ONE_SIDE; j++) {
                fields[i][j].setBorder(new LineBorder(Color.BLACK));
            }
        }
    }

    private boolean isOutOfBounds(int i, int j, int x, int y) {
        return ((i + x) >= 0 && (i + x) < SIZE_OF_ONE_SIDE)
                && ((j + y) >= 0 && (j + y) < SIZE_OF_ONE_SIDE);
    }

    private boolean checkCrossOnly(int x, int y) {
        return x + y == 1 || x + y == -1;
    }

    private boolean isLegal(int x, int y) {
        return fields[x][y].getBorder().equals(LEGAL);
    }
}
