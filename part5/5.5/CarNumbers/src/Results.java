import java.io.*;
import java.util.ArrayList;

public class Results {
    private final String info;
    private ArrayList<Result> results;
    //private ArrayList<Long> falseResults;
    private ArrayList<String> wholeResults;
    private String filePath;

    public Results(String filePath, String info) throws IOException {
        this.filePath = filePath;
        this.info = info;
        results = new ArrayList<>();
        try {
            wholeResults = FileReadWrite.readStringsFromFile(this.filePath);
        } catch (FileNotFoundException e) {
            wholeResults = new ArrayList<>();
        } catch (IOException e) {
            throw e;
        }
        parseStrings();
    }

    public void addResult(Result result) {
        if (result.isFound()) results.add(0,result);
        else results.add(result);
    }

    private void parseStrings() {
        for (String s : wholeResults) {
            addResult(new Result(s));
        }
    }

    public Result getAverageResult(Boolean isFound) {
        long sum = 0;
        int count = 0;
        for (Result result : results) {
            if (result.isFound() == isFound) {
                sum += result.getTime();
                count++;
            }
        }
        long av = count==0 ? 0 : (long) (sum / count);
        return new Result(isFound,av);
    }

    public String getInfo() {
        return info;
    }

    public void printAllData() {
        System.out.println(info);
        for (Result result : results) System.out.println(result);
    }

    public void saveToFile() {
        wholeResults.clear();
        for (Result result : results) wholeResults.add(result.toString());
        FileReadWrite.writeToFile(wholeResults, filePath);
    }

}
