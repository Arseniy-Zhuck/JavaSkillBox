import java.io.*;
import java.util.ArrayList;

public class FileReadWrite {

    public static ArrayList<String> readStringsFromFile(String filePath) throws IOException {
        ArrayList<String> result = new ArrayList<>();
        File file;
        FileReader fr;
        BufferedReader reader;
        try {
            file = new File(filePath);
            //создаем объект FileReader для объекта File
            fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            reader = new BufferedReader(fr);
            // считаем сначала первую строку
        } catch (FileNotFoundException e) {
            System.out.println("File + " + filePath + " not found");
            throw e;
        }
        String line = reader.readLine();
        while (line != null) {
            result.add(line);
            line = reader.readLine();
        }
        return result;
    }

    public static void writeToFile(ArrayList<String> list, String filePath) {
        try(FileWriter writer = new FileWriter(filePath, false))
        {
            // запись всей строки
            for(String text : list) {
                writer.write(text);
                // запись по символам
                writer.append('\n');

            }
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }


}
