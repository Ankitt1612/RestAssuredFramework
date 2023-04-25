package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTime {



    public static int getCurrentYear() {
        return LocalDateTime.now().getYear();


    }
}
