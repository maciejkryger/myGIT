package hangman;

import java.util.List;

public class BoardView {


    protected void printLanguageSetterBoard(){
        StringBuilder languageBuilder = new StringBuilder();
        languageBuilder
                .append("-------------------------------------\n")
                .append("|  wybierz jezyk /choose language:  |\n")
                .append("|    (1- polski, 2 -english)");
        System.out.print(languageBuilder);
    }

    protected void printWellcomeBoard(int languageChoose) {
        StringBuilder wellcomeBuilder = new StringBuilder();

        if (languageChoose == 1) {
            wellcomeBuilder
                    .append("-------------------------------------\n")
                    .append("|         GRA W WISIELCA            |\n")
                    .append("-------------------------------------");
        } else {
            wellcomeBuilder
                    .append("-------------------------------------\n")
                    .append("|           HANGMAN GAME            |\n")
                    .append("-------------------------------------");
        }
        System.out.println(wellcomeBuilder);
    }

    protected void printWordInfo(int languageChoose, String word, List words) {
        if (languageChoose == 1) {
            System.out.printf("| slowo do odgadniecia ma %d znakow  |\n", word.length());
            System.out.printf("|   ilosc slow w bazie wynosi %d    |", words.size());
        } else {
            System.out.printf("| your random word has %d characters |\n", word.length());
            System.out.printf("|    we have %d words in the base   |", words.size());
        }
    }


    protected  void printWinerFinishBoard(int languageChoose) {
        StringBuilder finishBoardBuilder = new StringBuilder();
        if (languageChoose == 1) {
            finishBoardBuilder
                    .append("|                                   |\n")
                    .append("|      KONIEC GRY ! WYGRALES!       |\n")
                    .append("|                                   |\n")
                    .append("-------------------------------------\n");
        } else {
            finishBoardBuilder
                    .append("|                                   |\n")
                    .append("|       GAME OVER ! YOU WON!        |\n")
                    .append("|                                   |\n")
                    .append("-------------------------------------\n");
        }
        System.out.print(finishBoardBuilder);
    }


    protected  void printLoserFinishBoard(int languageChoose) {
        StringBuilder finishBuilder = new StringBuilder();
        if (languageChoose == 1) {
            finishBuilder
                    .append("|                                   |\n")
                    .append("|    KONIEC GRY ! PRZEGRALES!       |\n")
                    .append("|                                   |\n")
                    .append("-------------------------------------\n");
        } else {
            finishBuilder
                    .append("|                                   |\n")
                    .append("|      GAME OVER ! YOU LOST!        |\n")
                    .append("|                                   |\n")
                    .append("-------------------------------------\n");
        }
        System.out.print(finishBuilder);
    }

    protected void printWord(String word, int languageChoose) {
        StringBuilder wordBuilder = new StringBuilder();
        if (languageChoose==1) {
            wordBuilder
                    .append("| slowo, ktore zgadywales to ")
                    .append(word)
                    .append("\n-------------------------------------\n");
        }else {
            wordBuilder
                    .append("| word, we asking was ")
                    .append(word)
                    .append("\n-------------------------------------\n");
        }
        System.out.print(wordBuilder);
    }

    protected void printWordToGuessText(int languageChoose) {
        StringBuilder wordToGuessTextbuilder = new StringBuilder();
        if (languageChoose == 1) {
            wordToGuessTextbuilder
                    .append("|   twoje slowo do odgadniecia:     |\n")
                    .append("|     ");
        } else {
            wordToGuessTextbuilder
                    .append("|    your word to guess:            |\n")
                    .append("|     ");
        }
        System.out.print(wordToGuessTextbuilder);
    }

    protected void printSeparateLine() {
        StringBuilder separateLineBuilder = new StringBuilder();
        separateLineBuilder
                .append("\n|                                   |\n")
                .append("-------------------------------------\n");
        System.out.print(separateLineBuilder);
    }

    protected void printGuessLetterText(int languageChoose) {
        StringBuilder quessTextBuilder = new StringBuilder();
        if (languageChoose == 1) {
            quessTextBuilder
                    .append("| Zgadnij nastepna litere: ");
        } else {
            quessTextBuilder
                    .append("|    guess next letter: ");
        }
        System.out.print(quessTextBuilder);
    }

