package orders.factory.interfaces;

public interface PizzaItem {


    String getName();
    float getPrice();
    boolean isForAdult();
    boolean isLactoseFree();
    boolean isGlutenFree();

}
