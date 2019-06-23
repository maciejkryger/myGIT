package orders;


import orders.enums.MainMenuOptions;
import orders.enums.MiniMenuOptions;
import orders.objects.Company;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static orders.PrintMessages.*;

public class MyProjectMain {

    public static void main(String[] args) {

        MainMenu mainMenu = new MainMenu(); // nie mogłem tego zapamiętać !!!! to podstawa do wywołania metody z tej klasy !!!
        List<NewOrder> listaNowychZamowien = new ArrayList(); // nie mogłem tego zapamiętać !!!!
        // by zdefiniować listę zamowien typu NewOrder jako nową zmienną newOrdersList

        boolean warunek = true;
        while (warunek) {
            mainMenu.showMainMenu();
            MainMenuOptions wybor = mainMenu.getMenuSelection();  // nie mogłem tego zapamiętać !!!! by zdefiniowac zmienną jako pobranie wyboru

            switch (wybor) {
                case NEW_ORDER:



                    int numer = listaNowychZamowien.size() + 1; // nie mogłem tego zapamiętać !!!!
                    // by zdefiniować number jako zmienną i przypisać mu wielkość listy powiększone o 1
                    NewOrder newOrder = new NewOrder(numer); // nie mogłem tego zapamiętać !!!! by był number w ()
                    listaNowychZamowien.add(newOrder); // o tym zapomniałem i nic się nie wyświetało !!!


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

                        ItemsActions itemsActions = new ItemsActions();

                        switch (wyborMiniMenu) {
                            case ADD:

                                int positionNumber;


                                try {
                                    System.out.print("Podaj number pozycji: ");
                                    positionNumber = skaner.nextInt();

                                } catch (InputMismatchException e) {
                                    numberErrorMessage();
                                    stopMove();
                                    break;
                                }
                                OrderItem selectedItem = itemsMap.pobierzPozycje(positionNumber);
                                newOrder.dodajPozycje(selectedItem);
//                                poniższa metoda nie działa  -> java.lang.NullPointerException
//                                itemsActions.addItem(selectedItem);
                                miniMenuNeeded = true;
                                break;

                            case PRINT:

                                itemsActions.printOrderItems(newOrder);
                                miniMenuNeeded = true;
                                stopMove();
                                break;

                            case DEL:

                                itemsActions.printOrderItems(newOrder);


                                System.out.print("Podaj number pozycji do usunięcia: ");
                                int orderItemToDelNumber = skaner.nextInt();

                                itemsActions.delOrderItem(newOrder, orderItemToDelNumber);
                                miniMenuNeeded = true;
                                break;


                            case CANCEL:
                                listaNowychZamowien.remove(newOrder);
                                miniMenuNeeded = false;
                                break;

                            case BACK:
                                miniMenuNeeded = false;
                                break;

                            case BAD_CHOICE:
                                badChoiceMessage();
                                miniMenuNeeded=true;
                                break;
                        }

                    }

                    break;


                case ORDER_STATUS:
                    System.out.println("Sprawdzanie stanu zamowienia");
                    System.out.print("Podaj jego number : ");
                    Scanner skaner2 = new Scanner(System.in);
                    int numerSprawdzany = skaner2.nextInt();

                    for (NewOrder itemFromList : listaNowychZamowien) { // to jest lista zamówień, chce dostać się do pozycji z tej listy

                        int numerZamowienia = itemFromList.getOrderNumber();
                        float sumaKoncowa = 0;
                        if (numerSprawdzany == numerZamowienia) {
                            List<OrderItem> orderItemsStatus = itemFromList.getItem();     // ważne do nauki !
                            // to jest lista pozycji zamówień, do której się dostaję przez pozycje z listy zamówień wyżej
                            int itemPositionNumber=1;
                            for (OrderItem item : orderItemsStatus) {             // ważne do nauki !
                                // dostaję się do pozycji na liście pozycji zamówień do sprawdzenia stanu
                                item.orderItemsPrint(itemPositionNumber);        // ważne do nauki ! miesza mi się z jakiej listy co wypisać
                                //wypisuję pozycje zamówienia dla danej pozycji
                                sumaKoncowa += item.getSum();
                                itemPositionNumber++;
                            }
                            linia();
                            System.out.println("Suma zamówienia: " + sumaKoncowa);
                            linia();
                        }
                    }

                    mainMenu.backMove();
                    break;

                case CHECKOUT_ORDERS:
                    System.out.println("***** Podsumowanie zamówień *****");
                    float orderSummary = 0;
                    for (NewOrder pozycjeZListy : listaNowychZamowien) {
                        //teraz należy pobrać number zamówienia dla pozycji z listyNowychZamówień

                        int numerZamowienia = pozycjeZListy.getOrderNumber();
                        linia();
                        System.out.println("Numer zamówienia: " + numerZamowienia);// dlaczego to nie działało?
                        linia();
                        // bo nie dodałem nowego zamówienia do listy nowych zamówień, wiersz 35

                        List<OrderItem> pozycjeZamowienia = pozycjeZListy.getItem(); // nie mogłem tego zapamiętać !!!!

                        int itemPositionNumber=1;
                        for (OrderItem pozycja : pozycjeZamowienia) {
                            pozycja.orderItemsPrint(itemPositionNumber);
                            orderSummary += pozycja.getSum();
                            itemPositionNumber++;
                        }


                    }
                    linia();
                    System.out.println("łącznie do zapłaty: "+orderSummary);
                    mainMenu.backMove();
                    break;

                case INVOICE:

                    StringBuilder topbuilder = new StringBuilder();
                    Company companyBill = new Company();
                    topbuilder.append("\n\n\n");
                    topbuilder.append(companyBill.getCompanyData());
                    topbuilder.append("\n\n\n");
                    String data = ProjectUtils.obecnaData();
                    topbuilder.append("\n***INVOICE").append(" z dnia ").append(data).append(" ***\n\n");
                    topbuilder.append("wykaz pozycji");
                    System.out.println(topbuilder);
                    linia();
                    float billSum=0;

                   int itemPositionNumber =1;

                    for (NewOrder pozycjeZListy : listaNowychZamowien) {
                        List<OrderItem> orderItemList = pozycjeZListy.itemList;


                        for (OrderItem pozycjaZamowienia : orderItemList){
                            pozycjaZamowienia.orderItemsPrint(itemPositionNumber);
                            billSum+=pozycjaZamowienia.getSum();
                            itemPositionNumber++;
                        }
                    }
                    linia();

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
                    int numerAnulowany = skaner3.nextInt();
                    listaNowychZamowien.remove(numerAnulowany-1);
                    linia();
                    mainMenu.backMove();
                    break;


                case EXIT:
                    goodBye();
                    warunek = false;
                    break;

                case BAD_CHOICE:
                    badChoiceMessage();
                    mainMenu.backMove();
            }
        }


    }




    private static ItemsBaseMenu wypisaniePozycjiZBazy() {
        ItemsBaseMenu mapaPozycji = new ItemsBaseMenu();
        mapaPozycji.wypiszPozycjeZBazy();
        return mapaPozycji;
    }





}



