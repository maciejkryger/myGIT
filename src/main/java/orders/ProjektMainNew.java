package orders;


import orders.ProjektUtils;
import orders.Firma;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static orders.Wypisz.*;

public class ProjektMainNew {

    public static void main(String[] args) {

        MenuNew menu = new MenuNew(); // nie mogłem tego zapamiętać !!!! to podstawa do wywołania metody z tej klasy !!!
        List<ZamowienieNew> listaNowychZamowien = new ArrayList(); // nie mogłem tego zapamiętać !!!!
        // by zdefiniować listę zamowien typu ZamowienieNew jako nową zmienną listaNowychZamowien

        boolean warunek = true;
        while (warunek) {
            menu.wyswietlMenu();
            OpcjaMenuNew wybor = menu.pobierzWyborMenu();  // nie mogłem tego zapamiętać !!!! by zdefiniowac zmienną jako pobranie wyboru

            switch (wybor) {
                case ZLOZ_ZAMOWIENIE:

                    ZamowienieNew noweZamowienie = dodajZamowienieDoListy(listaNowychZamowien);
                    MiniMenu miniMenu = new MiniMenu();

                    boolean dodajPozycje=true;

                    while (dodajPozycje) {
                        BazaPozycjiMenu mapaPozycji = wypisaniePozycjiZBazy();
                        miniMenu.wyswietlMiniMenu();
                        Scanner skaner = new Scanner(System.in);
                        OpcjaMiniMenu wyborMiniMenu = miniMenu.pobierzWyborMiniMenu();


                        switch (wyborMiniMenu) {
                            case DODAJ:
                                dodajPozycje = true;
                                int numerPozycji;


                                try {
                                    System.out.print("Podaj numer pozycji: ");
                                    numerPozycji = skaner.nextInt();

                                } catch (InputMismatchException e) {
                                    komunikatWyjatek();
                                    menu.powrot();
                                    break;
                                }
                                PozycjaZamowieniaNew wybranaPozycja = mapaPozycji.pobierzPozycje(numerPozycji);
                                noweZamowienie.dodajPozycje(wybranaPozycja);
                                break;

                            case USUN:

                                dodajPozycje = true;
                                break;

                            case ANULUJ:
                                listaNowychZamowien.remove(noweZamowienie);
                                dodajPozycje = false;
                                break;

                            case WROC:
                                dodajPozycje = false;
                                break;

                            case BLEDNY_WYBOR:
                                blednyWyborTekst();
                                break;
                        }

                    }

                    break;


                case STAN_ZAMOWIENIA:
                    System.out.println("Sprawdzanie stanu zamowienia");
                    System.out.print("Podaj jego numer : ");
                    Scanner skaner2 = new Scanner(System.in);
                    int numerSprawdzany = skaner2.nextInt();

                    for (ZamowienieNew pozycjeZListy : listaNowychZamowien) { // to jest lista zamówień, chce dostać się do pozycji z tej listy

                        int numerZamowienia = pozycjeZListy.pobierzNumer();
                        float sumaKoncowa = 0;
                        if (numerSprawdzany == numerZamowienia) {
                            List<PozycjaZamowieniaNew> pozycjeZamowieniaStanu = pozycjeZListy.pobierzPozycje();     // ważne do nauki !
                            // to jest lista pozycji zamówień, do której się dostaję przez pozycje z listy zamówień wyżej

                            for (PozycjaZamowieniaNew pozycja : pozycjeZamowieniaStanu) {             // ważne do nauki !
                                // dostaję się do pozycji na liście pozycji zamówień do sprawdzenia stanu
                                pozycja.wypiszPozycjeZamowienia();        // ważne do nauki ! miesza mi się z jakiej listy co wypisać
                                //wypisuję pozycje zamówienia dla danej pozycji
                                sumaKoncowa += pozycja.pobierzSume();
                            }
                            linia();
                            System.out.println("Suma zamówienia: " + sumaKoncowa);
                            linia();
                        }
                    }

                    menu.powrot();
                    break;

                case WYPISZ_ZAMOWIENIA:
                    System.out.println("***** Podsumowanie zamówień *****");
                    float sumaZamowienia = 0;
                    for (ZamowienieNew pozycjeZListy : listaNowychZamowien) {
                        //teraz należy pobrać numer zamówienia dla pozycji z listyNowychZamówień

                        int numerZamowienia = pozycjeZListy.pobierzNumer();
                        linia();
                        System.out.println("Numer zamówienia: " + numerZamowienia);// dlaczego to nie działało?
                        linia();
                        // bo nie dodałem nowego zamówienia do listy nowych zamówień, wiersz 35

                        List<PozycjaZamowieniaNew> pozycjeZamowienia = pozycjeZListy.pobierzPozycje(); // nie mogłem tego zapamiętać !!!!


                        for (PozycjaZamowieniaNew pozycja : pozycjeZamowienia) {
                            pozycja.wypiszPozycjeZamowienia();
                            sumaZamowienia += pozycja.pobierzSume();
                        }


                    }
                    linia();
                    System.out.println("łącznie do zapłaty: "+sumaZamowienia);
                    menu.powrot();
                    break;

                case RACHUNEK:
                    StringBuilder builderNaglowek = new StringBuilder();
                    Firma rachunekFirma = new Firma();
                    builderNaglowek.append("\n\n\n");
                    builderNaglowek.append(rachunekFirma.pobierzDane());
                    builderNaglowek.append("\n\n\n");
                    String data = ProjektUtils.obecnaData();
                    builderNaglowek.append("\n***RACHUNEK").append(" z dnia ").append(data).append(" ***\n\n");
                    builderNaglowek.append("wykaz pozycji");
                    System.out.println(builderNaglowek);
                    linia();
                    float sumaRachunku=0;
                   int lp=1;
                    for (ZamowienieNew pozycjeZListy : listaNowychZamowien) {
                        List<PozycjaZamowieniaNew> pozycjaZamowieniaNewList = pozycjeZListy.listaPozycji;

                        for (PozycjaZamowieniaNew pozycjaZamowienia : pozycjaZamowieniaNewList){
                            System.out.println("pozycja nr "+lp);
                            pozycjaZamowienia.wypiszPozycjeZamowienia();

                            sumaRachunku+=pozycjaZamowienia.pobierzSume();
                            linia();
                            lp++;
                        }
                    }


                    StringBuilder builder = new StringBuilder();
                    builder.append("***************************\n");
                    builder.append("*** Do zapłaty:\t\t\t***\n");
                    builder.append("*** netto: ").append(sumaRachunku*0.92).append(" PLN \t***\n");
                    builder.append("*** VAT: ").append(sumaRachunku*0.08).append(" PLN \t\t***\n");
                    builder.append("*** brutto: ").append(sumaRachunku).append(" PLN \t***\n");
                    builder.append("***************************\n");
                    System.out.println(builder);
                    menu.powrot();
                    break;

                case WYJDZ:
                    doWidzenia();
                    warunek = false;
                    break;

                case NIE_POPRAWNIE:
                    blednyWyborTekst();
                    menu.powrot();
            }
        }


    }




    private static BazaPozycjiMenu wypisaniePozycjiZBazy() {
        BazaPozycjiMenu mapaPozycji = new BazaPozycjiMenu();
        mapaPozycji.wypiszPozycjeZBazy();
        return mapaPozycji;
    }

    private static ZamowienieNew dodajZamowienieDoListy(List<ZamowienieNew> listaNowychZamowien) {
        int numer = listaNowychZamowien.size() + 1; // nie mogłem tego zapamiętać !!!!
        // by zdefiniować numer jako zmienną i przypisać mu wielkość listy powiększone o 1
        ZamowienieNew noweZamowienie = new ZamowienieNew(numer); // nie mogłem tego zapamiętać !!!! by był numer w ()
        listaNowychZamowien.add(noweZamowienie); // o tym zapomniałem i nic się nie wyświetało !!!
        return noweZamowienie;
    }



}



