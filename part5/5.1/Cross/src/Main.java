import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.print("Введите количество строк - размер креста: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[][] cross = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) cross[i][j] = "X";
                else if (i + j == n - 1) cross[i][j] = "X";
                else cross[i][j] = " ";
            }
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(cross[i][j]);
            }
            System.out.println();
        }
    }
}
