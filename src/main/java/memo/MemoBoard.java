package memo;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MemoBoard {

    private int x;
    private int y;
    private String[] signTable = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "R", "S", "T", "U", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "R", "S", "T", "U"};
    Map<Integer, String> boardMap = new HashMap<>();
    Map<Integer, Object> boardMapToGuess = new HashMap<>();


    protected MemoBoard(int x, int y) {
        this.x = x;
        this.y = y;
    }


    protected void createBoard() {
        Random random = new Random();
        int randomIndex;
        int fieldCounter = 1;

        for (int i = 0; i < x * y; i++) {
            String sign;
            do {
                randomIndex = random.nextInt(signTable.length);
                sign = signTable[randomIndex];
            } while (sign == "#");

            if (sign != "|") {
                signTable[randomIndex] = "#";
                boardMap.put(i, sign);
                boardMapToGuess.put(i, fieldCounter);
                fieldCounter++;
            }
        }
    }


    protected void showWellcomeBoard() {
        StringBuilder wellcomeBoardBuilder = new StringBuilder();
        wellcomeBoardBuilder
                .append("-----------------------------------------------------------------\n")
                .append("|                           GRA MEMORY                          |\n")
                .append("-----------------------------------------------------------------\n");
        System.out.print(wellcomeBoardBuilder);

    }

    protected void printCreatePlayer(int playerNumber) {
        if (playerNumber == 1) {
            System.out.print("| podaj imię pierwszego gracza:");
        } else if (playerNumber == 2) {
            System.out.print("| podaj imię drugiego gracza:");
        }
    }

    protected void printPlayerCounters(String name1, int counter1, String name2, int counter2) {
        System.out.printf("|   Gracz1: %s ma odgadniętych kart: %d                   \n", name1, counter1);
        System.out.printf("|   Gracz2: %s ma odgadniętych kart: %d                   \n", name2, counter2);
    }


    protected void showBoard() {
        int v = 0;
        StringBuilder boardBuilder = new StringBuilder();
        boardBuilder.append("-----------------------------------------------------------------\n");
        for (int i = 0; i < x; i++) {
            boardBuilder.append("|\t");
            for (int j = 0; j < y; j++) {
                boardBuilder.append(boardMapToGuess.get(v)).append("\t|\t");
                v++;
            }
            boardBuilder.append("\n-----------------------------------------------------------------\n");

        }
        System.out.print(boardBuilder);
    }

    protected void showTempBoard(Map<Integer, Object> boardMapTemp) {
        int v = 0;
        StringBuilder boardBuilder = new StringBuilder();
        boardBuilder.append("-----------------------------------------------------------------\n");
        for (int i = 0; i < x; i++) {
            boardBuilder.append("|\t");
            for (int j = 0; j < y; j++) {
                boardBuilder.append(boardMapTemp.get(v)).append("\t|\t");
                v++;
            }
            boardBuilder.append("\n-----------------------------------------------------------------\n");

        }
        System.out.print(boardBuilder);
    }


    protected void printFieldAreTheSameInfo() {
        StringBuilder builder = new StringBuilder();
        builder
                .append("-----------------------------------------------------------------\n")
                .append("|      >>>  brawo, pola są równe i znikają z puli   <<<         |\n")
                .append("-----------------------------------------------------------------\n");
        System.out.print(builder);

    }

    protected void printFieldNotTheSameInfo() {
        StringBuilder builder = new StringBuilder();
        builder
                .append("-----------------------------------------------------------------\n")
                .append("| >>>  Niestety, pola mają różne wartości, spróbuj ponownie <<< |\n")
                .append("-----------------------------------------------------------------\n");
        System.out.print(builder);
    }


    protected void printWhoMoveIs(String name) {
        System.out.print("| teraz jest ruch gracza: " + name + "\n");
    }

    protected void printNumberOfFieldShouldBeDeferent() {
        System.out.println("| Numery pól muszą być różne!!! ");
    }


    protected void printMakeMove(int fieldNumber) {
        if (fieldNumber == 1) {
            System.out.print("| Odkryj pole nr 1:");
        } else if (fieldNumber == 2) {
            System.out.print("| Odkryj pole nr 2:");
        }
    }

    protected void printYourMoveShouldBeInteger() {
        StringBuilder builder = new StringBuilder();
        builder
                .append("-----------------------------------------------------------------\n")
                .append("|    >>>>  wybór musi być cyfrą, tracisz kolejkę  <<<<          |\n")
                .append("-----------------------------------------------------------------\n");
        System.out.println(builder);
    }

    protected void printWinner(int counter, String name) {
        StringBuilder builder = new StringBuilder();
        builder
                .append("-----------------------------------------------------------------\n")
                .append("|             BRAWO !!!  ZWYCIĘŻCĄ ZOSTAŁ GRACZ:                |\n")
                .append("|               "+name+" z "+counter+" punktami                  \n")
                .append("-----------------------------------------------------------------\n")
                .append("                          **********\n")
                .append("                           ********\n")
                .append("                            ******\n")
                .append("                              **\n")
                .append("                              **\n")
                .append("                             ****\n");
        System.out.print(builder);

    }

    protected void printDraw() {
        StringBuilder builder = new StringBuilder();
        builder
                .append("-----------------------------------------------------------------\n")
                .append("|                    KONIEC GRY ! JEST REMIS !                  |\n")
                .append("-----------------------------------------------------------------\n");
        System.out.print(builder);
    }

    protected void showFinishBoard(int step) {
        StringBuilder builder = new StringBuilder();
        builder
                .append("-----------------------------------------------------------------\n")
                .append("|                gra przebiegła w ").append(step).append(" ruchach :)                 |\n")
                .append("-----------------------------------------------------------------\n");
        System.out.print(builder);
    }

    protected void clearConsole(){
        StringBuilder builder = new StringBuilder();
        for (int i=0;i<100; i++){
            builder.append("\n");
        }
        System.out.print(builder);
    }

    public void pressEnterToContinue() {
        System.out.println("by kontynuować naciśnij ENTER");
    }
}
