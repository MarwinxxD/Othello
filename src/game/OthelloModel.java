package game;

import java.util.ArrayList;

public class OthelloModel {
    private static final int SIZE_OF_ONE_SIDE = 8;

    Player p1 = new Player("white");
    Player p2 = new Player("black");

    boolean gamestate = true; //true = white, false = black

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

    public void endGame() {
        gameEnd = true;
    }

    public String getGameState() {
        return gamestate ? "white" : "black";
    }
}
