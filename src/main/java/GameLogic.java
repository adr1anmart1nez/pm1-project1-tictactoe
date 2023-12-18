import java.util.ArrayList;
import java.util.List;

/**
 * Class that handles the logic of the game. This includes creating a new game and
 * checking inputs and winning / invalid moves
 */
public class GameLogic {
    private GameBoard board;
    private GameCommunication communication;

    /**
     * Initialise the fields needed for a new game
     */
    public GameLogic() {
        board = new GameBoard();
        communication = new GameCommunication(board);
    }

    /**
     * This method induces a new game of TicTacToe and all objects needed / associated
     * with it. It is also responsible for continuously printing out the current state
     * of the game and uses different methods to check if the input is valid, which
     * player is currently playing and if someone won / the game ended in a draw.
     */
    public void newGame() {
        communication.printWelcome();
        boolean isGameRunning = true;
        int currentPlayer = 1;
        while (isGameRunning) {
            getAndMakeMove(currentPlayer);
            if (isGameOver(currentPlayer)){
                isGameRunning = false;
            }
            else {
                if (currentPlayer == 1) {
                    currentPlayer = 2;
                } else {
                    currentPlayer = 1;
                }
            }
        }
    }

    /**
     * This method checks if the current player has made a winning move or if all tiles are
     * occupied and the game ended in a draw. If that is the case the method returns true
     * to indicate that the game is over.
     * @param currentPlayer 1 for player X, 2 for player O.
     * @return true if the game is over.
     */
    private boolean isGameOver(int currentPlayer) {
        if (isWinningMove(currentPlayer)) {
            communication.printBoard();
            communication.printWinner(currentPlayer);
            return true;
        }
        else if (!board.hasOpenTiles()) {
            communication.printBoard();
            communication.printDraw();
            return true;
        }
        return false;
    }

    /**
     * Keeps asking the player until their input is correct.
     *
     * @param currentPlayer 1 for player X, 2 for player O
     */
    private void getAndMakeMove(int currentPlayer) {
        int input;
        boolean isValidInput = false;
        communication.printBoard();

        while (!isValidInput) {
            input = communication.askMove(currentPlayer);

            if (input == 0) {
                communication.printChangeLanguage();
            } else if (isValidField(input)) {
                if (!board.isTileFree(input - 1)) {
                    communication.printTileAlreadyOccupiedError();
                } else {
                    makeMove(currentPlayer, input);
                    isValidInput = true;
                }
            } else {
                communication.printOutOfBoardError();
            }
        }
    }

    /**
     * Executes a move and replaces an open field in the board with the players corresponding symbol
     *
     * @param player X is 1 and Player O is 2
     * @param tile   The tile on the game board with a value between 1 and 9
     */
    private void makeMove(int player, int tile) {
        if (player == 1) {
            board.setTile(tile - 1, "X");
        } else {
            board.setTile(tile - 1, "O");
        }
    }

    /**
     * Checks if the players input is within the allowed range of 1 to 9
     *
     * @param tile which is entered by the player (between 1 and 9)
     * @return True if the input is valid, false otherwise.
     */
    private boolean isValidField(int tile) {
        return (tile >= 1 && tile <= 9);
    }

    /**
     * Check whether a player wins with this move by adding ints which correspond
     * with the symbols X and O into an arraylist and checks said list with the
     * help of three methods which check all possible ways of winning.
     *
     * @param player 1 for X, 2 for O
     * @return True if a player wins with this move, false otherwise
     */
    private boolean isWinningMove(int player) {
        List<Integer> tiles = new ArrayList<>();
        for (String s : board.getTiles()) {
            if (s.equals("X")) {
                tiles.add(1);
            } else if (s.equals("O")) {
                tiles.add(2);
            } else {
                tiles.add(0);
            }
        }
        if (checkHorizontal(player, tiles)) return true;
        if (checkVertical(player, tiles)) return true;
        if (checkDiagonals(player, tiles)) return true;
        return false;
    }

    /**
     * Check whether there are three of the same symbol in a diagonal
     *
     * @param player 1 for player X, 0 for player O
     * @param tiles  The current tiles on the game board
     * @return true if there are three equal tiles in a diagonal
     */
    private boolean checkDiagonals(int player, List<Integer> tiles) {
        if (tiles.get(0) == player && tiles.get(4) == player && tiles.get(8) == player) {
            return true;
        }
        if (tiles.get(2) == player && tiles.get(4) == player && tiles.get(6) == player) {
            return true;
        }
        return false;
    }

    /**
     * Check whether there are three of the same symbol vertically
     *
     * @param player 1 for player X, 0 for player O
     * @param tiles  The current tiles on the game board
     * @return true if there are three of the same tiles vertically
     */
    private boolean checkVertical(int player, List<Integer> tiles) {
        for (int i = 0; i < 3; i++) {
            if (tiles.get(i) == player && tiles.get(i + 3) == player && tiles.get(i + 6) == player) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check whether there are three of the same tiles horizontally
     *
     * @param player 1 for player X, 0 for player O
     * @param tiles  The current tiles on the game board
     * @return true if there are three of the same tiles horizontally
     */
    private boolean checkHorizontal(int player, List<Integer> tiles) {
        for (int i = 0; i < 9; i += 3) {
            if (tiles.get(i) == player && tiles.get(i + 1) == player && tiles.get(i + 2) == player) {
                return true;
            }
        }
        return false;
    }
}