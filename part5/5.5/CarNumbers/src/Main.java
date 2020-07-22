import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {




    public static void main(String[] args) throws IOException {

        GoodNumbers[] containers = {new GoodNumbersListNormal(),
                                    new GoodNumberListBinary(),
                                    new GoodNumbersHashSet(),
                                    new GoodNumbersTreeSet()};
        try {
            GoodNumbers.generateNumbers(containers);
        } catch (FileNotFoundException e) {
          System.exit(0);
        } catch (IOException e) {
            System.out.println("Problems with regions reading, try again");
            System.exit(0);
        }

        Results[] results = {       new Results("src/listNormal.txt", "List normal search"),
                                    new Results("src/listBinary.txt", "List binary search"),
                                    new Results("src/hashSet.txt", "HashSet search"),
                                    new Results("src/treeSet.txt", "TreeSet search")};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("Write car number in format X000XX REG  or write command");
            String s = br.readLine();
            if (s.equals("QUIT")) {
                for (int i = 0; i < 4; i++) {
                    results[i].saveToFile();
                }
                break;
            }
            if (s.equals("LIST")) {
                for (Results result : results) {
                    System.out.println(result.getInfo() + " " + result.getAverageResult(true));
                    System.out.println(result.getInfo() + " " + result.getAverageResult(false));
                }
                String text = "";
                do {
                    System.out.println("Watch whole info about: NORMAL, BINARY, HASHSET, TREESET");
                    text = br.readLine();
                    if (text.equals("EXIT")) break;
                    if (text.equals("NORMAL")) {
                        results[0].printAllData();
                        continue;
                    }
                    if (text.equals("BINARY")) {
                        results[1].printAllData();
                        continue;
                    }
                    if (text.equals("HASHSET")) {
                        results[2].printAllData();
                        continue;
                    }
                    if (text.equals("TREESET")) {
                        results[3].printAllData();
                        continue;
                    }
                    System.out.println("Unknown command");
                } while (text != "EXIT");
                continue;
            }
            for (int i = 0; i < 4; i++) {
                Result result = containers[i].find(s);
                System.out.println(containers[i].getInfo() + result);
                results[i].addResult(result);
            }

        }




    }
}
