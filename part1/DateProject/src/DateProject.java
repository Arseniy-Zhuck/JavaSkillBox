import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateProject {
    public static void main(String[] args) {
        DateFormat dateFormat= new SimpleDateFormat("dd.MM.yy H:mm");
        System.out.println(dateFormat.format(new Date()));
    }
}
