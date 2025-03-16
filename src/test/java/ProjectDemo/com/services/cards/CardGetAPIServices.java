package ProjectDemo.com.services.cards;

import ProjectDemo.com.pojo.CardsPOJO;
import ProjectDemo.com.services.ApiBaseMethods;
import lombok.extern.log4j.Log4j2;

import static ProjectDemo.com.services.ApiBaseMethods.*;

@Log4j2
public class CardGetAPIServices extends CardAbstractClass {

    private static void setFinalUrlForCardRead(){
        String idCard = cardId;
        setUrlQueryParameter("key", key);
        setUrlQueryParameter("token", token);
        finalQueryParam = removeLastCharFromUrl();
        finalUrl = baseUrlTrello + "cards/" + idCard + finalQueryParam;
    }

    public static void sendGetRequestForCardRead() {
        setFinalUrlForCardRead();
        response = ApiBaseMethods.getRequest(finalUrl);
        log.info("----- Read card id = " + cardId + "-----");
        response.prettyPrint();
        finalQueryParam = "?";
    }

    public static void writeDataToJSON(String cardNumber){
        CardsPOJO cardsPOJO = response.getBody().as(CardsPOJO.class);
        System.out.println("name = " + cardsPOJO.getName());
        System.out.println("desc = " + cardsPOJO.getDesc());
        trelloJSONMap.put("Card id " + cardNumber, cardId);
        trelloJSONMap.put("Card Name " + cardNumber, cardsPOJO.getName());
        trelloJSONMap.put("Card Desc " + cardNumber, cardsPOJO.getDesc());
    }

}
