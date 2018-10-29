package hello.world.server.service;

import javax.inject.Singleton;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Singleton
public class HomeService {

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    public String getSystemTime() {
        return new Date().toString();
    }

    public long getDaysBeetweenDates(String first, String second) throws ParseException {
        return (getDate(second).getTime() - getDate(first).getTime()) / 3600000 / 24;
    }

    private Date getDate(String date) throws ParseException {
        return format.parse(date);
    }
}
