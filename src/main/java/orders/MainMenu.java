package orders;

import orders.enums.MainMenuOptions;

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
                return MainMenuOptions.EXIT;

            case 1:
                return MainMenuOptions.NEW_ORDER;

            case 2:
                return MainMenuOptions.ORDER_STATUS;

            case 3:
                return MainMenuOptions.CHECKOUT_ORDERS;

            case 4:
                return MainMenuOptions.INVOICE;

            case 5:
                return MainMenuOptions.CANCEL_ORDER;

            default:
                return MainMenuOptions.BAD_CHOICE;
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
