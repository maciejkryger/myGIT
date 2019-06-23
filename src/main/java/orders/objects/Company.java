package orders.objects;

/**
 * Company
 *
 * @author:
 * @date: 30.03.2019 11:05
 **/
public class Company {

    /**
     * Zadanie domowe
     * -------------------------
     * Dokończyć klasę Company aby wypisywała niezbędne dane
     * na rachunku getCompanyData();
     */

    //wiele pol w zaleznosci od potrzeb
    String companyName;
    String street;
    String houseNumber;
    String postCode;
    String city;
    String nip;

    //konstruktor

    public Company(){
        companyName ="Restauracja JAVA FOOD";
        street ="Nowa";
        houseNumber="1";
        postCode ="60-682";
        city ="Poznań";
        nip="777-66-55-444";
    }

    public Company(String companyName, String street, String houseNumber, String postCode, String city, String nip){
        this.companyName = companyName;
        this.street = street;
        this.houseNumber=houseNumber;
        this.postCode = postCode;
        this.city = city;
        this.nip=nip;
    }



    /**
     * metoda do pobrania danych firmy
     * @return zwraca dane firmy w stringbuilderze
     */
    public String getCompanyData(){
        StringBuilder builder = new StringBuilder();
        builder.append("Nazwa firmy:\t").append(getCompanyName()).append("\n");
        builder.append("Adres:\t").append(getStreet()).append(" ").append(houseNumber).append(", ");
        builder.append("").append(postCode).append(" ").append(city).append("\n");
        builder.append("NIP:\t").append(nip);// companyName i enter - nowa linia
        return builder.toString();
    }

    public String getCompanyName(){
        return companyName;
    }

    public String getStreet() {return street;}

    public String getHouseNumber() {return houseNumber;}

    public String getPostCode() {return postCode;}

    public  String getCity() {return city;}

    public String getNip() {return postCode;}
}
