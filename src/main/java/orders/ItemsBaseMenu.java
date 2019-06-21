package orders;

import java.util.HashMap;

public class ItemsBaseMenu extends HashMap<Integer, OrderItem> {

    /**
     * konstruktor, który tworzy bazę pozycji wymaganej do projektu zamówień
     */
    public ItemsBaseMenu(){
        super(); //tworzenie mapy
        put(1,new OrderItem("Tatar z wołowiny",39));
        put(2,new OrderItem("Pyra z gzikiem",21));
        put(3,new OrderItem("Pasztet z dzika",25));
        put(4,new OrderItem("Schabowy",36));
        put(5,new OrderItem("KACZBURGER",29));
        put(6,new OrderItem("Stek z wołowiny",69));

    }

    /**
     * metoda pobiera pozycje
     * @param numerPozycji - number pozycji którą pobieram
     * @return zwracamy pozycje zamówienia
     */
    public OrderItem pobierzPozycje(int numerPozycji){
        return get(numerPozycji);
    }

    /**
     * metoda zwraca informację o istnieniu danej pozycji
     * @param numerPozycji number pozycji, który sprawdzamy
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

        for (Entry<Integer, OrderItem> element: entrySet()){
            int numer = element.getKey();
            OrderItem orderItem = element.getValue();
            String nazwa = orderItem.getName();
            float cena = orderItem.getPrice();
            podsumowanieNapis.append(numer).append(" ").append(nazwa).append(" ").append(cena).append("\n");
        }
        System.out.println(podsumowanieNapis);
    }
}

