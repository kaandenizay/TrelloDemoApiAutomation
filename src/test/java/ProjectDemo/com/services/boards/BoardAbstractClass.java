package ProjectDemo.com.services.boards;

import ProjectDemo.com.services.ApiBaseMethods;

import java.util.ArrayList;
import java.util.List;

public abstract class BoardAbstractClass {

    static String finalQueryParam = "?";
    static String boardId = "";
    public static String listId = "";

    static void setUrlQueryParameter(String queryParam, String value) {
        finalQueryParam += queryParam + "=" + value + "&";
    }

    static String removeLastCharFromUrl() {
        return finalQueryParam = finalQueryParam.substring(0, finalQueryParam.length() - 1);
    }
}
