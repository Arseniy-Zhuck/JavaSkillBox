import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        int day = 8;
        int month = 12;
        int year = 1990;
        calendar.set(year,month - 1,day);
        DateFormat dF = new SimpleDateFormat("dd.MM.YYYY - EEE", Locale.ENGLISH);
        Calendar currentCalendar = Calendar.getInstance();
        Date date = calendar.getTime();
        int i = 0;
        while (date.before(currentCalendar.getTime())) {

            System.out.println((i++) + " - " + dF.format(date));
            calendar.add(Calendar.YEAR, 1);
            date = calendar.getTime();
        }
    }
}
