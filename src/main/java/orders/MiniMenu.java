package orders;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MiniMenu {

    public void wyswietlMiniMenu(){
        StringBuilder builder = new StringBuilder();
        builder.append("**************************************************").append("\n").
                append("* DODAJ(1) |  USUN(2)     | ANULUJ(3)  | WRÓĆ(0) *\n").
                append("* POZYCJE  | OST.POZYCJE  | ZAMÓWIENIE | DO MENU *\n").
                append("**************************************************");
        System.out.println(builder);
    }

    public OpcjaMiniMenu pobierzWyborMiniMenu (){


        Scanner skaner = new Scanner(System.in);
        int wyborMiniMenu=-1;
        try {
            System.out.print("wybierz:");
            wyborMiniMenu = skaner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("ilość/numer musi być cyfrą");

        }

        switch (wyborMiniMenu){
            case 1:
                return OpcjaMiniMenu.DODAJ;

            case 2:
                return OpcjaMiniMenu.USUN;

            case 3:
                return OpcjaMiniMenu.ANULUJ;

            case 0:
                return OpcjaMiniMenu.WROC;

            default:
                return OpcjaMiniMenu.BLEDNY_WYBOR;
        }

    }

}