    protected void printWinnerCounterText(int languageChoose, int winnerCounter) {
        if (languageChoose == 1) {
            System.out.printf("|       ilosc wygranych: %d          |\n", winnerCounter);
        } else if (languageChoose == 2 && winnerCounter == 1) {
            System.out.printf("|          you won %d time           |\n", winnerCounter);
        } else {
            System.out.printf("|          you won %d times          |\n", winnerCounter);
        }
        System.out.println("-------------------------------------");
    }

    protected void printLoserCounterText(int languageChoose, int loserCounter) {
        if (languageChoose == 1) {
            System.out.printf("|       ilosc przegranych: %d        |\n", loserCounter);
        } else if (languageChoose == 2 && loserCounter == 1) {
            System.out.printf("|          you lose %d time          |\n", loserCounter);
        } else {
            System.out.printf("|          you lose %d times         |\n", loserCounter);
        }
        System.out.println("-------------------------------------");
    }

    protected void printPlayAgainQuestion(int languageChoose) {
        if (languageChoose == 1) {
            System.out.print("| chcesz zagrac ponownie? t/n:");
        } else {
            System.out.print("| do you want play again? y/n:");
        }
    }

    protected void printAllWordsGuessedInfo(int languageChoose) {
        StringBuilder builder = new StringBuilder();
        if (languageChoose == 1) {
            builder
                    .append("\n")
                    .append("-------------------------------------\n")
                    .append("|    brawo! koniec gry              |\n")
                    .append("|   wszystkie slowa odgadniete      |\n")
                    .append("-------------------------------------");
        } else {
            builder
                    .append("\n")
                    .append("-------------------------------------\n")
                    .append("|    congrats ! game over!          |\n")
                    .append("|    all words are guessed :)       |\n")
                    .append("-------------------------------------");
        }
        System.out.println(builder);
    }

    public void printHangmanFigure(int step) {
        StringBuilder builder = new StringBuilder();
        if (step == 0) {
            builder
                    .append("\n")
                    .append("-------------------------------------\n")
                    .append("|              -----                |\n")
                    .append("|              |/  |                |\n")
                    .append("|              |                    |\n")
                    .append("|              |                    |\n")
                    .append("|              |                    |\n")
                    .append("|              |                    |\n")
                    .append("-------------------------------------\n");
        } else if (step == 1) {
            builder
                    .append("\n")
                    .append("-------------------------------------\n")
                    .append("|              -----                |\n")
                    .append("|              |/  |                |\n")
                    .append("|              |   O                |\n")
                    .append("|              |                    |\n")
                    .append("|              |                    |\n")
                    .append("|              |                    |\n")
                    .append("-------------------------------------\n");
        } else if (step == 2) {
            builder
                    .append("\n")
                    .append("-------------------------------------\n")
                    .append("|              -----                |\n")
                    .append("|              |/  |                |\n")
                    .append("|              |   O                |\n")
                    .append("|              |   |                |\n")
                    .append("|              |                    |\n")
                    .append("|              |                    |\n")
                    .append("-------------------------------------\n");
        } else if (step == 3) {
            builder
                    .append("\n")
                    .append("-------------------------------------\n")
                    .append("|              -----                |\n")
                    .append("|              |/  |                |\n")
                    .append("|              |   O                |\n")
                    .append("|              |  /|                |\n")
                    .append("|              |                    |\n")
                    .append("|              |                    |\n")
                    .append("-------------------------------------\n");
        } else if (step == 4) {
            builder
                    .append("\n")
                    .append("-------------------------------------\n")
                    .append("|              -----                |\n")
                    .append("|              |/  |                |\n")
                    .append("|              |   O                |\n")
                    .append("|              |  /|)               |\n")
                    .append("|              |                    |\n")
                    .append("|              |                    |\n")
                    .append("-------------------------------------\n");
        } else if (step == 5) {
            builder
                    .append("\n")
                    .append("-------------------------------------\n")
                    .append("|              -----                |\n")
                    .append("|              |/  |                |\n")
                    .append("|              |   O                |\n")
                    .append("|              |  /|)               |\n")
                    .append("|              |  /                 |\n")
                    .append("|              |                    |\n")
                    .append("-------------------------------------\n");
        } else if (step == 6) {
            builder
                    .append("\n")
                    .append("-------------------------------------\n")
                    .append("|              -----                |\n")
                    .append("|              |/  |                |\n")
                    .append("|              |   O                |\n")
                    .append("|              |  /|)               |\n")
                    .append("|              |  / )               |\n")
                    .append("|              |                    |\n")
                    .append("-------------------------------------\n");
        }
        System.out.print(builder);
    }


}