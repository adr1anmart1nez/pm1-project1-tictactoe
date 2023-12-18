import java.util.List;

/**
 * This class implements two language arrays, one array with every text needed in english
 * and an equivalent one with all the translations to spanish.
 * A third array holds the language array of the currently used communication language.
 * The default language is english.
 */
public class LanguageSettings {
    private int indexTextWelcome = 0;
    private int indexTextChangeLanguage = 1;
    private int indexTextChangeLanguageSuccess = 2;
    private int indexTextMove = 3;
    private int indexTextWin = 4;
    private int indexTextEven = 5;
    private int indexTextInvalidField = 6;
    private int indexTextFieldOccupied = 7;
    private int indexTextKeepLanguage = 8;
    private List<String> englishTexts;
    private List<String> spanishTexts;
    private List<String> currentTexts;

    public LanguageSettings() {
        englishTexts = List.of(
                "Welcome to a new game of Tic-Tac-Toe. :-) To change the language, press 0.",
                "Do you want to switch the language to Spanish? If yes, please write 'yes'.",
                "The language has been changed to English.",
                ": It's your turn. Please select a field by writing the according number.",
                ": You won the game.",
                "It's a draw!",
                "This is not a valid field.",
                "This field is already occupied.",
                "The language has not been changed and is still English.");
        spanishTexts = List.of(
                "Bienvenido al partido de Tres en linéa. :-) Para cambiar el idioma, pulsa 0.",
                "Quieres cambiar el idioma a inglés? Escribe 'si' para cambiar el idioma.",
                "El idioma se ha cambiado a español.",
                ": Te toca, por favor escribe un número de campo.",
                ": Ganaste",
                "Es un empate!",
                "Tu número no es válido.",
                "Este campo ya está ocupado.",
                "El idioma no se ha cambiado.");
        currentTexts = englishTexts;
    }

    /**
     * This method initializes the language and overwrite the current array
     *
     * @param languageChange is the input from the current player
     */
    public boolean hasChangedLanguage(String languageChange) {
        if (languageChange.equals("si") && currentTexts.equals(spanishTexts)) {
            currentTexts = englishTexts;
            return true;
        } else if (languageChange.equals("yes") && currentTexts.equals(englishTexts)) {
            currentTexts = spanishTexts;
            return true;
        }
        return false;
    }

    /**
     * This method returns the TextWelcome
     *
     * @return TextWelcome is the text in the right language
     */
    public String welcomeText() {
        return currentTexts.get(indexTextWelcome);
    }

    /**
     * This method returns the TextChangeLanguage
     *
     * @return TextChangeLanguage is the text in the right language
     */
    public String askChangeLanguageText() {
        return currentTexts.get(indexTextChangeLanguage);
    }

    /**
     * This method returns the TextChangeLanguageSuccess
     *
     * @return TextChangeLanguageSuccess is the text in the right language
     */
    public String languageChangeSuccessfulText() {
        return currentTexts.get(indexTextChangeLanguageSuccess);
    }

    /**
     * This method returns the TextMove
     *
     * @return TextMove is the text in the right language
     */
    public String askMoveText() {
        return currentTexts.get(indexTextMove);
    }

    /**
     * This method returns with player won the game
     *
     * @return TextWin is the text in the right language
     */
    public String resultWinText() {
        return currentTexts.get(indexTextWin);
    }

    /**
     * This method returns the text when the player are even
     *
     * @return textEven is the text in the right language
     */
    public String resultEqualText() {
        return currentTexts.get(indexTextEven);
    }

    /**
     * This method returns the text for the fail when the input is wrong
     *
     * @return textInvalidField is the text in the right language
     */
    public String invalidFieldText() {
        return currentTexts.get(indexTextInvalidField);
    }

    /**
     * This method returns the text for the fail when the field is already used
     *
     * @return textFieldAlreadyOccupied is the text in the right language
     */
    public String fieldAlreadyOccupiedText() {
        return currentTexts.get(indexTextFieldOccupied);
    }

    /**
     * This method returns the text for when the user did not change the game language.
     *
     * @return textKeepLanguage is the text in the right language
     */
    public String languageRemainsTheSame() {
        return currentTexts.get(indexTextKeepLanguage);
    }
}