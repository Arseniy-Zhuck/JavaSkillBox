import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.System.*;
import java.lang.Math;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bR = new BufferedReader(new InputStreamReader(in));
        System.out.println("Please enter the boxes count");
        int box = Integer.parseInt(bR.readLine());
        int container = box / 27;
        if (box % 27 > 0) container++;
        int truck = container / 12;
        if (container % 12 > 0) truck++;
        out.println("Вам нужно " + container + " контейнеров и " + truck + " грузовиков");;
        int boxIndex = 0;
        int containerIndex = 0;
        int truckIndex = 0;
        for (int i = 0; i < box; i++) {
            boxIndex++;
            if (boxIndex % 27 == 1) containerIndex++;
            if ((containerIndex % 12 == 1)&&(boxIndex % (12*27) ==1)) {
                truckIndex++;
                out.println("Грузовик "+truckIndex);
            }
            if (boxIndex % 27 == 1) out.println("Контейнер "+containerIndex);
            out.println("Ящик "+ boxIndex);
        }
    }
}

