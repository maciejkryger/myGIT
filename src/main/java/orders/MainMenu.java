package orders;

import java.util.Scanner;

import static orders.PrintMessages.numberErrorMessage;

public class MainMenu {

//    void wyswietl
//    pobierz wybor (switch - scaner)
//    backMove
    public void showMainMenu(){
        StringBuilder builder = new StringBuilder();
        builder.append("*******************************").append("\n");
        builder.append("***  RESTAURACJA  JAVA FOOD ***").append("\n");
        builder.append("*******************************").append("\n \n");
        builder.append("Panel zamówienia").append("\n");
        builder.append("----------------").append("\n");
        builder.append("1. Złóż zamowienie").append("\n");
        builder.append("2. Stan zamówienia").append("\n");
        builder.append("3. Wypisz zamówienia").append("\n");
        builder.append("4. Wystaw rachunek").append("\n");
        builder.append("5. Anuluj/Usuń zamówienie").append("\n");
        builder.append("0. Zakończ").append("\n");
        System.out.println(builder);
    }

    public MainMenuOptions getMenuSelection(){  // nie mogłem tego zapamiętać !!!!
        System.out.print("Wybierz opcje menu:");
        Scanner skaner = new Scanner(System.in);

        int wybor=-1;

        try
        {
        wybor = skaner.nextInt();
        }catch(Exception e){
            numberErrorMessage();

        }


        switch (wybor){
            case 0:
                return MainMenuOptions.WYJDZ;

            case 1:
                return MainMenuOptions.ZLOZ_ZAMOWIENIE;

            case 2:
                return MainMenuOptions.STAN_ZAMOWIENIA;

            case 3:
                return MainMenuOptions.WYPISZ_ZAMOWIENIA;

            case 4:
                return MainMenuOptions.RACHUNEK;

            case 5:
                return MainMenuOptions.ANULUJ_ZAMOWIENIE;

            default:
                return MainMenuOptions.NIE_POPRAWNIE;
        }

    }

    public void backMove(){
        System.out.println("---------------------------------------------");
        System.out.println("wciśnij ENTER, by wrócić do panelu zamówienia");
        System.out.print("---------------------------------------------");
        Scanner skaner = new Scanner(System.in);
        skaner.nextLine();

    }

}
