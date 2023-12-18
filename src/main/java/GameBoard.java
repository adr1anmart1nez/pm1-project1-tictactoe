import java.util.ArrayList;
import java.util.List;

/**
 * This Class represents the Game Board.
 * The different tiles are represented in an ArrayList of type String.
 */
public class GameBoard {
    private List<String> tiles;

    /**
     * Creates a new game board and labels the tiles with the numbers 1 to 9.
     */
    public GameBoard() {
        tiles = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            tiles.add(String.valueOf(i + 1));
        }
    }

    /**
     * Get the current state of the board in a formatted String.
     *
     * @return A String that holds the current Board.
     */
    public String getCurrentBoard() {
        return tiles.get(0) + " | " + tiles.get(1) + " | " + tiles.get(2)
                + "\n--+---+---\n"
                + tiles.get(3) + " | " + tiles.get(4) + " | " + tiles.get(5)
                + "\n--+---+---\n"
                + tiles.get(6) + " | " + tiles.get(7) + " | " + tiles.get(8);
    }

    public void setTile(int index, String symbol) {
        tiles.set(index, symbol);
    }

    public List<String> getTiles() {
        return tiles;
    }

    /**
     * Check whether there are unoccupied tiles
     *
     * @return True if there are unoccupied tiles, false otherwise
     */
    public boolean hasOpenTiles() {
        for (String tile : tiles) {
            if (!tile.equals("X") && !tile.equals("O")) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check whether the tile at the given index is unoccupied
     *
     * @return True if the tile at the given index is free, false otherwise
     */
    public boolean isTileFree(int index) {
        if (!tiles.get(index).equals("X") && !tiles.get(index).equals("O")) {
            return true;
        }
        return false;
    }
}