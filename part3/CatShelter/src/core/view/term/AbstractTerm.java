package core.view.term;

import core.conroller.CatShelter;
import core.conroller.wholeBehaviour.Strategy;
import core.view.io.SimpleReading;

import java.io.IOException;

import static java.lang.System.out;

public abstract class AbstractTerm {

    protected CatShelter catShelter;
    protected Strategy strategy;

    public AbstractTerm(CatShelter catShelter) {
        this.catShelter = catShelter;
    }

    private int getChoice() throws IOException {
        return SimpleReading.readInteger();
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    protected abstract void showCats() throws IOException;

    protected String showCommands() {
        return strategy.showCommands();
    }

    protected void doJob(int choice) {
        strategy.doJob(choice);
    }

    public void run() throws IOException {
        showCats();
        out.println(showCommands());
        doJob(getChoice());
    }
}
