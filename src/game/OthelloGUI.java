package game;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class OthelloGUI extends JFrame {
    private static final int SIZE_OF_ONE_SIDE = 8;
    private static final ImageIcon BLACK = new ImageIcon("src/Othello_black.png"); //credits RodneyShag
    private static final ImageIcon WHITE = new ImageIcon("src/Othello_white.png"); //credits RodneyShag

    private OthelloModel model = new OthelloModel();

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
                    fields[i][j].setIcon(WHITE);
                } else if ((i == 4 && j == 3) || (i == 3 && j == 4)) {
                    fields[i][j].setIcon(BLACK);
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
    }

    private JLabel getjLabel(int x, int y) {
        JLabel field = new JLabel("");
        field.setBorder(new LineBorder(Color.BLACK));
        field.addMouseListener(new OthelloController(this, model, x, y));
        return field;
    }

    public JLabel getFields(int x, int y) {
        return fields[x][y];
    }

    public void setIconWhite(int x, int y) {
        fields[x][y].setIcon(WHITE);
    }

    public void setIconBlack(int x, int y) {
        fields[x][y].setIcon(BLACK);
    }

}
