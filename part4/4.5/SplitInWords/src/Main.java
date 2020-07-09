import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File(".\\src\\EnglishText.txt");
        //создаем объект FileReader для объекта File
        FileReader fr = new FileReader(file);
        //создаем BufferedReader с существующего FileReader для построчного считывания
        BufferedReader reader = new BufferedReader(fr);
        // считаем сначала первую строку
        String englishText = "";
        String line = reader.readLine();
        while (line != null) {
            englishText += line;
            line = reader.readLine();
        }
        String[] words = englishText.split("\\s*[\\(,.–\\-!:;\\)]+\\s*|\\s+");
        for (String word : words)
            System.out.println(word);
        

    }
}
