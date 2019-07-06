package orders.factory;

import orders.factory.interfaces.PizzaFactory;
import orders.factory.enums.PizzaAdditives;
import orders.factory.enums.PizzaMenuNames;
import orders.factory.enums.PizzaSauces;
import orders.factory.objects.Pizza;

import static orders.PrintMessages.badChoiceMessage;

public class JavaFoodFactory implements PizzaFactory {



    @Override
    public Pizza producePizza(PizzaMenuNames pizzaMenuName) {
        Pizza result=null;

        switch (pizzaMenuName){
            case MARGHERITA:
                result=new Pizza.PizzaBuilder()
                        .setName("Margherita")
                        .setPrice(10)
                        .setPizzaSauces(PizzaSauces.TOMATO_SAUCE)
                        .setPizzaAdditives(PizzaAdditives.CHEESE)
                        .build();
                break;

            case CAPRICCIOSA:
                result=new Pizza.PizzaBuilder()
                        .setName("Capricciosa")
                        .setPrice(10)
                        .setPizzaSauces(PizzaSauces.TOMATO_SAUCE)
                        .setPizzaAdditives(PizzaAdditives.CHEESE)
                        .setPizzaAdditives(PizzaAdditives.MUSHROOMS)
                        .setPizzaAdditives(PizzaAdditives.HAM)
                        .build();
                break;

            case FUNGHI:
                result= new Pizza.PizzaBuilder().setName("Funghi")
                        .setPrice(10)
                        .setPizzaSauces(PizzaSauces.TOMATO_SAUCE)
                        .setPizzaAdditives(PizzaAdditives.CHEESE)
                        .setPizzaAdditives(PizzaAdditives.MUSHROOMS)
                        .build();
                break;

            case TROPICANA:
                result= new Pizza.PizzaBuilder().setName("Tropicana")
                        .setPrice(10)
                        .setPizzaSauces(PizzaSauces.TOMATO_SAUCE)
                        .setPizzaAdditives(PizzaAdditives.CHEESE)
                        .setPizzaAdditives(PizzaAdditives.HAM)
                        .setPizzaAdditives(PizzaAdditives.BANANA)
                        .setPizzaAdditives(PizzaAdditives.PEACH)
                        .setPizzaAdditives(PizzaAdditives.PINEAPPLE)
                        .build();
                break;

            case VEGETARIANA:
                result = new Pizza.PizzaBuilder()
                        .setName("Vegetariana")
                        .setPrice(10)
                        .setPizzaSauces(PizzaSauces.TOMATO_SAUCE)
                        .setPizzaAdditives(PizzaAdditives.CHEESE)
                        .setPizzaAdditives(PizzaAdditives.MUSHROOMS)
                        .setPizzaAdditives(PizzaAdditives.ASPARAGUS)
                        .build();
                break;

            default:
                badChoiceMessage();
                break;
        }
        return result;
    }
}
