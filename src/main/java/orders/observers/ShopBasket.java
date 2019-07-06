package orders.observers;

import orders.factory.objects.User;

public class ShopBasket {

    public static final int ADULT_AGE =18;
    private User user;
    private PrintObserver printObserver;


    public ShopBasket(User user) {
        this.user = user;
        System.out.println("Witaj, "+user.getUserName()+"!");
    }


    public void subscribePrintObserver(PrintObserver printObserver) {
        this.printObserver=printObserver;
    }
}
