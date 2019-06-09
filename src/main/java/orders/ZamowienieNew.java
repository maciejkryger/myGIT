package orders;

import java.util.ArrayList;
import java.util.List;

import static orders.Wypisz.linia;

public class ZamowienieNew {

// * Utwórz klasę Zamówienie
//     * Dodaj pola numer oraz cena
//     * Utwórz metodę pobierzCena() wypisującą cene
//     */* Konstruktor tworzacy zamowienie
//     * @param numer zamowienia
// ArrayList to implementacja interfejsu List
        // inicjalizacja zmiennej typu List
//dodaj Pozycje
//pobierz numer
// dodajPozycje w zamowieniu (przelicz)

// wypisanie pozycji (wypisz rachunek)

    int numer;
    float cena;
    List<PozycjaZamowieniaNew> listaPozycji; // nie mogłem tego zapamiętać !!!!


    public ZamowienieNew (int numer){
        this(numer,0);
    }

    public ZamowienieNew (int numer,float cena){
        this.numer=numer;
        this.cena=cena;
        this.listaPozycji= new ArrayList();// nie mogłem tego zapamiętać !!!!
    }

    public int pobierzNumer(){
        return numer;
    }

    public float pobierzCene(){
        return cena;
    }

    public List<PozycjaZamowieniaNew> pobierzPozycje(){ // nie mogłem tego zapamiętać !!!!
        return listaPozycji;
    }

    public void dodajPozycje(String nazwaPozycji, float cenaPozycji){    // nie mogłem tego zapamiętać !!!!
        PozycjaZamowieniaNew pozycja = new PozycjaZamowieniaNew(nazwaPozycji,cenaPozycji); // nie mogłem tego zapamiętać !!!!
        listaPozycji.add(pozycja); // nie mogłem tego zapamiętać !!!!
    }

    public void dodajPozycje(PozycjaZamowieniaNew wybranaPozycja){
        listaPozycji.add(wybranaPozycja);

    }

    public void przelicz(){
        float sumaPozycji=0;
        for (PozycjaZamowieniaNew pozycja : listaPozycji){ // nie mogłem tego zapamiętać !!!! że trzeba podać typ pozycji PozycjaZamowieniaNew
            float cena = pozycja.pobierzCene(); // nie mogłem tego zapamiętać !!!! - cała linia
            sumaPozycji += cena; // nie mogłem tego zapamiętać !!!! że dodaje cene, która jest wyżej zdefiniowana
        }
        cena= sumaPozycji; // nie mogłem tego zapamiętać !!!!o tym nie pomyślałem
    }

    public void wypiszRachunek(){

//        String data = ProjektUtils.obecnaData();
//        StringBuilder builderNaglowek = new StringBuilder();
//        builderNaglowek.append("\"***RACHUNEK***\"").append("\n\n");
//        builderNaglowek.append("wykaz pozycji rachunku nr ").append(numerRachunku).append(" z dnia ").append(data);
//        System.out.println(builderNaglowek);

        linia();

        float sumaRachunku=0;
        int lp=1;

            for (PozycjaZamowieniaNew pozycjaZamowienia : listaPozycji){ // o tym zapomniałem by mi wypisywało sume ceny
                System.out.println("pozycja nr "+lp);
                pozycjaZamowienia.wypiszPozycjeZamowienia();

                sumaRachunku=pobierzCene();
                przelicz();
                linia();
                lp++;
            }
            lp++;



        StringBuilder builder = new StringBuilder();
        builder.append("***************************\n");
        builder.append("*** Do zapłaty:\t\t\t***\n");
        builder.append("*** netto: ").append(sumaRachunku).append(" PLN \t***\n");
        builder.append("*** VAT: ").append(sumaRachunku*0.08).append(" PLN \t\t***\n");
        builder.append("*** brutto: ").append(sumaRachunku).append(" PLN \t***\n");
        builder.append("***************************\n");
        System.out.println(builder);
    }


}
