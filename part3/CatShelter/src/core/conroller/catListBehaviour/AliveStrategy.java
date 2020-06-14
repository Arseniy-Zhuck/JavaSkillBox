package core.conroller.catListBehaviour;

import core.conroller.Strategy;
import core.view.term.ListCatTerm;

public class AliveStrategy implements Strategy {
    private ListCatTerm listCatTerm;

    public AliveStrategy(ListCatTerm listCatTerm) {
        this.listCatTerm = listCatTerm;
    }

    @Override
    public String showCommands() {

        return "So, what do you want?\\n\" +\n" +
                "                \"1. Give us a new cat\\n\" +\n" +
                "                \"2. Choose one cat\\n\" +\n" +
                "                \"3. Take one cat\\n\" +\n" +
                "                \"4. Get to the other side\\n\" +\n" +
                "                \"5. Return to previous";
    }

    @Override
    public void doJob(int choice) {

    }

    @Override
    public void noCats() {
        System.out.println("We have no cats in our Shelter now");
    }
}
