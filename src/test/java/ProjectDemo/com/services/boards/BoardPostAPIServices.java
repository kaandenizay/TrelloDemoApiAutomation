package ProjectDemo.com.services.boards;

import ProjectDemo.com.services.ApiBaseMethods;
import com.utilities.FakerDataCreator;
import lombok.extern.log4j.Log4j2;

import static ProjectDemo.com.services.ApiBaseMethods.*;

@Log4j2
public class BoardPostAPIServices extends BoardAbstractClass {

    private static void setFinalUrlForBoardCreate(){
        faker = new FakerDataCreator();
        String name = faker.wordFromFaker();
        setUrlQueryParameter("name", name);
        setUrlQueryParameter("key", key);
        setUrlQueryParameter("token", token);
        finalQueryParam = removeLastCharFromUrl();
        finalUrl = baseUrlTrello + "boards/" + finalQueryParam;
        log.info("-----" + "Board name is : " + name +  "-----");
    }

    public static void sendPostRequestForBoardCreate() {
        setFinalUrlForBoardCreate();
        response = ApiBaseMethods.postRequest(finalUrl, "");
        response.prettyPrint();
        finalQueryParam = "?";
    }

    public static void setBoardId(){
        boardId = response.jsonPath().get("id");
        log.info("-----" + "Board id got : " + boardId +  "-----");
    }

}
