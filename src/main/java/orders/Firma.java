package orders;

/**
 * Firma
 *
 * @author:
 * @date: 30.03.2019 11:05
 **/
public class Firma {

    /**
     * Zadanie domowe
     * -------------------------
     * Dokończyć klasę Firma aby wypisywała niezbędne dane
     * na rachunku pobierzDane();
     */

    //wiele pol w zaleznosci od potrzeb
    String nazwa;
    String ulica;
    String kodPocztowy;
    String miasto;
    String nip;

    //konstruktor

    public Firma(){
        nazwa="Restauracja JAVA FOOD";
        ulica="Nowa 1";
        kodPocztowy="60-682";
        miasto="Poznań";
        nip="777-66-55-444";
    }

    public Firma(String nazwa, String ulica, String kodPocztowy, String miasto, String nip){
        this.nazwa=nazwa;
        this.ulica=ulica;
        this.kodPocztowy=kodPocztowy;
        this.miasto=miasto;
        this.nip=nip;
    }



    /**
     * Przykład
     * @return
     */
    public String pobierzDane(){
        StringBuilder builder = new StringBuilder();
        builder.append("Nazwa firmy:\t").append(pobierzNazwe()).append("\n");
        builder.append("Adres:\t").append(pobierzUlice()).append(", ");
        builder.append("").append(kodPocztowy).append(" ").append(miasto).append("\n");
        builder.append("NIP:\t").append(nip);// nazwa i enter - nowa linia
        return builder.toString();
    }

    public String pobierzNazwe(){
        return nazwa;
    }

    public String pobierzUlice () {return ulica;}

    public String pobierzKodPocztowy () {return kodPocztowy;}

    public  String pobierzMiasto () {return miasto;}

    public String pobierzNip() {return kodPocztowy;}
}
