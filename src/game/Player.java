package game;

import java.util.LinkedList;

public class Player {
    private static final int SIZE_OF_ONE_SIDE = 8;

    private String color;
    private LinkedList<Disc> discs = new LinkedList<>();
    private LinkedList<Disc> placedDiscs = new LinkedList<>();

    public Player(String _color) {
        color = _color;

        for (int i = 0; i < (SIZE_OF_ONE_SIDE * SIZE_OF_ONE_SIDE) / 2; i++) {
            discs.add(new Disc(color));
        }
    }

    public void placeDisc(Disc _disc) {
        discs.remove(_disc);
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
