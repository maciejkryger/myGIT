package orders;

public class PozycjaZamowieniaNew {

    // pola: nazwa, ilosc, cenaJednostki

    // konstruktor: nazwa,cena,ilosc
    // kostruktor: nazwa, cena ,(domyslnie ilosc =1)

    // metody : pobierzSume(), pobierzCene() /jednostki

    String nazwaJednostki;
    int iloscJednostek;
    float cenaJednostki;

    public PozycjaZamowieniaNew(String nazwaJednostki, float cenaJednostki, int iloscJednostek){
        this.nazwaJednostki=nazwaJednostki;
        this.cenaJednostki=cenaJednostki;
        this.iloscJednostek=iloscJednostek;
    }

    public PozycjaZamowieniaNew(String nazwaJednostki, float cenaJednostki){
        this(nazwaJednostki,cenaJednostki,(short)1);
    }

    public String pobierzNazwe(){
        return nazwaJednostki;
    }

    public float pobierzCene(){
        return cenaJednostki;
    }

    public float pobierzSume(){
        return cenaJednostki*iloscJednostek;
    }

    public void wypiszPozycjeZamowienia() {

        StringBuilder builder = new StringBuilder();
        builder.append("----------------------------------- ").append("\n");
        builder.append("\t Nazwa: ").append(nazwaJednostki).append("\tcena: ").append(cenaJednostki).append(" zł\n");
        builder.append("\t Ilość: ").append(iloscJednostek);
        builder.append("\t Do zapłaty: ").append(pobierzSume()).append(" zł\n");

        System.out.println(builder.toString());
    }
    public String toString(){
        return nazwaJednostki + " cena: " + cenaJednostki +" PLN";

    }
}
