package orders;

import java.util.ArrayList;
import java.util.List;

import static orders.PrintMessages.linia;

public class NewOrder {

// * Utwórz klasę Zamówienie
//     * Dodaj pola number oraz price
//     * Utwórz metodę pobierzCena() wypisującą cene
//     */* Konstruktor tworzacy zamowienie
//     * @param number zamowienia
// ArrayList to implementacja interfejsu List
        // inicjalizacja zmiennej typu List
//dodaj Pozycje
//pobierz number
// addItem w zamowieniu (calculate)

// wypisanie pozycji (wypisz rachunek)

    int number;
    float price;
    List<OrderItem> itemList; // nie mogłem tego zapamiętać !!!!
    List<NewOrder> newOrdersList; //nowe by usunąć zamówienie z listy zamówień


    public NewOrder(int number){
        this(number,0);
    }

    public NewOrder(int number, float price){
        this.number = number;
        this.price = price;
        this.itemList = new ArrayList();// nie mogłem tego zapamiętać !!!!
    }

    public int getOrderNumber(){
        return number;
    }

    public float getPrice(){
        return price;
    }

    public List<OrderItem> getItem(){ // nie mogłem tego zapamiętać !!!!
        return itemList;
    }

    public List<NewOrder> pobierzZamowienia() {return newOrdersList;}

    public void dodajPozycje(String itemName, float itemPrice){    // nie mogłem tego zapamiętać !!!!
        OrderItem item = new OrderItem(itemName,itemPrice); // nie mogłem tego zapamiętać !!!!
        itemList.add(item); // nie mogłem tego zapamiętać !!!!
    }



    public void dodajPozycje(OrderItem wybranaPozycja){
        itemList.add(wybranaPozycja);

    }

    public void calculate(){
        float payment=0;
        for (OrderItem item : itemList){ // nie mogłem tego zapamiętać !!!! że trzeba podać typ pozycji OrderItem
            float price = item.getPrice(); // nie mogłem tego zapamiętać !!!! - cała linia
            payment += price; // nie mogłem tego zapamiętać !!!! że dodaje cene, która jest wyżej zdefiniowana
        }
        price = payment; // nie mogłem tego zapamiętać !!!!o tym nie pomyślałem
    }

    public void checkout(){

//        String data = ProjectUtils.obecnaData();
//        StringBuilder builderNaglowek = new StringBuilder();
//        builderNaglowek.append("\"***RACHUNEK***\"").append("\n\n");
//        builderNaglowek.append("wykaz pozycji rachunku nr ").append(numerRachunku).append(" z dnia ").append(data);
//        System.out.println(builderNaglowek);

        linia();

        float totalAccount=0;

        int itemPositionNumber=1;
            for (OrderItem orderItem : itemList){ // o tym zapomniałem by mi wypisywało sume ceny
                System.out.println("pozycja nr "+itemPositionNumber);
                orderItem.orderItemsPrint(itemPositionNumber);

                totalAccount+=getPrice();
                calculate();
                linia();

                itemPositionNumber++;
            }
        itemPositionNumber++;



        StringBuilder builder = new StringBuilder();
        builder.append("***************************\n");
        builder.append("*** Do zapłaty:\t\t\t***\n");
        builder.append("*** netto: ").append(totalAccount).append(" PLN \t***\n");
        builder.append("*** VAT: ").append(totalAccount*0.08).append(" PLN \t\t***\n");
        builder.append("*** brutto: ").append(totalAccount).append(" PLN \t***\n");
        builder.append("***************************\n");
        System.out.println(builder);
    }



}
