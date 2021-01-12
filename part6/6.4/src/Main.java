import company.Company;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    public static Calendar currentDate = new GregorianCalendar();

    public static void main(String[] args) {
        Calendar cal1 = new GregorianCalendar();
        cal1.set(2020,1,5);

        Calendar cal2 = new GregorianCalendar();
        cal2.set(2020, 1, 5);
        System.out.println(cal1.equals(cal2));
        Company company = new Company("Company", 50000.0);
    }
}
