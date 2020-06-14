package core.view.term;

import core.conroller.*;

import java.io.IOException;
import static java.lang.System.out;


public class MainProg extends AbstractTerm {

    private MainProg(CatShelter catShelter){
        super(catShelter);
    }

    private String hello() {
        return "Wellcome to our CatShelter \"SkillBox\" with dark and black sides\n" +
                "Here you can give homeless cats and give a new home for one of our cats\n" +
                "We are java developers, so we are very clever\n" +
                "That's why here you can pay for clone of your cat\n" +
                "And here you can free your inner Sharikov\n";
    }



    @Override
    protected void showCats() throws IOException {

    }

    public static void main(String[] args) throws IOException {
        CatShelter catShelter = CatShelter.getInstance();
        MainProg mP = new MainProg(catShelter);
        Strategy sMP = StrategyMainProg.getInstance(mP,catShelter);
        State whiteState = new WhiteState(catShelter);
        catShelter.setState(whiteState);
        catShelter.setMainProg(mP);
        mP.setStrategy(sMP);
        out.println(mP.hello());
        mP.run();
    }
}
