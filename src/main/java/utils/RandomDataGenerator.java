package utils;

import net.datafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

public class RandomDataGenerator {

    public static Faker faker = new Faker();

    public static String getRandomdataFor(RandomDataTypeNames dataTypeNames) {

        switch (dataTypeNames) {
            case FirstName:
                return faker.name().firstName();
            case LastName:
                return faker.name().lastName();
            case Country:
                return faker.address().country();
            case CityName:
                return faker.address().cityName();
            default:
                return "Datatype Name is not correct";
        }


    }

    public static String getRandomNumber(int count) {
        return faker.number().digits(count);
    }

    public static String getRandomAlphabets(int count){
        return RandomStringUtils.randomAlphabetic(count);
    }

    public static int getNumberBetween(int min, int max){
        return faker.number().numberBetween(min, max);
    }

    public static String getRandomWebsiteName(int count){
        return RandomStringUtils.randomAlphabetic(count);
    }
}




