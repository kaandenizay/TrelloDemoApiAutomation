package ProjectDemo.com.services;

import com.utilities.ConfigurationReader;
import com.utilities.FakerDataCreator;
import com.utilities.JSONProcessManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.path.json.exception.JsonPathException;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

@Log4j2
public class ApiBaseMethods {

    public static Response response;
    public static String finalUrl;
    public static final String baseUrlTrello = ConfigurationReader.getProperty("trello.url");
    public static final String key = ConfigurationReader.getProperty("trello.key");
    public static final String token = ConfigurationReader.getProperty("trello.token");
    public static FakerDataCreator faker;
    public static Map<String, String> trelloJSONMap = new HashMap<>();

    public static Response getRequest(String finalUrl) {
        defaultParser = Parser.JSON;
        baseURI = finalUrl;
        Response r;
        System.out.println("baseURI: " + baseURI);
        try {
             r = given().headers("Content-Type", " application/json")
                    .when()
                    .get(baseURI)
                    .then()
                    .statusCode(200)
                    .and()
                    .extract().response();
        } catch (Exception e) {
            throw new JsonPathException("Failed to parse the JSON document", e);
        }
        RestAssured.reset();
        return r;
    }

    public static Response postRequest(String finalUrl, String body) {
        defaultParser = Parser.JSON;
        baseURI = finalUrl;
        System.out.println("baseURI : " + baseURI);
        System.out.println("body : " + body);
        try {
            response = given().
                    header("Content-Type", "application/json").
                    header("Accept", "application/json").
                    body(body).
                    when().log().all()
                    .post(baseURI).
                    then()
                    .statusCode(200)
                    .log().all()
                    .extract().response();

        } catch (Exception e) {
            throw new JsonPathException("Failed to parse the JSON document", e);
        }
          RestAssured.reset();
        return response;

    }

    public static Response putRequest(String endpoint, String body) {
        defaultParser = Parser.JSON;
        baseURI = endpoint;
        Response r;
        System.out.println("baseURI: " + baseURI);
        try {
            r = given().
                    header("Content-Type", "application/json").
                    header("Accept", "application/json").
                    body(body)
                    .when().log().all()
                    .put(baseURI)
                    .then()
                    .statusCode(200)
                    .log().all()
                    .contentType(ContentType.JSON)
                    .extract().response();
        } catch (Exception e) {
            throw new JsonPathException("Failed to parse the JSON document", e);
        }
        RestAssured.reset();
        return r;
    }

    public static Response deleteRequest(String endpoint) {
        defaultParser = Parser.JSON;
        baseURI = endpoint;
        Response r;
        System.out.println("baseURI: " + baseURI);
        try {
            r = given().headers("Content-Type", "application/json")
                    .when()
                    .delete(baseURI)
                    .then()
                    .statusCode(200)
                    .and()
                    .log().all()
                    .contentType(ContentType.JSON)
                    .extract().response();
        } catch (Exception e) {
            throw new JsonPathException("Failed to parse the JSON document", e);
        }
        RestAssured.reset();
        return r;

    }

    public static void createJSONForTrelloData(){
        JSONProcessManager.createFile(trelloJSONMap);
    }

}