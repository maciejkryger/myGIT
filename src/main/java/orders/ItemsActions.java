package orders;

import java.util.List;
import java.util.Scanner;

public class ItemsActions {

    List<OrderItem> itemsList;
    NewOrder newOrder;
    OrderItem orderItem;
    int deletedItem;
    Scanner skaner= new Scanner(System.in);


    public ItemsActions(){

    }

    public ItemsActions(NewOrder newOrder){
        this.newOrder = newOrder;
    }

    public ItemsActions(NewOrder newOrder, OrderItem orderItem){
        this.newOrder = newOrder;
        this.orderItem = orderItem;
    }


    public void addItem(OrderItem selectedNumber){
       itemsList.add(selectedNumber);

    }


    public void printOrderItems(NewOrder newOrder){
        List <OrderItem> pozycjeZamowienia = newOrder.itemList;
        pozycjeZamowienia=newOrder.itemList;
        int nrPoz =1;
        for (OrderItem pozycja: pozycjeZamowienia){
            System.out.print(nrPoz+" ");
            System.out.println(pozycja);
            nrPoz++;
        }

    }


    public void delOrderItem(NewOrder newOrder, int deletedItem){

        itemsList=newOrder.itemList;

        itemsList.remove(deletedItem-1);

    }



}
