package orders;

import java.util.Scanner;

public class PrintMessages {


    public static void goodBye(){
        System.out.println("do widzenia, zapraszamy ponownie");
    }

    public static void numberErrorMessage(){
        System.out.println("wybór musi być cyfrą");
    }

    public static void badChoiceMessage() {
        StringBuilder builderTekst = new StringBuilder();
        builderTekst.append("=====================================\n").
                append("= błędny wybór, wybierz ponownie... =\n").
                append("=====================================");
        System.out.println(builderTekst);
    }

    public static void linia () {
        System.out.println("-----------------------------------------------");
    }

    public static void stopMove(){
        System.out.println("---------------------------------------------");
        System.out.println("wciśnij ENTER, by kontynuować");
        System.out.print("---------------------------------------------");
        Scanner skaner = new Scanner(System.in);
        skaner.nextLine();

    }

}
