package orders;

public class Wypisz {


    public static void doWidzenia(){
        System.out.println("do widzenia");
    }

    public static void komunikatWyjatek(){
        System.out.println("wybór musi być cyfrą");
    }

    public static void blednyWyborTekst() {
        StringBuilder builderTekst = new StringBuilder();
        builderTekst.append("=====================================\n").
                append("= błędny wybór, wybierz ponownie... =\n").
                append("=====================================");
        System.out.println(builderTekst);
    }

    public static void linia () {
        System.out.println("-----------------------------------");
    }
}
