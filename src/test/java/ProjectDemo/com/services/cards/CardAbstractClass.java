package ProjectDemo.com.services.cards;

import java.util.ArrayList;
import java.util.List;

public abstract class CardAbstractClass {

    static String finalQueryParam = "?";
    static String cardId = "";
    static List<String> cardIds = new ArrayList<>();

    static void setUrlQueryParameter(String queryParam, String value) {
        finalQueryParam += queryParam + "=" + value + "&";
    }

        static String removeLastCharFromUrl() {
        return finalQueryParam = finalQueryParam.substring(0, finalQueryParam.length() - 1);
    }
}
