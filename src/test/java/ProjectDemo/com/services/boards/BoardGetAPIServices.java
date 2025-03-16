package ProjectDemo.com.services.boards;

import ProjectDemo.com.pojo.BoardsPOJO;
import ProjectDemo.com.services.ApiBaseMethods;
import lombok.extern.log4j.Log4j2;

import static ProjectDemo.com.services.ApiBaseMethods.*;

@Log4j2
public class BoardGetAPIServices extends BoardAbstractClass {

    private static void setFinalUrlForBoardRead(){
        String idBoard = boardId;
        setUrlQueryParameter("key", key);
        setUrlQueryParameter("token", token);
        finalQueryParam = removeLastCharFromUrl();
        finalUrl = baseUrlTrello + "boards/" + idBoard + finalQueryParam;
    }



    public static void sendGetRequestForBoardRead() {
        setFinalUrlForBoardRead();
        response = ApiBaseMethods.getRequest(finalUrl);
        log.info("----- Read board id = " + boardId + "-----");
        response.prettyPrint();
        finalQueryParam = "?";
    }

    public static void writeDataToJSON(){
        BoardsPOJO boardsPOJO = response.getBody().as(BoardsPOJO.class);
        System.out.println("id = " + boardsPOJO.getId());
        System.out.println("name = " + boardsPOJO.getName());
        trelloJSONMap.put("Board Id", boardsPOJO.getId());
        trelloJSONMap.put("Board Name", boardsPOJO.getName());
    }


}
