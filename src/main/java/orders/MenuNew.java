package orders;

import java.util.Scanner;

import static orders.Wypisz.komunikatWyjatek;

public class MenuNew {

//    void wyswietl
//    pobierz wybor (switch - scaner)
//    powrot
    public void wyswietlMenu(){
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

    public OpcjaMenuNew  pobierzWyborMenu(){  // nie mogłem tego zapamiętać !!!!
        System.out.print("Wybierz opcje menu:");
        Scanner skaner = new Scanner(System.in);

        int wybor=-1;

        try
        {
        wybor = skaner.nextInt();
        }catch(Exception e){
            komunikatWyjatek();

        }


        switch (wybor){
            case 0:
                return OpcjaMenuNew.WYJDZ;

            case 1:
                return OpcjaMenuNew.ZLOZ_ZAMOWIENIE;

            case 2:
                return OpcjaMenuNew.STAN_ZAMOWIENIA;

            case 3:
                return OpcjaMenuNew.WYPISZ_ZAMOWIENIA;

            case 4:
                return OpcjaMenuNew.RACHUNEK;

            case 5:
                return OpcjaMenuNew.ANULUJ_ZAMOWIENIE;

            default:
                return OpcjaMenuNew.NIE_POPRAWNIE;
        }

    }

    public void powrot(){
        System.out.println("---------------------------------------------");
        System.out.println("wciśnij ENTER, by wrócić do panelu zamówienia");
        System.out.print("---------------------------------------------");
        Scanner skaner = new Scanner(System.in);
        skaner.nextLine();

    }

}
