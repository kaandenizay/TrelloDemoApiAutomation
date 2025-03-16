package com.utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class JSONProcessManager {

    static final String filePath = Paths.get(System.getProperty("user.dir"), "src", "test", "resources", "testData", "TrelloSerializedData.json").toString();
    public static Object getValue(String fileName, String type, String key){
        Object value = null;

        try {
            String content = new String(Files.readAllBytes(
                    Paths.get(System.getProperty("user.dir"), "src", "test", "resources", "testData", fileName)));

            JSONObject jsonObject = new JSONObject(content);

            switch (type){
                case "string":
                    value = jsonObject.getString(key);
                    break;
                case "int":
                    value = jsonObject.getInt(key);
                    break;
                case "map":
                    value = jsonObject.getJSONObject(key).toMap();
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return value;
    }

    public static void createFile(Map<String,String> trelloTestData){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(filePath), trelloTestData);
            System.out.println("Map has been written to JSON file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String requestBody(Object object){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
