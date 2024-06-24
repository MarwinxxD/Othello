package game;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class OthelloGUI extends JFrame {
    private static final int SIZE_OF_ONE_SIDE = 8;
    private static final int AMOUNT_OF_FIELDS = 64;
    private static final ImageIcon BLACK_DISC = new ImageIcon("src/Othello_black.png"); //credits RodneyShag
    private static final ImageIcon WHITE_DISC = new ImageIcon("src/Othello_white.png"); //credits RodneyShag

    private final OthelloModel model = new OthelloModel();

    JLabel[][] fields = new JLabel[SIZE_OF_ONE_SIDE][SIZE_OF_ONE_SIDE];

    public OthelloGUI() {
        setTitle("Othello");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(SIZE_OF_ONE_SIDE, SIZE_OF_ONE_SIDE));

        JTextField p1 = new JTextField("remaining discs Player 1: " + model.getPlayerOne().getDiscs().size());
        JTextField p2 = new JTextField("remaining discs Player 2: " + model.getPlayerOne().getDiscs().size());

        for (int i = 0; i < SIZE_OF_ONE_SIDE; i++) {
            for(int j = 0; j < SIZE_OF_ONE_SIDE; j++) {
                JLabel field = getjLabel(i, j);
                fields[i][j] = field;
                if ((i == 3 && j == 3) || (i == 4 && j == 4)) {
                    fields[i][j].setIcon(WHITE_DISC);
                } else if ((i == 4 && j == 3) || (i == 3 && j == 4)) {
                    fields[i][j].setIcon(BLACK_DISC);
                }
                panel.add(fields[i][j]);
            }
        }

        add(p1, BorderLayout.NORTH);
        add(panel,BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);

        setSize(700, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        legalMoveHighlight();
    }

    public void legalMoveHighlight() {
        for (int i = 0; i < SIZE_OF_ONE_SIDE; i++) {
            for (int j = 0; j < SIZE_OF_ONE_SIDE; j++) {
                if (model.getCurrPlayer().getImage().equals(BLACK_DISC)) {
                    checkNeighboursAndSetBorder(i, j, WHITE_DISC);
                } else {
                    checkNeighboursAndSetBorder(i, j, BLACK_DISC);
                }
            }
        }
    }

    public void setIconWhite(int x, int y) {
        fields[x][y].setIcon(WHITE_DISC);
    }

    public void setIconBlack(int x, int y) {
        fields[x][y].setIcon(BLACK_DISC);
    }

    private JLabel getjLabel(int x, int y) {
        JLabel field = new JLabel("");
        field.setBorder(new LineBorder(Color.BLACK));
        field.addMouseListener(new OthelloController(this, model, x, y));
        return field;
    }

    private void checkNeighboursAndSetBorder(int i, int j, ImageIcon disc) {
        if(fields[i][j].getIcon() != null && !fields[i][j].getIcon().equals(disc)) {
            for (int k = -1; k < 2; k++) {
                for (int h = -1; h < 2; h++) {
                    if (fields[i + k][j + h].getIcon() == null
                            && ((i + k) >= 0 && (i + k) <= SIZE_OF_ONE_SIDE)
                            && ((j + h) >= 0 && (j + h) <= SIZE_OF_ONE_SIDE)) {
                        fields[i + k][j + h].setBorder(new LineBorder(Color.RED));
                    }
                }
            }
        }
    }

}
