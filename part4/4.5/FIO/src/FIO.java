import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class FIO {
    public static void main(String[] args) throws IOException {
        System.out.println("Введите строку");
        String s = (new BufferedReader(new InputStreamReader(System.in))).readLine();
        String fullName = s.trim();
        String[] ar;
        if(!Pattern.compile("[А-ЯЁ&&[^ЪЬЫ]][а-яё]+\\s[А-ЯЁ&&[^ЪЬЫ]][а-яё]+\\s" +
                "[А-ЯЁ&&[^ЪЬЫ]][а-яё]+$").matcher(fullName).matches())
            System.out.println("Its all bad");
        else {
            ar = s.trim().split("\\s+");
            System.out.println("Фамилия: " + ar[0]);
            System.out.println("Имя: " + ar[1]);
            System.out.println("Отчество: " + ar[2]);
        }
    }

}
