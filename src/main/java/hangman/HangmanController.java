package hangman;

import java.util.List;
import java.util.Scanner;

public class HangmanController {

    BoardView boardView = new BoardView();
    int winnerCounter = 0;
    int loserCounter = 0;
    int languageVersion;
    String word;
    char yourLetter;
    char[] wordLettersTable;
    char[] wordToGuessTable;
    WordsToGuess wordsToGuess;
    boolean gameIsFinished;
    int step;


    public HangmanController() {

    }

    public void startGame() {
        wordsToGuess = new WordsToGuess();
        languageVersion = setLanguageVersion();

        List<String> words = wordsToGuess.createWordsList(languageVersion);

        char again = 'y';  //loop repeater
        while (again == 'y' || again == 't') {
            boardView.printWellcomeBoard(languageVersion);

            word = wordsToGuess.getRandomWord(languageVersion, words); //print how many letters have your random word
            wordLettersTable = wordsToGuess.getLettersFromWord(word); //create table with letters of random word
            wordToGuessTable = wordsToGuess.encodeWordToGuess(wordLettersTable); // create table with _ char to guess
            yourLetter = ' '; //declare your letter field to guess
            gameIsFinished = false; //games status to repeat steps
            step = 0; //reset counter of steps

            boardView.printHangmanFigure(step);  //print hangman figure for the begin only gallows for the step counter 0
            boardView.printWordToGuessText(languageVersion); //print word to guess text introduction
            wordsToGuess.printEncodedWordToGuessTable(wordToGuessTable); //print encoded word to guess
            boardView.printSeparateLine(); //separate line after printed encoded word to guess

            gameCore(); //game process
            finishBoardController(gameIsFinished);  //check which board should show - for winner or loser, and count win games and lose games

            boardView.printWinnerCounterText(languageVersion, winnerCounter); //show winning games counter
            boardView.printLoserCounterText(languageVersion, loserCounter); //show winning games counter

            wordsToGuess.removeGuessedWord(word, words, languageVersion); //removing word, which was showed, because of unique

            boardView.printPlayAgainQuestion(languageVersion); //asking if you want to play again
            again = readYourLetter();

        }
    }

    public void gameCore() {
        do {
            boardView.printGuessLetterText(languageVersion);  //print guess letter text introduction
            yourLetter = readYourLetter(); //read letter to guess from keyboard
            step = wordMatcher(yourLetter, step, wordLettersTable, wordToGuessTable); //matcher guessing letters and actualize step if letter is wrong
            boardView.printHangmanFigure(step); //print figure by next step
            boardView.printWordToGuessText(languageVersion); //print word to guess text introduction
            wordsToGuess.printEncodedWordToGuessTable(wordToGuessTable); //print encoded word to guess
            gameIsFinished = gameFinishChecker(word, wordToGuessTable); //checker if game is finished
            boardView.printSeparateLine(); //separate line after printed encoded word to guess
        } while (step < 6 && !gameIsFinished);


    }

    public void finishBoardController(boolean gameIsFinished) {
        if (gameIsFinished) {
            boardView.printWinerFinishBoard(languageVersion); //if not, player win
            winnerCounter++;
        } else {
            boardView.printLoserFinishBoard(languageVersion); //if yes, player is loser
            boardView.printWord(word, languageVersion);
            loserCounter++;
        }
    }


    public int wordMatcher(char myLetter, int step, char[] wordLettersTable, char[] wordsToGuessTable) {
        boolean wordWasChangedInThisStep = false;
        for (int i = 0; i < wordLettersTable.length; i++) {
            if (myLetter == wordLettersTable[i]) {
                wordsToGuessTable[i] = myLetter;
                wordWasChangedInThisStep = true;
            }
        }
        if (wordWasChangedInThisStep == false) {
            step++;
        }
        return step;
    }


    public boolean gameFinishChecker(String word, char[] wordToGuessTable) {
        boolean gameStatus = false;
        String guessWord = "";
        for (int i = 0; i < wordToGuessTable.length; i++) {
            guessWord += wordToGuessTable[i];
        }
        if (guessWord.contentEquals(word)) {
            gameStatus = true;
        }
        return gameStatus;
    }


    public char readYourLetter() {
        Scanner scanner = new Scanner(System.in);
        String yourLetter = scanner.next().toLowerCase();
        char yourLetterToChar = yourLetter.charAt(0);
        return yourLetterToChar;
    }

    public int setLanguageVersion() {
        boardView.printLanguageSetterBoard();
        Scanner versionScanner = new Scanner(System.in);
        int languageChoose = versionScanner.nextInt();
        return languageChoose;
    }


}
