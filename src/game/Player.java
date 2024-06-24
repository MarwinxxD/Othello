package game;

import javax.swing.*;
import java.util.LinkedList;

public class Player {
    private static final int SIZE_OF_ONE_SIDE = 8;

    private final String color;
    private final LinkedList<Disc> discs = new LinkedList<>();
    private final LinkedList<Disc> placedDiscs = new LinkedList<>();

    public Player(String _color) {
        color = _color;

        for (int i = 0; i < (SIZE_OF_ONE_SIDE * SIZE_OF_ONE_SIDE) / 2; i++) {
            discs.add(new Disc(color));
        }
    }

    public void placeDisc(Disc _disc) {
        discs.removeFirst();
        placedDiscs.add(_disc);
    }

    public String getColor() {
        return color;
    }

    public LinkedList<Disc> getDiscs() {
        return discs;
    }

    public LinkedList<Disc> getPlacedDiscs() {
        return placedDiscs;
    }
}
