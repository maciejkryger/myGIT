package orders.factory.objects;

import orders.factory.interfaces.Food_Item_Interface;

public class Beer implements Food_Item_Interface {

    private String beerName;
    private float beerPrice;

    public Beer(BeerBuilder beerBuilder) {
        this.beerName=beerBuilder.name;
        this.beerPrice=beerBuilder.price;
    }


    @Override
    public String getName() {
        return beerName;
    }

    @Override
    public float getPrice() {
        return beerPrice;
    }

    @Override
    public boolean isForAdult() {
        return true;
    }

    @Override
    public boolean isLactoseFree() {
        return false;
    }

    @Override
    public boolean isGlutenFree() {
        return false;
    }


    public static class BeerBuilder{

        private String name;
        private int price;

        public BeerBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public BeerBuilder setPrice(int price) {
            this.price = price;
            return this;
        }

        public Beer build(){
            return new Beer(this);
        }
    }

}
