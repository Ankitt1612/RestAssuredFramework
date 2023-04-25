package airlines;

import airlines.pojos.Airline;
import utils.DateTime;
import utils.RandomDataGenerator;
import utils.RandomDataTypeNames;
import net.datafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.HashMap;
import java.util.Map;

public class Payloads {

    public static String getCreateAirlinePayloadFromString(String name, String country, String logo, String slogan, String head_quaters, String Websites, String established) {
        String payload = "{\n" +
                "  \"name\": \"" + name + "\",\n" +
                "  \"country\": \"" + country + "\",\n" +
                "  \"logo\": \"" + logo + "\",\n" +
                "  \"slogan\": \"" + slogan + "\",\n" +
                "  \"head_quaters\": \"" + head_quaters + "\",\n" +
                "  \"website\": \"" + Websites + "\",\n" +
                "  \"established\": \"" + established + "\"\n" +
                "}";
        return payload;
    }


    public static Map<String, Object> getCreateAirlinePayloadFromMap(String name, String country, String logo, String slogan, String head_quaters, String Websites, String established) {
        Map<String, Object> mapPayload = new HashMap<>();
        mapPayload.put("name", name);
        mapPayload.put("country", country);
        mapPayload.put("logo", logo);
        mapPayload.put("slogan", slogan);
        mapPayload.put("head_quaters", head_quaters);
        mapPayload.put("Websites", Websites);
        mapPayload.put("established", established);
        return mapPayload;
    }

    public static Map<String, Object> getCreateAirlinePayloadFromFaker() {
        Map<String, Object> mapPayload = new HashMap<>();
        Faker faker = new Faker();
        mapPayload.put("id", RandomDataGenerator.getRandomNumber(8));
        mapPayload.put("name", RandomDataGenerator.getRandomdataFor(RandomDataTypeNames.FirstName));
        mapPayload.put("country", RandomDataGenerator.getRandomdataFor(RandomDataTypeNames.Country));
        mapPayload.put("logo", RandomDataGenerator.getRandomAlphabets(10));
        mapPayload.put("slogan", RandomDataGenerator.getRandomAlphabets(10));
        mapPayload.put("head_quaters", RandomDataGenerator.getRandomdataFor(RandomDataTypeNames.CityName));
        mapPayload.put("Websites", "https://" + RandomDataGenerator.getRandomAlphabets(10) + ".com");
        mapPayload.put("established", RandomDataGenerator.getNumberBetween(1990, DateTime.getCurrentYear()));
        return mapPayload;
    }

    public static Airline getCreateAirlinePayloadFromPojo() {
        return Airline
                .builder()
                .id(Integer.parseInt(RandomDataGenerator.getRandomNumber(8)))
                .name(RandomDataGenerator.getRandomdataFor(RandomDataTypeNames.FirstName))
                .country(RandomDataGenerator.getRandomdataFor(RandomDataTypeNames.Country))
                .logo(RandomDataGenerator.getRandomAlphabets(10))
                .slogan(RandomDataGenerator.getRandomAlphabets(10))
                .head_quaters(RandomDataGenerator.getRandomdataFor(RandomDataTypeNames.CityName))
                .Websites(RandomDataGenerator.getRandomAlphabets(10) + ".com")
                .established(String.valueOf(RandomDataGenerator.getNumberBetween(1990, DateTime.getCurrentYear())))
                .build();


    }

}
