package memo;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;


public class MemoController {

    MemoBoard board;
    private int move1;
    private int move2;
    private String showSign1 = null;
    private String showSign2 = null;
    private Map<Integer, Object> boardMapTemp;
    private String name1;
    private Player player1;
    private String name2;
    private Player player2;
    Scanner scanner;
    private int counter = 0;
    private int language;


    protected MemoController() {
    }

    protected void startGame() {
        board = new MemoBoard(5, 8);
        board.createBoard();
        language = languageVersionBrowser();
        createPlayers(language);
        int step = 0;

        do {
            board.showWellcomeBoard(language);
            board.printPlayerCounters(player1.getName(), player1.getCounter(), player2.getName(), player2.getCounter(), language);
            board.showBoard();
            if (step == 0 || step % 2 == 0) {
                board.printWhoMoveIs(player1.getName(), language);
                counter = player1.getCounter();
                playerMoveGetter();
                showPlayerFieldFromMove();
                boolean status1 = moveChecker();
                if (status1 == true) {
                    counter++;
                    player1.setCounter(counter);

                }
            } else {
                board.printWhoMoveIs(player2.getName(), language);
                counter = player2.getCounter();
                playerMoveGetter();
                showPlayerFieldFromMove();
                boolean status2 = moveChecker();
                if (status2 == true) {
                    counter++;
                    player2.setCounter(counter);
                }
            }
            step++;
            waitForEnter();
            board.clearConsole();
        } while (finishGame());
        whoIsWinner();
        board.showFinishBoard(step, language);
    }

    private int languageVersionBrowser() {
        scanner=new Scanner(System.in);
        int language = 0;
        do {
            board.printLanguageVersionInfo();
            language = scanner.nextInt();
        } while (language == 0);
        return language;
    }

    private void createPlayers(int language) {
        scanner=new Scanner(System.in);
        board.showWellcomeBoard(language);
        board.printCreatePlayer(1, language);
        name1 = scanner.nextLine();
        player1 = new Player(name1);
        player1.setCounter(0);
        board.printCreatePlayer(2, language);
        name2 = scanner.nextLine();
        player2 = new Player(name2);
        player2.setCounter(0);
        board.clearConsole();
    }

    private void showPlayerFieldFromMove() {
        for (Integer i = 0; i < board.boardMap.size(); i++) {
            if (board.boardMapToGuess.get(i).equals(move1)) {
                showSign1 = board.boardMap.get(i);
            }
            if (board.boardMapToGuess.get(i).equals(move2)) {
                showSign2 = board.boardMap.get(i);
            }
        }
        boardMapTemp = createTempBoardMap();
        board.showTempBoard(boardMapTemp);
    }

    private boolean moveChecker() {
        if (showSign1 == showSign2) {
            board.printFieldAreTheSameInfo(language);
            for (Integer i = 0; i < board.boardMap.size(); i++) {
                String sign = board.boardMap.get(i);
                if (sign == showSign1) {
                    board.boardMap.replace(i, "_");
                    board.boardMapToGuess.replace(i, "");
                }
            }
            return true;
        } else {
            board.printFieldNotTheSameInfo(language);
            return false;
        }
    }

    private void playerMoveGetter() {
        try {
            board.printMakeMove(1, language);
            move1 = scanner.nextInt();
            do {
                board.printMakeMove(2, language);
                move2 = scanner.nextInt();
                if (move1 == move2) {
                    board.printNumberOfFieldShouldBeDeferent(language);
                }
            } while (move1 == move2);
        } catch (InputMismatchException e) {
            board.printYourMoveShouldBeInteger(language);
        }
    }

    private Map<Integer, Object> createTempBoardMap() {
        boardMapTemp = new HashMap<Integer, Object>();
        for (int i = 0; i < board.boardMap.size(); i++) {
            boardMapTemp.put(i, " ");
            if (board.boardMapToGuess.get(i).equals(move1)) {
                boardMapTemp.replace(i, showSign1);
            }
            if (board.boardMapToGuess.get(i).equals(move2)) {
                boardMapTemp.replace(i, showSign2);
            }
        }
        return boardMapTemp;
    }

    private boolean finishGame() {
        boolean isFinished = false;
        for (int i = 0; i < board.boardMap.size(); i++) {
            if (board.boardMap.get(i) != "_") {
                isFinished = true;
            }
        }
        return isFinished;
    }

    private void whoIsWinner() {
        if (player1.getCounter() > player2.getCounter()) {
            board.printWinner(player1.getCounter(), player1.getName(), language);
        } else if (player2.getCounter() > player1.getCounter()) {
            board.printWinner(player2.getCounter(), player2.getName(),language);
        } else {
            board.printDraw(language);
        }
    }

    private void waitForEnter() {
        board.pressEnterToContinue(language);
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

}
