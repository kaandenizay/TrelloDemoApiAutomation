package ProjectDemo.com.junitTests;

import ProjectDemo.com.services.ApiBaseMethods;
import ProjectDemo.com.services.boards.BoardDeleteAPIServices;
import ProjectDemo.com.services.boards.BoardGetAPIServices;
import ProjectDemo.com.services.boards.BoardListAPIServices;
import ProjectDemo.com.services.boards.BoardPostAPIServices;
import ProjectDemo.com.services.cards.CardDeleteAPIServices;
import ProjectDemo.com.services.cards.CardGetAPIServices;
import ProjectDemo.com.services.cards.CardPostAPIServices;
import ProjectDemo.com.services.cards.CardPutAPIServices;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@Log4j2
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TrelloTests extends BaseTests{



    @BeforeEach
    public void initializePages(){

    }

    @Test
    @DisplayName("Search Product, Add To Cart and Clear Cart")
    void searchProduct(){
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("-----" + methodName +  " test started-----");
        BoardPostAPIServices.sendPostRequestForBoardCreate();
        log.info("-----" + "Board created" + "-----");
        BoardPostAPIServices.setBoardId();

        BoardGetAPIServices.sendGetRequestForBoardRead();
        BoardGetAPIServices.writeDataToJSON();

        BoardListAPIServices.sendGetRequestForGetListIds();
        BoardListAPIServices.setListId();

        CardPostAPIServices.sendPostRequestForCardCreate();
        log.info("-----" + "Card created" + "-----");
        CardPostAPIServices.pickCardIds();
        CardGetAPIServices.sendGetRequestForCardRead();
        CardGetAPIServices.writeDataToJSON("1");

        CardPostAPIServices.sendPostRequestForCardCreate();
        log.info("-----" + "Card created" + "-----");
        CardPostAPIServices.pickCardIds();
        CardGetAPIServices.sendGetRequestForCardRead();
        CardGetAPIServices.writeDataToJSON("2");

        CardPutAPIServices.sendPutRequestForCardUpdate();
        log.info("-----" + "Card updated" + "-----");

        CardDeleteAPIServices.sendDeleteRequestForCardDelete();
        log.info("-----" + "Cards are deleted" + "-----");

        BoardDeleteAPIServices.sendDeleteRequestForBoardDelete();
        log.info("-----" + "Board is deleted" + "-----");

        ApiBaseMethods.createJSONForTrelloData();
        log.info("-----" + methodName +  " test end-----");
    }
}
