import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class OthelloGUI extends JFrame {
    private static final int SIZE_OF_ONE_SIDE = 8;

    JLabel[][] fields = new JLabel[SIZE_OF_ONE_SIDE][SIZE_OF_ONE_SIDE];

    public OthelloGUI() {
        setTitle("Othello");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(SIZE_OF_ONE_SIDE, SIZE_OF_ONE_SIDE));

        for (int i = 0; i < SIZE_OF_ONE_SIDE; i++) {
            for(int j = 0; j < SIZE_OF_ONE_SIDE; j++) {
                JLabel field = new JLabel("");
                field.setBorder(new LineBorder(Color.BLACK));
                fields[i][j] = field;
                panel.add(fields[i][j]);
            }
        }
    }

    public void changeColor(int x, int y, Icon i) {
        fields[x][y].setIcon(i);
    }

    public String getColor(int x, int y) {
        return fields[x][y].getText();
    }
}
