package ProjectDemo.com.services.cards;

import ProjectDemo.com.services.ApiBaseMethods;
import lombok.extern.log4j.Log4j2;

import static ProjectDemo.com.services.ApiBaseMethods.*;
import static ProjectDemo.com.services.cards.CardPostAPIServices.cardIds;

@Log4j2
public class CardDeleteAPIServices extends CardAbstractClass {

    private static void setFinalUrlForCardDelete(){
        String idCard = cardIds.getFirst();
        setUrlQueryParameter("key", key);
        setUrlQueryParameter("token", token);
        finalQueryParam = removeLastCharFromUrl();
        finalUrl = baseUrlTrello + "cards/" + idCard + finalQueryParam;
    }



    public static void sendDeleteRequestForCardDelete() {
        int initialSize = cardIds.size();
        System.out.println("cardIds = " + cardIds);
        for (int i = 1; i<=initialSize; i++) {
            setFinalUrlForCardDelete();
            response = ApiBaseMethods.deleteRequest(finalUrl);
            log.info("----- Deleted card id = " + cardId + "-----");
            response.prettyPrint();
            finalQueryParam = "?";
            cardIds.remove(cardId);
        }
    }


}
