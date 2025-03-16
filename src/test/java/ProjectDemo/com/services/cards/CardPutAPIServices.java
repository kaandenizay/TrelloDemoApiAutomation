package ProjectDemo.com.services.cards;

import ProjectDemo.com.pojo.CardsPOJO;
import ProjectDemo.com.services.ApiBaseMethods;
import com.utilities.FakerDataCreator;
import com.utilities.JSONProcessManager;
import lombok.extern.log4j.Log4j2;

import java.util.Random;

import static ProjectDemo.com.services.ApiBaseMethods.*;

@Log4j2
public class CardPutAPIServices extends CardAbstractClass {

    private static void setRandomCardId(){
        log.info("-----" + "Card ids : " + cardIds +  "-----");
        Random random = new Random();
        int randomIndex = random.nextInt(cardIds.size()-1);
        cardId = cardIds.get(randomIndex);
        log.info("-----" + "Selected card id : " + cardId +  "-----");
    }

    private static void setFinalUrlForCardUpdate(){
        setRandomCardId();
        String idCard = cardId;
        setUrlQueryParameter("key", key);
        setUrlQueryParameter("token", token);
        finalQueryParam = removeLastCharFromUrl();
        finalUrl = baseUrlTrello + "cards/" + idCard + finalQueryParam;
    }

    private static String prepareCardUpdateBody(){
        faker = new FakerDataCreator();
        String name = faker.wordFromFaker() + " update";
        String description = "updated text " + faker.sentenceFromFaker() ;
        CardsPOJO cardObject = new CardsPOJO(name, description);
        log.info("----- New card name = " + name + "-----");
        return JSONProcessManager.requestBody(cardObject);
    }

    public static void sendPutRequestForCardUpdate() {
        setFinalUrlForCardUpdate();
        String body = prepareCardUpdateBody();
        log.info("Request Body : " + body);
        response = ApiBaseMethods.putRequest(finalUrl, body);
        log.info("----- Updated card id = " + cardId + "-----");
        response.prettyPrint();
        finalQueryParam = "?";
    }


}
