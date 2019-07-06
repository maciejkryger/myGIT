package orders.observers;

import orders.factory.interfaces.PizzaItem;

public class PrintObserver extends ShopBasketObserver {


    public PrintObserver(ShopBasket shopBasket) {
        this.subject=shopBasket;
        this.subject.subscribePrintObserver(this);
    }

    @Override
    public void onUpdate(PizzaItem item) {
        System.out.println("New item added: "+item.toString());
    }
}
