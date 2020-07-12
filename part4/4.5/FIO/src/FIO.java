import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class FIO {
    public static void main(String[] args) throws IOException {
        System.out.println("Введите строку");
        String s = (new BufferedReader(new InputStreamReader(System.in))).readLine();
        String fullName = s.trim();
        fullName = fullName.replaceAll("\\s*-\\s*","-");
        System.out.println(fullName);
        String[] ar;
        //ar = s.trim().split("\\s+", 3);
        //System.out.println("Фамилия: " + ar[0]);
        //System.out.println(Pattern.compile("([А-ЯЁ&&[^ЪЬЫ]][а-яё]+)||([А-ЯЁ&&[^ЪЬЫ]][а-яё]+-[А-ЯЁ&&[^ЪЬЫ]][а-яё]+)").matcher(ar[0].matches());
        //System.out.println("Имя: " + ar[1]);
        //System.out.println("Отчество: " + ar[2]);

        if(!Pattern.compile("(([А-ЯЁ&&[^ЪЬЫ]][а-яё]+)||([А-ЯЁ&&[^ЪЬЫ]][а-яё]+-[А-ЯЁ&&[^ЪЬЫ]][а-яё]+))\\s" +
                "(([А-ЯЁ&&[^ЪЬЫ]][а-яё]+)||([А-ЯЁ&&[^ЪЬЫ]][а-яё]+-[А-ЯЁ&&[^ЪЬЫ]][а-яё]+))\\s" +
                "(([А-ЯЁ&&[^ЪЬЫ]][а-яё]+)||([А-ЯЁ&&[^ЪЬЫ]][а-яё]+\\s[а-яё&&[^ъьы]][а-яё]+))$").matcher(fullName).matches())
            System.out.println("Its all bad");
        else {
            ar = fullName.trim().split("\\s+", 3);
            System.out.println("Фамилия: " + ar[0]);
            System.out.println("Имя: " + ar[1]);
            System.out.println("Отчество: " + ar[2]);
        }
    }

}
