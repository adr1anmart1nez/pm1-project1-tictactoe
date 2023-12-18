import java.util.Scanner;

/**
 * This class is responsible for the communication with the players and prints all the necessary statements and
 * gets the inputs from the players.
 */
public class GameCommunication {
    private GameBoard board;
    private LanguageSettings languageText;
    private Scanner scanner;

    public GameCommunication(GameBoard board) {
        this.board = board;
        languageText = new LanguageSettings();
        scanner = new Scanner(System.in);
    }

    /**
     * This method prints the welcome text
     */
    public void printWelcome() {
        System.out.println(languageText.welcomeText());
    }

    /**
     * This method prints the text to change the language and confirms the resulting language.
     */
    public void printChangeLanguage() {
        System.out.println(languageText.askChangeLanguageText());
        String input = scanner.next();
        if (languageText.hasChangedLanguage(input)) {
            System.out.println(languageText.languageChangeSuccessfulText());
        } else {
            System.out.println(languageText.languageRemainsTheSame());
        }
    }

    /**
     * This method asks the player to play his next move and returns the number of the chosen tile.
     *
     * @param player holds an int 1 or 2 which represents the current player.
     * @return The number of the tile, where the player would like to place his next move
     */
    public int askMove(int player) {
        System.out.println("Player-" + convertPlayer(player) + languageText.askMoveText());

        if (!scanner.hasNextInt()) {
            scanner.next();
            return -1;
        }
        return scanner.nextInt();
    }

    /**
     * Prints an error message saying the tile is not a board tile
     */
    public void printOutOfBoardError() {
        System.out.println(languageText.invalidFieldText());
    }

    /**
     * Prints an error message saying the tile is already occupied.
     */
    public void printTileAlreadyOccupiedError() {
        System.out.println(languageText.fieldAlreadyOccupiedText());
    }

    /**
     * This Method prints the winning message.
     *
     * @param player holds an int 1 or 2 which represents the current player.
     */
    public void printWinner(int player) {
        System.out.println("Player-" + convertPlayer(player) + languageText.resultWinText());
    }

    /**
     * This Method prints the draw message
     */
    public void printDraw() {
        System.out.println(languageText.resultEqualText());
    }

    /**
     * This method prints the current state of the game board.
     */
    public void printBoard() {
        System.out.println(board.getCurrentBoard());
    }

    /**
     * This Method converts the int representing the player into its String symbol
     *
     * @param player holds an int 1 or 2 which represents the current player.
     * @return a String representing the players symbol.
     */
    private String convertPlayer(int player) {
        if (player == 1) {
            return "X";
        } else {
            return "O";
        }
    }
}