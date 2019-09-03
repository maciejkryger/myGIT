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
    Scanner scanner = new Scanner(System.in);
    int counter = 0;


    protected MemoController() { }

    protected void startGame() {
        board = new MemoBoard(5, 8);
        board.createBoard();
        createPlayers();
        int step = 0;

        do {
            board.showWellcomeBoard();
            board.printPlayerCounters(player1.getName(), player1.getCounter(), player2.getName(), player2.getCounter());
            board.showBoard();
            if (step == 0 || step % 2 == 0) {
                board.printWhoMoveIs(player1.getName());
                counter = player1.getCounter();
                playerMoveGetter();
                showPlayerFieldFromMove();
                boolean status1 = moveChecker();
                if (status1 == true) {
                    counter++;
                    player1.setCounter(counter);

                }
            } else {
                board.printWhoMoveIs(player2.getName());
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
            board.clearConsole();
        } while (finishGame());
        whoIsWinner();
        board.showFinishBoard(step);
    }

    private void createPlayers() {
        board.showWellcomeBoard();
        board.printCreatePlayer(1);
        name1 = scanner.nextLine();
        player1 = new Player(name1);
        player1.setCounter(0);
        board.printCreatePlayer(2);
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
        waitForEnter();
        board.clearConsole();
    }

    private boolean moveChecker() {
        if (showSign1 == showSign2) {
            board.printFieldAreTheSameInfo();
            for (Integer i = 0; i < board.boardMap.size(); i++) {
                String sign = board.boardMap.get(i);
                if (sign == showSign1) {
                    board.boardMap.replace(i, "_");
                    board.boardMapToGuess.replace(i, "");
                }
            }
            return true;
        } else {
            board.printFieldNotTheSameInfo();
            scanner.nextLine();
            return false;
        }
    }

    private void playerMoveGetter() {
        try {
            board.printMakeMove(1);
            move1 = scanner.nextInt();
            do {
                board.printMakeMove(2);
                move2 = scanner.nextInt();
                if (move1 == move2) {
                    board.printNumberOfFieldShouldBeDeferent();
                }
            } while (move1 == move2);
        }catch (InputMismatchException e){
            board.printYourMoveShouldBeInteger();
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
        if (player1.getCounter() > player2.getCounter()){
            board.printWinner(player1.getCounter(),player1.getName());
        } else if(player2.getCounter() > player1.getCounter()) {
            board.printWinner(player2.getCounter(),player2.getName());
        } else {
            board.printDraw();
        }
    }

    private void waitForEnter(){
        board.pressEnterToContinue();
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

}
