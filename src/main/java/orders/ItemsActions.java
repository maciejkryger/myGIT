package orders;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ItemsActions {

    List<PozycjaZamowieniaNew> listaPozycji;
    ZamowienieNew zamowienieNew;
    PozycjaZamowieniaNew pozycjaZamowieniaNew;
    int deletedItem;
    Scanner skaner= new Scanner(System.in);


    public ItemsActions(){

    }

    public ItemsActions(ZamowienieNew zamowienieNew){
        this.zamowienieNew=zamowienieNew;
    }

    public ItemsActions(ZamowienieNew zamowienieNew, PozycjaZamowieniaNew pozycjaZamowieniaNew){
        this.zamowienieNew=zamowienieNew;
        this.pozycjaZamowieniaNew=pozycjaZamowieniaNew;
    }

    public void printOrderItems(ZamowienieNew noweZamowienie){
        List <PozycjaZamowieniaNew> pozycjeZamowienia = noweZamowienie.listaPozycji;
        pozycjeZamowienia=noweZamowienie.listaPozycji;
        int nrPoz =1;
        for (PozycjaZamowieniaNew pozycja: pozycjeZamowienia){
            System.out.print(nrPoz+" ");
            System.out.println(pozycja);
            nrPoz++;
        }

    }


    public void delOrderItem(ZamowienieNew noweZamowienie, int deletedItem){

        listaPozycji=noweZamowienie.listaPozycji;

        listaPozycji.remove(deletedItem-1);

    }


}
