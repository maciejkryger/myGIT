package hangman;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordsToGuess {

    BoardView boardView = new BoardView(); //open boardView class
    List<String> words = new ArrayList<>(); //List of words is in game
    char[] wordInTable;                    // Table where I put one random word char by char


    public WordsToGuess() {                 //empty constructor

    }

    protected List<String> createWordsList(int languageChoose) {
        if (languageChoose == 1) {
            words.add("jablko");
            words.add("banan");
            words.add("kiwi");
            words.add("pomidor");
            words.add("ananas");
            words.add("cebula");
            words.add("marchew");
            words.add("fasola");
            words.add("ziemniak");
            words.add("ogorek");
            words.add("pomarancza");
            words.add("cytryna");
            words.add("winogrono");
            words.add("melon");
            words.add("pietruszka");
            words.add("seler");
            words.add("rzodkiewka");
            words.add("gruszka");
            words.add("czosnek");
            words.add("burak");
            words.add("mandarynka");
            words.add("brzoskwinia");

        } else {
            words.add("apple");
            words.add("banana");
            words.add("kiwi");
            words.add("tomato");
            words.add("pineapple");
            words.add("onion");
            words.add("carrot");
            words.add("bean");
            words.add("potato");
            words.add("cucumber");
            words.add("orange");
            words.add("lemon");
        }
        return words;
    }


    public String getRandomWord(int languageChoose, List<String>words) { //in this method I random and return one word from List and print how many char it is
        Random random = new Random();
        String word = words.get(random.nextInt(words.size()));
        boardView.printWordInfo(languageChoose, word, words);
        return word;
    }

    public char[] getLettersFromWord(String word) {        //in this method I put word in the Table char by char
        wordInTable = new char[word.length()];
        for (int i = 0; i < word.length(); i++) {
            wordInTable[i] = word.charAt(i);
        }
        return wordInTable;
    }

    public char[] encodeWordToGuess(char[] wordLettersTable) {  // in this method I encode letters to _ char by char
        char[] wordsToGuessTable = new char[wordLettersTable.length];

        for (int i = 0; i < wordLettersTable.length; i++) {
            wordsToGuessTable[i] = '_';
        }
        return wordsToGuessTable; //return encoding Table with _ _ _ _ _ _ _ boardView, ever letter have one char like _
    }

    public void printEncodedWordToGuessTable(char[] wordsToGuessTable) {  // this method print actual Table with encoded word to guess
        StringBuilder wordFromTableBuilder = new StringBuilder();
        for (char word : wordsToGuessTable) {
            wordFromTableBuilder.append(word).append(" ");
        }
        System.out.print(wordFromTableBuilder);
    }

    protected void removeGuessedWord(String word, List<String>words, int languageChoose){
            words.remove(word);
        if (words.isEmpty()) {
            boardView.printAllWordsGuessedInfo(languageChoose);
            System.exit(200);
        }
    }


}
