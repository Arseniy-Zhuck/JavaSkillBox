import java.util.ArrayList;

public abstract class GoodNumbersList implements GoodNumbers{
    protected ArrayList<String> goodNumbers;
    protected String info;

    public GoodNumbersList() {
        goodNumbers = new ArrayList<>();
    }
    @Override
    public void addGoodNumber(String goodNumber) {
        goodNumbers.add(goodNumber);
    }

    @Override
    public String getInfo() {
        return info;
    }

    protected abstract void sort();

    protected abstract boolean findNumber(String number);
    @Override

    public Result find(String number) {
        long timeMine;
        boolean resMine;
        sort();
        long startTime = System.nanoTime();

        resMine = findNumber(number);
        long finishTime = System.nanoTime();
        timeMine = finishTime - startTime;
        return new Result(resMine,timeMine);
    }

}
