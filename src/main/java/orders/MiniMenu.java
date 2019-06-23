package orders;

import orders.enums.MiniMenuOptions;

import java.util.InputMismatchException;
import java.util.Scanner;

import static orders.PrintMessages.numberErrorMessage;

public class MiniMenu {

    public void wyswietlMiniMenu(){
        StringBuilder builder = new StringBuilder();
        builder.append("***********************************************************").append("\n").
                append("* DODAJ(1) |  WYPISZ(2)|  USUN(3)  | ANULUJ(4)  | WRÓĆ(0) *\n").
                append("* POZYCJE  |  POZYCJE  |  POZYCJE  | ZAMÓWIENIE | DO MENU *\n").
                append("***********************************************************");
        System.out.println(builder);
    }


    public MiniMenuOptions pobierzWyborMiniMenu (){

        Scanner skaner = new Scanner(System.in);
        int wyborMiniMenu=-1;
        try {
            System.out.print("wybierz:");
            wyborMiniMenu = skaner.nextInt();
        } catch (InputMismatchException e) {
            numberErrorMessage();

        }

        switch (wyborMiniMenu){
            case 1:
                return MiniMenuOptions.ADD;

            case 2:
                return MiniMenuOptions.PRINT;

            case 3:
                return MiniMenuOptions.DEL;

            case 4:
                return MiniMenuOptions.CANCEL;

            case 0:
                return MiniMenuOptions.BACK;

            default:
                return MiniMenuOptions.BAD_CHOICE;
        }

    }

}
