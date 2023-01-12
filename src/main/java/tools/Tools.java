package tools;

import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Tools {
    public static long YearDifference(Date date)
    {
        LocalDate start = date.toLocalDate();
        LocalDate stop = LocalDate.now();
        long yearBetween = ChronoUnit.YEARS.between( start , stop );
        return yearBetween;
    }
}
