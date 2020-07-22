import java.util.Collections;

public class GoodNumberListBinary extends GoodNumbersList {

    public GoodNumberListBinary(){
        super();
        info = "List binary search";
    }

    @Override
    protected void sort() {
        Collections.sort(goodNumbers);
    }

    public boolean findNumber(String number) {

        return Collections.binarySearch(goodNumbers, number)>=0;
        //resMine = goodNumbers.contains(number);

    }
}
