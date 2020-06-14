package core.conroller.commandsBehaviuor;

import core.conroller.CatShelter;
import core.conroller.wholeBehaviour.Strategy;
import core.view.term.AbstractTerm;

import java.io.IOException;

import static java.lang.System.out;
import static jdk.internal.vm.PostVMInitHook.run;

public class StrategyMainProg implements Strategy {
    private AbstractTerm gUI;
    private CatShelter catShelter;


    private StrategyMainProg(AbstractTerm gUI,CatShelter catShelter) {
        this.gUI = gUI;
        this.catShelter = catShelter;
    }



    public static Strategy getInstance(AbstractTerm Gui, CatShelter catShelter) {
        return new StrategyMainProg(Gui,catShelter);
    }

    @Override
    public String showCommands() {
        return "So, what do you want?\n" +
                "1. See all our cats\n" +
                "2. See all given cats\n" +
                "3. Visit the place of memory\n" +
                "4. Get to the other side\n" +
                "5. Leave us";
    }

    @Override
    public void doJob(int choice) throws IOException {
        switch (choice) {
            case 1: catShelter.showOurCats(); break;
            case 2: break;
            case 3: break;
            case 4: break;
            case 5: break;
            default:
                out.println("Wrong command");
                run();
        }

    }

    @Override
    public void noCats() {

    }
}
