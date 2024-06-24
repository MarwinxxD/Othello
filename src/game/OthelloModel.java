package game;

public class OthelloModel {
    Player p1 = new Player("black");
    Player p2 = new Player("white");

    boolean gamestate = true; //true = black, false = white

    boolean gameEnd = false;

    public Player getPlayerOne() {
        return p1;
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
