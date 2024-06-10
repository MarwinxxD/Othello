package game;

public class OthelloModel {
    private static final int SIZE_OF_ONE_SIDE = 8;

    Disc[] discs = new Disc[SIZE_OF_ONE_SIDE * SIZE_OF_ONE_SIDE];

    Player p1 = new Player("white");
    Player p2 = new Player("black");

    boolean gamestate = false; //true = white, false = black

    boolean gameEnd = false;

    public Player getPlayerOne() {
        return p1;
    }

    public Player getPlayerTwo() {
        return p2;
    }

    public Player getCurrPlayer() {
        if(gamestate) {
            return p1;
        }
        return p2;
    }

    public void changeGamestate() {
        gamestate = !gamestate;
    }
}
