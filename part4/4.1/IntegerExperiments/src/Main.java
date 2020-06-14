import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main
{
    public static void main(String[] args) throws IOException {
        Container container = new Container();
        container.count += 7843;
        System.out.println("Введите число");
        int i = Integer.parseInt((new BufferedReader(new InputStreamReader(System.in))).readLine());
        System.out.println(sumDigits(i));
        System.out.println(sumDigitsStrange(i));
    }

    public static Integer sumDigits(Integer number)
    {
        /* @TODO: write code here */
        int a = number;
        int sum = 0;
        while (a>0) {
            sum += (a % 10);
            a /= 10;
        }
        return sum;
    }

    public static Integer sumDigitsStrange(Integer number)
    {
        /* @TODO: write code here */
        String s = number.toString();
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += Character.getNumericValue(s.charAt(i));
        }
        return sum;
    }
}
