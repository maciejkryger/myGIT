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


    protected void showWellcomeBoard(int language) {
        if (language == 1) {
            StringBuilder wellcomeBoardBuilder = new StringBuilder();
            wellcomeBoardBuilder
                    .append("-----------------------------------------------------------------\n")
                    .append("|                           GRA MEMO                            |\n")
                    .append("-----------------------------------------------------------------\n");
            System.out.print(wellcomeBoardBuilder);
        } else {
            StringBuilder wellcomeBoardBuilder = new StringBuilder();
            wellcomeBoardBuilder
                    .append("-----------------------------------------------------------------\n")
                    .append("|                           MEMO GAME                           |\n")
                    .append("-----------------------------------------------------------------\n");
            System.out.print(wellcomeBoardBuilder);
        }
    }

    protected void printCreatePlayer(int playerNumber, int language) {
        if (playerNumber == 1 && language == 1) {
            System.out.print("| podaj imie pierwszego gracza:");
        } else if (playerNumber == 2 && language == 1) {
            System.out.print("| podaj imie drugiego gracza:");
        } else if (playerNumber == 1 && language == 2) {
            System.out.print("| player 1 name:");
        } else {
            System.out.print("| player 2 name:");
        }
    }

    protected void printPlayerCounters(String name1, int counter1, String name2, int counter2, int language) {
        if (language == 1) {
            System.out.printf("|   Gracz1: %s ma punktow: %d                    \n", name1, counter1);
            System.out.printf("|   Gracz2: %s ma punktow: %d                    \n", name2, counter2);
        } else {
            System.out.printf("|   Player1: %s has points: %d                    \n", name1, counter1);
            System.out.printf("|   Player2: %s has points: %d                    \n", name2, counter2);
        }
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


    protected void printFieldAreTheSameInfo(int language) {
        StringBuilder builder = new StringBuilder();
        if (language == 1) {
            builder
                    .append("-----------------------------------------------------------------\n")
                    .append("|      >>>  brawo, pola sa rowne i znikaja z puli   <<<         |\n")
                    .append("-----------------------------------------------------------------\n");
        } else {
            builder
                    .append("-----------------------------------------------------------------\n")
                    .append("|    >>>  congrats, fields are the same and disappear   <<<     |\n")
                    .append("-----------------------------------------------------------------\n");
        }
        System.out.print(builder);

    }

    protected void printFieldNotTheSameInfo(int language) {
        StringBuilder builder = new StringBuilder();
        if (language == 1) {
            builder
                    .append("-----------------------------------------------------------------\n")
                    .append("| >>>  Niestety, pola maja rozne wartosci, sprobuj ponownie <<< |\n")
                    .append("-----------------------------------------------------------------\n");
        } else {
            builder
                    .append("-----------------------------------------------------------------\n")
                    .append("|   >>>    Mistake, fields are not the same, try again   <<<    |\n")
                    .append("-----------------------------------------------------------------\n");
        }
        System.out.print(builder);
    }


    protected void printWhoMoveIs(String name, int language) {
        if (language == 1) {
            System.out.print("| teraz jest ruch gracza: " + name + "\n");
        } else {
            System.out.print("| now is move of: " + name + "\n");
        }
    }

    protected void printNumberOfFieldShouldBeDeferent(int language) {
        if (language == 1) {
            System.out.println("| Numery pol muszą byc rozne!!! ");
        } else {
            System.out.println("| Fields numbers should be different !!! ");
        }
    }


    protected void printMakeMove(int fieldNumber, int language) {
        if (fieldNumber == 1 && language ==1) {
            System.out.print("| Odkryj pole nr 1:");
        } else if (fieldNumber == 2 && language ==1) {
            System.out.print("| Odkryj pole nr 2:");
        }else if (fieldNumber==1 && language ==2){
            System.out.print("| Please put first field number:");
        }else {
            System.out.print("| Please put second field number:");
        }
    }

    protected void printYourMoveShouldBeInteger(int language) {
        StringBuilder builder = new StringBuilder();
        if(language==1) {
            builder
                    .append("\n-----------------------------------------------------------------\n")
                    .append("|    >>>>  wybor musi być cyfra, tracisz kolejke  <<<<          |\n")
                    .append("-----------------------------------------------------------------\n");
        }else {
            builder
                    .append("\n-----------------------------------------------------------------\n")
                    .append("|   >>>>  your choose should be integer, you miss move   <<<<   |\n")
                    .append("-----------------------------------------------------------------\n");
        }
        System.out.println(builder);
    }

    protected void printWinner(int counter, String name, int language) {
        StringBuilder builder = new StringBuilder();
        if (language==1) {
            builder
                    .append("-----------------------------------------------------------------\n")
                    .append("|             BRAWO !!!  ZWYCIEZCA ZOSTAL GRACZ:                |\n")
                    .append("|               " + name + " z " + counter + " punktami                  \n")
                    .append("-----------------------------------------------------------------\n");
        }else {
            builder
                    .append("-----------------------------------------------------------------\n")
                    .append("|               CONGRATS !!!  THE WINNER IS:                    |\n")
                    .append("|               " + name + " with " + counter + " points                 \n")
                    .append("-----------------------------------------------------------------\n");
        }
        builder
                .append("                          **********\n")
                .append("                           ********\n")
                .append("                            ******\n")
                .append("                              **\n")
                .append("                              **\n")
                .append("                             ****\n");
        System.out.print(builder);

    }

    protected void printDraw(int language) {
        StringBuilder builder = new StringBuilder();
        if (language==1) {
            builder
                    .append("-----------------------------------------------------------------\n")
                    .append("|                    KONIEC GRY ! JEST REMIS !                  |\n")
                    .append("-----------------------------------------------------------------\n");
        }else {
            builder
                    .append("-----------------------------------------------------------------\n")
                    .append("|                    GAME OVER ! IT's a DRAW !                  |\n")
                    .append("-----------------------------------------------------------------\n");
        }
        System.out.print(builder);
    }

    protected void showFinishBoard(int step, int language) {
        StringBuilder builder = new StringBuilder();
        if (language==1) {
            builder
                    .append("-----------------------------------------------------------------\n")
                    .append("|                gra przebiegla w ").append(step).append(" ruchach :)                 |\n")
                    .append("-----------------------------------------------------------------\n");
        }else {
            builder
                    .append("-----------------------------------------------------------------\n")
                    .append("|               the game run in ").append(step).append(" steps :)                    |\n")
                    .append("-----------------------------------------------------------------\n");
        }
        System.out.print(builder);
    }

    protected void clearConsole() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            builder.append("\n");
        }
        System.out.print(builder);
    }

    public void pressEnterToContinue(int language) {
        if(language==1) {
            System.out.println("by kontynuowac nacisnij ENTER");
        }else {
            System.out.println("press ENTER to continue");
        }
    }

    public void printLanguageVersionInfo() {
        System.out.println("| wybierz jezyk/choose language:");
        System.out.print("| 1-polski/2-english:");
    }
}
