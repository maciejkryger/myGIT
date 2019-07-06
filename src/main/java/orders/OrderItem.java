package orders;

public class OrderItem {

    // pola: companyName, ilosc, itemPrice

    // konstruktor: companyName,price,ilosc
    // kostruktor: companyName, price ,(domyslnie ilosc =1)

    // metody : getSum(), getPrice() /jednostki

    String itemName;
    int numberOfItems;
    float itemPrice;

    public OrderItem(String itemName, float itemPrice, int numberOfItems){
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.numberOfItems = numberOfItems;
    }

    public OrderItem(String itemName, float itemPrice){
        this(itemName, itemPrice,(short)1);
    }

    public String getName(){
        return itemName;
    }

    public float getPrice(){
        return itemPrice;
    }

    public float getSum(){
        return itemPrice * numberOfItems;
    }

    public void orderItemsPrint(int itemPositionNumber) {

        StringBuilder builder = new StringBuilder();
        builder.append("----------------------------------------------- ").append("\n")
                .append(itemPositionNumber).append(". \n")
                .append("\t Nazwa: ").append(itemName).append("\tcena: ").append(itemPrice).append(" PLN\n")
                .append("\t Ilość: ").append(numberOfItems)
                .append("\t Do zapłaty: ").append(getSum()).append(" PLN\n");

        System.out.println(builder.toString());
    }
    public String toString(){
        return itemName + " cena: " + itemPrice +" PLN";

    }
}
