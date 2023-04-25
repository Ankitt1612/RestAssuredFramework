package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.Map;

public class JsonUtils {

    private static ObjectMapper objectmapper = new ObjectMapper();

    public JsonUtils() throws FileNotFoundException {
    }

    public static Map<String, Object> getJsondataAsMap(String jsonFileName) throws IOException {
        String completeFilePath = System.getProperty("user.dir")+"/src/test/resources/" + jsonFileName;
        Map<String, Object> data = objectmapper.readValue(new File(completeFilePath), new TypeReference<>(){});
        return data;



    }
}
