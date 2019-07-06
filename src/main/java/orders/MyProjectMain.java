package orders;


import orders.enums.MainMenuOptions;
import orders.enums.MiniMenuOptions;
import orders.objects.Company;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static orders.PrintMessages.*;

public class MyProjectMain {

    private static final Logger logger
            = LoggerFactory.getLogger(MyProjectMain.class);

    public static void main(String[] args) {

        logger.debug("Aplication is started by {}", MyProjectMain.class.getSimpleName());
        MainMenu mainMenu = new MainMenu(); // nie mogłem tego zapamiętać !!!! to podstawa do wywołania metody z tej klasy !!!
        List<NewOrder> newOrderList = new ArrayList(); // nie mogłem tego zapamiętać !!!!
        // by zdefiniować listę zamowien typu NewOrder jako nową zmienną newOrdersList

        int orderNumber=1;
        boolean warunek = true;
        while (warunek) {
            mainMenu.showMainMenu();
            MainMenuOptions wybor = mainMenu.getMenuSelection();  // nie mogłem tego zapamiętać !!!! by zdefiniowac zmienną jako pobranie wyboru

            switch (wybor) {
                case NEW_ORDER:

//                    int orderNumber = newOrderList.size() + 1; // nie mogłem tego zapamiętać !!!!
                    // by zdefiniować number jako zmienną i przypisać mu wielkość listy powiększone o 1
                    //                    zastępuję to osobnym licznikiem, bo przy usuwaniu zamówienia dublowało numery;

                    NewOrder newOrder = new NewOrder(orderNumber); // nie mogłem tego zapamiętać !!!! by był number w ()
                    ItemsActions itemsActions = new ItemsActions();
                    newOrderList.add(newOrder); // o tym zapomniałem i nic się nie wyświetało !!!
                    logger.debug("Order number "+orderNumber+" is created", MyProjectMain.class.getSimpleName());

                    MiniMenu miniMenu = new MiniMenu();

                    boolean miniMenuNeeded=true;

                    while (miniMenuNeeded) {
                        /**
                         * mapa pozycji to menu z potrawami
                         */
                        ItemsBaseMenu itemsMap = wypisaniePozycjiZBazy();

                        //mini menu to opcje dodaj pozycje, usun pozycje, anuluj zamownienie, wroc do meni
                        miniMenu.wyswietlMiniMenu();

                        Scanner skaner = new Scanner(System.in);
                        MiniMenuOptions wyborMiniMenu = miniMenu.pobierzWyborMiniMenu();



                        switch (wyborMiniMenu) {
                            case ADD:

                                int positionNumber;


                                try {
                                    System.out.print("Podaj number pozycji: ");
                                    positionNumber = skaner.nextInt();

                                } catch (InputMismatchException e) {
                                    logger.error("Error InputMismatchException for position number in {}", MyProjectMain.class.getSimpleName());
                                    numberErrorMessage();
                                    stopMove();
                                    break;
                                }
                                OrderItem selectedItem = itemsMap.pobierzPozycje(positionNumber);
                                if (selectedItem == null){
                                    logger.error("Choing empty position from HashMap in {}", MyProjectMain.class.getSimpleName());
                                    nullErrorMessage();
                                }else {
                                    newOrder.addItem(selectedItem);
                                    logger.debug("add Item from selected Item of HashMap, position nr "+positionNumber, MyProjectMain.class.getSimpleName());
//                                poniższa metoda nie działa  -> nie dodaje zamówienia
//                                itemsActions.addItem(selectedItem);
                                }
                                miniMenuNeeded = true;
                                break;

                            case PRINT:

                                itemsActions.printOrderItems(newOrder);
                                logger.debug("print Order Items ", MyProjectMain.class.getSimpleName());
                                miniMenuNeeded = true;
                                stopMove();
                                break;

                            case DEL:

                                itemsActions.printOrderItems(newOrder);

                                System.out.print("Podaj number pozycji do usunięcia: ");
                                int orderItemToDelNumber = skaner.nextInt();

                                itemsActions.delOrderItem(newOrder, orderItemToDelNumber);
                                logger.debug("deleted Order Item: "+orderItemToDelNumber, MyProjectMain.class.getSimpleName());
                                miniMenuNeeded = true;
                                break;


                            case CANCEL:
                                newOrderList.remove(newOrder);
                                logger.debug("Current orders canceled", MyProjectMain.class.getSimpleName());
                                miniMenuNeeded = false;
                                break;

                            case BACK:
                                logger.debug("return to the Main Menu", MyProjectMain.class.getSimpleName());
                                miniMenuNeeded = false;
                                break;

                            case BAD_CHOICE:
                                logger.info("bad choice in mini menu", MyProjectMain.class.getSimpleName());
                                badChoiceMessage();
                                miniMenuNeeded=true;
                                break;
                        }

                    }
                    orderNumber++;
                    break;


                case ORDER_STATUS:
                    System.out.println("Sprawdzanie stanu zamowienia");
                    System.out.print("Podaj jego number : ");
                    Scanner skaner2 = new Scanner(System.in);
                    int checkedNumber = skaner2.nextInt();
                    logger.debug("looking in order satus number "+checkedNumber, MyProjectMain.class.getSimpleName());

                    for (NewOrder itemFromList : newOrderList) { // to jest lista zamówień, chce dostać się do pozycji z tej listy
                        int orderNumberItemFromList = itemFromList.getOrderNumber();
                        float finalSum = 0;
                        if (checkedNumber == orderNumberItemFromList) {
                            List<OrderItem> orderItemsStatus = itemFromList.getItem();     // ważne do nauki !
                            // to jest lista pozycji zamówień, do której się dostaję przez pozycje z listy zamówień wyżej
                            int itemPositionNumber=1;
                            for (OrderItem item : orderItemsStatus) {             // ważne do nauki !
                                // dostaję się do pozycji na liście pozycji zamówień do sprawdzenia stanu
                                item.orderItemsPrint(itemPositionNumber);        // ważne do nauki ! miesza mi się z jakiej listy co wypisać
                                //wypisuję pozycje zamówienia dla danej pozycji
                                finalSum += item.getSum();
                                itemPositionNumber++;
                            }
                            line();
                            System.out.println("Suma zamówienia: " + finalSum+" PLN");
                            line();
                        }
                    }

                    mainMenu.backMove();
                    break;

                case CHECKOUT_ORDERS:
                    System.out.println("***** Podsumowanie zamówień *****");
                    logger.debug("checkout orders", MyProjectMain.class.getSimpleName());
                    float orderSummary = 0;

                    for (NewOrder orderFromOrderList : newOrderList) {
                        //teraz należy pobrać number zamówienia dla pozycji z listyNowychZamówień

                        int checkoutOrderNumber = orderFromOrderList.getOrderNumber();
                        line();
                        System.out.println("Numer zamówienia: " + checkoutOrderNumber);// dlaczego to nie działało?
                        line();
                        // bo nie dodałem nowego zamówienia do listy nowych zamówień, wiersz 35

                        List<OrderItem> orderItemList = orderFromOrderList.getItem(); // nie mogłem tego zapamiętać !!!!

                        int itemPositionNumber=1;
                        for (OrderItem item : orderItemList) {
                            item.orderItemsPrint(itemPositionNumber);
                            orderSummary += item.getSum();
                            itemPositionNumber++;
                        }


                    }
                    line();
                    System.out.println("łącznie do zapłaty: "+orderSummary+" PLN");
                    mainMenu.backMove();
                    break;

                case INVOICE:
                    logger.debug("Printing Invoice", MyProjectMain.class.getSimpleName());
                    StringBuilder topbuilder = new StringBuilder();
                    Company companyBill = new Company();
                    topbuilder.append("\n\n\n");
                    topbuilder.append(companyBill.getCompanyData());
                    topbuilder.append("\n\n\n");
                    String data = ProjectUtils.obecnaData();
                    topbuilder.append("\n***INVOICE").append(" z dnia ").append(data).append(" ***\n\n");
                    topbuilder.append("wykaz pozycji");
                    System.out.println(topbuilder);
                    line();
                    float billSum=0;

                   int itemPositionNumber =1;

                    for (NewOrder pozycjeZListy : newOrderList) {
                        List<OrderItem> orderItemList = pozycjeZListy.itemList;


                        for (OrderItem pozycjaZamowienia : orderItemList){
                            pozycjaZamowienia.orderItemsPrint(itemPositionNumber);
                            billSum+=pozycjaZamowienia.getSum();
                            itemPositionNumber++;
                        }
                    }
                    line();

                    StringBuilder builder = new StringBuilder();
                    builder.append("***************************\n");
                    builder.append("*** Do zapłaty:\t\t\t***\n");
                    builder.append("*** netto: ").append(billSum*0.92).append(" PLN \t***\n");
                    builder.append("*** VAT: ").append(billSum*0.08).append(" PLN \t\t***\n");
                    builder.append("*** brutto: ").append(billSum).append(" PLN \t***\n");
                    builder.append("***************************\n");
                    System.out.println(builder);
                    mainMenu.backMove();
                    break;

                case CANCEL_ORDER:
                    System.out.print("Usuń zamówienie number:");
                    Scanner skaner3 = new Scanner(System.in);
                    int numberToCancel = skaner3.nextInt();
                    newOrderList.remove(numberToCancel-1);
                    logger.debug("Canceled order number "+numberToCancel, MyProjectMain.class.getSimpleName());
                    line();
                    mainMenu.backMove();
                    break;


                case EXIT:
                    logger.debug("Exit from Aplication", MyProjectMain.class.getSimpleName());
                    goodBye();
                    warunek = false;
                    break;

                case BAD_CHOICE:
                    logger.info("badChoice", MyProjectMain.class.getSimpleName());
                    badChoiceMessage();
                    mainMenu.backMove();
            }
        }


    }




    private static ItemsBaseMenu wypisaniePozycjiZBazy() {
        ItemsBaseMenu positionMap = new ItemsBaseMenu();
        positionMap.printItemsMenu();
        return positionMap;
    }





}



