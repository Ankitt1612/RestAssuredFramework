package airlines.pojos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import utils.DateTime;
import utils.RandomDataGenerator;
import utils.RandomDataTypeNames;

import java.util.stream.Stream;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Airline {
    private String gender = Stream.of("Male","female", "other").findAny().get();
    private int id= Integer.parseInt(RandomDataGenerator.getRandomNumber(8));
    private String name = RandomDataGenerator.getRandomdataFor(RandomDataTypeNames.FirstName);
    private String country = RandomDataGenerator.getRandomdataFor(RandomDataTypeNames.Country);
    private String logo = RandomDataGenerator.getRandomAlphabets(10);
    private String slogan = RandomDataGenerator.getRandomAlphabets(10);
    private String Websites = RandomDataGenerator.getRandomWebsiteName(7);
    private String head_quaters= RandomDataGenerator.getRandomdataFor(RandomDataTypeNames.CityName);
    private String established = String.valueOf(RandomDataGenerator.getNumberBetween(1990, DateTime.getCurrentYear()));

}
