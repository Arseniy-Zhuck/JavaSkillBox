import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class PhoneCheck {
    public static String removeExcess(String phone) {
        return phone.replaceAll("[^0-9]","");
    }

    public static boolean checkPhone(String figures) {
        return Pattern.compile("[7-8]?[0-9]{10}").matcher(figures).matches();
    }

    public static String adjustFormat(String phoneNumber) {
        return String.format("7%s", phoneNumber.substring(phoneNumber.length() - 10));
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Please, enter your mobile phone in any way you like");
        String mayBePhoneNumber = (new BufferedReader(new InputStreamReader(System.in))).readLine();
        String figures = removeExcess(mayBePhoneNumber);
        //System.out.println(figures);
        if (!checkPhone(figures)) System.out.println("Неверный формат номера");
        else System.out.println(adjustFormat(figures));

    }
}
