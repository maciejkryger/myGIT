package orders.factory.interfaces;

import orders.factory.enums.PizzaMenuNames;
import orders.factory.objects.Pizza;

public interface PizzaFactory {

    Pizza producePizza(PizzaMenuNames pizzaMenuName);
}
