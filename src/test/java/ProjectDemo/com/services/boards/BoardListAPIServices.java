package ProjectDemo.com.services.boards;

import ProjectDemo.com.services.ApiBaseMethods;
import com.utilities.FakerDataCreator;
import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.Random;

import static ProjectDemo.com.services.ApiBaseMethods.*;

@Log4j2
public class BoardListAPIServices extends BoardAbstractClass {
    private static void setFinalUrlForGetListIds(){
        setUrlQueryParameter("key", key);
        setUrlQueryParameter("token", token);
        finalQueryParam = removeLastCharFromUrl();
        finalUrl = baseUrlTrello + "boards/" + boardId + "/lists" + finalQueryParam;
    }

    public static void sendGetRequestForGetListIds() {
        setFinalUrlForGetListIds();
        response = ApiBaseMethods.getRequest(finalUrl);
        response.prettyPrint();
        finalQueryParam = "?";
    }

    public static void setListId(){
        List<String> listIds = response.jsonPath().getList("id");
        System.out.println("listIds = " + listIds);
        Random random = new Random();
        int randomIndex = random.nextInt(listIds.size()-1);
        listId = listIds.get(randomIndex);
        log.info("-----" + "List id got : " + listId +  "-----");
    }


}
