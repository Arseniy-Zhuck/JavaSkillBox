public class GoodNumbersListNormal extends GoodNumbersList {
    public GoodNumbersListNormal() {
        super();
        info = "List normal search";
    }

    @Override
    protected void sort() {

    }


    @Override
    public boolean findNumber(String number) {

        return goodNumbers.contains(number);
    }
}
