package orders.factory.objects;

import orders.factory.interfaces.PizzaItem;
import orders.factory.enums.PizzaAdditives;
import orders.factory.enums.PizzaSauces;

import java.util.ArrayList;

public class Pizza implements PizzaItem {

    private String pizzaName;
    private int pizzaPrice;
    private ArrayList<PizzaSauces> pizzaSauces;
    private ArrayList<PizzaAdditives> pizzaAdditives;

    public Pizza(PizzaBuilder pizzaBuilder) {
        this.pizzaName=pizzaBuilder.name;
        this.pizzaPrice=pizzaBuilder.price;
        this.pizzaSauces =pizzaBuilder.sauces;
        this.pizzaAdditives=pizzaBuilder.additives;
    }


    @Override
    public String getName() {
        return pizzaName;
    }

    @Override
    public float getPrice() {
        return pizzaPrice;
    }

    @Override
    public boolean isForAdult() {
        return false;
    }

    @Override
    public boolean isLactoseFree() {
        return false;
    }

    @Override
    public boolean isGlutenFree() {
        return false;
    }

    @Override
    public String toString() {
        return pizzaName;
    }

    public static class PizzaBuilder {

        private String name;
        private int price;
        private ArrayList<PizzaSauces>sauces= new ArrayList<>();
        private ArrayList<PizzaAdditives> additives = new ArrayList<>();

        public PizzaBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public PizzaBuilder setPrice(int price) {
            this.price = price;
            return this;
        }

        public PizzaBuilder setPizzaSauces(PizzaSauces sauce) {
            this.sauces.add(sauce);
            this.price=this.price+1;
            return this;
        }

        public PizzaBuilder setPizzaAdditives(PizzaAdditives additives) {
            this.additives.add(additives);
            this.price=this.price+2;
            return this;
        }

        public Pizza build(){
            return new Pizza(this);
        }
    }
}
