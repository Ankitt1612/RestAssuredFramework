package airlines;

import utils.JsonUtils;

import java.io.IOException;
import java.util.Map;

public class BaseClass {

    public static Map<String, Object> dataFromJsonFile;

    static {
        String env = System.getProperty("env")==null ? "QA": System.getProperty("env");
        try {
            dataFromJsonFile = JsonUtils.getJsondataAsMap(env+"/AirlinesApiData.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
