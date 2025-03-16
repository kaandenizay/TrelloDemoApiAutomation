package ProjectDemo.com.services.boards;

import ProjectDemo.com.services.ApiBaseMethods;
import lombok.extern.log4j.Log4j2;

import static ProjectDemo.com.services.ApiBaseMethods.*;
import static ProjectDemo.com.services.boards.BoardAbstractClass.boardId;

@Log4j2
public class BoardDeleteAPIServices extends BoardAbstractClass {

    private static void setFinalUrlForBoardDelete(){
        String idBoard = boardId;
        setUrlQueryParameter("key", key);
        setUrlQueryParameter("token", token);
        finalQueryParam = removeLastCharFromUrl();
        finalUrl = baseUrlTrello + "boards/" + idBoard + finalQueryParam;
    }



    public static void sendDeleteRequestForBoardDelete() {
        setFinalUrlForBoardDelete();
        response = ApiBaseMethods.deleteRequest(finalUrl);
        log.info("----- Deleted board id = " + boardId + "-----");
        response.prettyPrint();
        finalQueryParam = "?";
    }


}
