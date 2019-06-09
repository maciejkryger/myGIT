package orders;

import java.util.HashMap;

public class BazaPozycjiMenu extends HashMap<Integer, PozycjaZamowieniaNew> {

    /**
     * konstruktor, który tworzy bazę pozycji wymaganej do projektu zamówień
     */
    public BazaPozycjiMenu(){
        super(); //tworzenie mapy
        put(1,new PozycjaZamowieniaNew("Tatar z wołowiny",39));
        put(2,new PozycjaZamowieniaNew("Pyra z gzikiem",21));
        put(3,new PozycjaZamowieniaNew("Pasztet z dzika",25));
        put(4,new PozycjaZamowieniaNew("Schabowy",36));
        put(5,new PozycjaZamowieniaNew("KACZBURGER",29));
        put(6,new PozycjaZamowieniaNew("Stek z wołowiny",69));

    }

    /**
     * metoda pobiera pozycje
     * @param numerPozycji - numer pozycji którą pobieram
     * @return zwracamy pozycje zamówienia
     */
    public PozycjaZamowieniaNew pobierzPozycje(int numerPozycji){
        return get(numerPozycji);
    }

    /**
     * metoda zwraca informację o istnieniu danej pozycji
     * @param numerPozycji numer pozycji, który sprawdzamy
     * @return zwraca nam prawdę bądź fałsz, gdy zawiera
     */
    public boolean czyZawiera(int numerPozycji){
        return containsKey(numerPozycji);
    }

    /**
     * metoda wypisująca pozycje z "bazy" zamówienia
     *
     *
     */
    public void wypiszPozycjeZBazy(){
        StringBuilder podsumowanieNapis = new StringBuilder();
        System.out.println("\nJadłospis:");
        System.out.println("-----------");

        for (Entry<Integer, PozycjaZamowieniaNew> element: entrySet()){
            int numer = element.getKey();
            PozycjaZamowieniaNew pozycjaZamowieniaNew = element.getValue();
            String nazwa = pozycjaZamowieniaNew.pobierzNazwe();
            float cena = pozycjaZamowieniaNew.pobierzCene();
            podsumowanieNapis.append(numer).append(" ").append(nazwa).append(" ").append(cena).append("\n");
        }
        System.out.println(podsumowanieNapis);
    }
}

