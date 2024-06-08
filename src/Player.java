import java.util.LinkedList;

public class Player {
    String color;
    LinkedList<Disc> discs = new LinkedList<>();

    public Player(String _color) {
        color = _color;
    }
}
