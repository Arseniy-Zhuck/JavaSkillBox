import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Введите строку");
        String startS = (new BufferedReader(new InputStreamReader(System.in))).readLine();
        String s = startS.trim();
        String surname = s.substring(0,s.indexOf(' '));
        startS = s.substring(s.indexOf(' '));
        s = startS.trim();
        String name = s.substring(0, s.indexOf(" "));
        String lastname = s.substring(s.indexOf(" ")).trim();
        System.out.println("Фамилия: " + surname);
        System.out.println("Имя: " + name);
        System.out.println("Отчество: " + lastname);
    }
}
