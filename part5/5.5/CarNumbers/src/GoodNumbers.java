import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public interface GoodNumbers {
    void addGoodNumber(String goodNumber);
    Result find(String number);
    String getInfo();
//.\src\
    static void generateNumbers(GoodNumbers[] goodNumbers) throws IOException {
        ArrayList<String> regionsString = FileReadWrite.readStringsFromFile("src/regions.txt");
        Map<String, String> regions = new HashMap<>();
        for (String regionString : regionsString) {
            String regName = regionString.substring(0,regionString.indexOf("\t"));
            String regNumbers = regionString.substring(regionString.indexOf("\t")+1);
            //System.out.println(regName+"   "+regNumbers);
            regNumbers = regNumbers.trim();
            int index = regNumbers.indexOf(", ");
            while (index != -1) {

                String regNumber = regNumbers.substring(0, index);
                // System.out.println(regNumber + " - " + regName);
                regions.put(regNumber, regName);
                regNumbers = regNumbers.substring(index + 1);
                //System.out.println(regNumbers);
                regNumbers = regNumbers.trim();
                index = regNumbers.indexOf(", ");
            }
            regNumbers = regNumbers.trim();
            regions.put(regNumbers, regName);
        }
        String reg, num, number;
        String[] lettersRus = {"А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х"};
        String[] lettersEng = {"A", "B", "E", "K", "M", "H", "O", "P", "C", "T", "Y", "X"};
        Iterator<Map.Entry<String, String>> iterMap = regions.entrySet().iterator();
        while (iterMap.hasNext()) {
            Map.Entry<String, String> pair = iterMap.next();
            reg = pair.getKey();
            for (int i = 0; i < 10; i++) {
                num = "" + i + i + i;
                for (int j = 0; j < lettersRus.length; j++) {
                    for (int k = 0; k < lettersRus.length; k++) {
                        for (int l = 0; l < lettersRus.length; l++) {
                            number = lettersRus[j] + num + lettersRus[k] + lettersRus[l] + " " + reg;
                            for(GoodNumbers goodNumbersCol : goodNumbers) goodNumbersCol.addGoodNumber(number);
                            number = lettersEng[j] + num + lettersEng[k] + lettersEng[l] + " " + reg;
                            for(GoodNumbers goodNumbersCol : goodNumbers) goodNumbersCol.addGoodNumber(number);
                        }
                    }

                }
            }
        }
    }
}
