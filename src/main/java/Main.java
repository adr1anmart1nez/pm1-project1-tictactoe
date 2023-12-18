/**
 * This class is our Main class, which we need to start the game.
 */
public class Main {
    /**
     * This method creates a Gamelogic-object and executes the newGame() method.
     */
    public static void main(String[] args) {
        GameLogic logic = new GameLogic();
        logic.newGame();
    }
}