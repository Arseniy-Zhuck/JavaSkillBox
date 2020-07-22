import java.util.Set;

public abstract class GoodNumbersSet implements GoodNumbers{
    protected Set<String> goodNumbers;
    protected String info;

    public void addGoodNumber(String goodNumber) {
        goodNumbers.add(goodNumber);
    }

    public Result find(String number) {
        long timeMine;
        boolean resMine;
        long startTime = System.nanoTime();
        resMine = goodNumbers.contains(number);
        long finishTime = System.nanoTime();
        timeMine = finishTime - startTime;
        return new Result(resMine,timeMine);
    }

    @Override
    public String getInfo() {
        return info;
    }
}
