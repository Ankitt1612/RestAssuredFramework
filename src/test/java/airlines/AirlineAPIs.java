package airlines;

import Restutils.RestUtils;
import airlines.pojos.Airline;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class AirlineAPIs {

    public Response createAirLine(Map<String, Object> createAirlinePayload){
        String endPoint = (String) BaseClass.dataFromJsonFile.get("createAirlineEndPoint");
        return RestUtils.performPost(endPoint, createAirlinePayload, new HashMap<>());
    }

    public Response createAirLine(Airline createAirlinePayload){
        String endPoint = (String) BaseClass.dataFromJsonFile.get("createAirlineEndPoint");
        return RestUtils.performPost(endPoint, createAirlinePayload, new HashMap<>());
    }
}
