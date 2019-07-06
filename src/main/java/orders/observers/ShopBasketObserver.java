package orders.observers;

import orders.factory.interfaces.PizzaItem;

public abstract class ShopBasketObserver {

    protected ShopBasket subject;
    public abstract void onUpdate(PizzaItem item);
}
