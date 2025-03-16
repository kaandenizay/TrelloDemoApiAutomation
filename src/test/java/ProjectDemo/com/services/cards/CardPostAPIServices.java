package ProjectDemo.com.services.cards;

import ProjectDemo.com.pojo.CardsPOJO;
import ProjectDemo.com.services.ApiBaseMethods;
import com.utilities.FakerDataCreator;
import com.utilities.JSONProcessManager;
import lombok.extern.log4j.Log4j2;

import static ProjectDemo.com.services.ApiBaseMethods.*;
import static ProjectDemo.com.services.boards.BoardPostAPIServices.listId;


@Log4j2
public class CardPostAPIServices extends CardAbstractClass{

    private static void setFinalUrlForCardCreate(){
        String idList = listId;
        setUrlQueryParameter("idList", idList);
        setUrlQueryParameter("key", key);
        setUrlQueryParameter("token", token);
        finalQueryParam = removeLastCharFromUrl();
        finalUrl = baseUrlTrello + "cards/" + finalQueryParam;
    }

    private static String prepareCardCreateBody(){
        faker = new FakerDataCreator();
        String name = faker.wordFromFaker();
        String description = faker.sentenceFromFaker();
        boolean isTemplate = false;
        CardsPOJO cardObject = new CardsPOJO(name, description, isTemplate);
        return JSONProcessManager.requestBody(cardObject);
    }

    public static void sendPostRequestForCardCreate() {
        setFinalUrlForCardCreate();
        String body = prepareCardCreateBody();
        log.info("Request Body : " + body);
        response = ApiBaseMethods.postRequest(finalUrl, body);
        response.prettyPrint();
        finalQueryParam = "?";
    }

    public static void pickCardIds(){
        cardId = response.jsonPath().get("id");
        System.out.println("cardId = " + cardId);
        cardIds.add(cardId);
        log.info("-----" + "Card id got : " + cardId +  "-----");
    }


}
