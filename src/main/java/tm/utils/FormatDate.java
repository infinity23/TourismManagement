package tm.utils;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

@Component
public class FormatDate {
    Calendar calendar = Calendar.getInstance(Locale.CHINA);
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public String now() {
        return df.format(calendar.getTime());
    }
}
