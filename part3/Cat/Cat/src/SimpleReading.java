

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SimpleReading {
    public static Integer readInteger() throws IOException {
        return Integer.parseInt((new BufferedReader(new InputStreamReader(System.in))).readLine());
    }

    public static Double readDouble() throws IOException {
        return Double.parseDouble((new BufferedReader(new InputStreamReader(System.in))).readLine());
    }

    public static String readString() throws IOException {
        return (new BufferedReader(new InputStreamReader(System.in))).readLine();
    }

}
