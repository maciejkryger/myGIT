package orders;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ProjektUtils {

    /**
     * Metoda tworzy date z napisu
     * @param format
     * @param dataNapis
     * @return dataObiekt
     */
    public static LocalDateTime utworzDateZNapisu(String format, String dataNapis){
        DateTimeFormatter formaterDaty = DateTimeFormatter.ofPattern(format);
        LocalDateTime dataObiekt = LocalDateTime.parse(dataNapis,formaterDaty);
        return dataObiekt;
    }

    /**
     * Metoda, która zamienia data w napis
     *
     * @param formatDaty format daty
     * @param dataObiekt data jako obiekt
     * @return dataJakoNapis tworzymy z daty napis
     */
    public static String utworzNapisZDaty(String formatDaty, LocalDateTime dataObiekt){
        // utworzono formaterDaty aby wykorzystać go podczas formatowania
        DateTimeFormatter formaterDaty = DateTimeFormatter.ofPattern(formatDaty);
        // formatowanie dataObiekt do napisu
        String dataJakoNapis = dataObiekt.format(formaterDaty);
        return dataJakoNapis;
    }

    /**
     * Metoda zwraca obecną datę w danym formacie
     * @return obecna data jako napis
     */
    public static String obecnaData(){
        return utworzNapisZDaty("dd-MM-yyyy HH:mm:ss",LocalDateTime.now());
    }

    public static String wypiszKwote(float kwota){
        String kwotaTekst = String.format("%.2f PLN",kwota);
        //poniżej zwraca nam stringa
        //String.format("%.2f zł",kwota);

        //poniżej wypisuje na konsole nic nie zwraca
        //System.out.printf("%.2f zł",kwota);
        return kwotaTekst;
    }

}
