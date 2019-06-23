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
        List <OrderItem> orderItems = newOrder.itemList;
        orderItems=newOrder.itemList;
        int positionNumber =1;
        for (OrderItem item: orderItems){
            StringBuilder builderPrintOrderItems= new StringBuilder();
            builderPrintOrderItems.append(positionNumber).append(" ").append(item);
            System.out.println(builderPrintOrderItems);
            positionNumber++;
        }

    }


    public void delOrderItem(NewOrder newOrder, int deletedItem){

        itemsList=newOrder.itemList;

        itemsList.remove(deletedItem-1);

    }



}
