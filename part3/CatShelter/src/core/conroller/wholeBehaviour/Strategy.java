package core.conroller.wholeBehaviour;

import core.view.term.AbstractTerm;

import java.io.IOException;

public interface Strategy {

    public String showCommands();
    public void doJob(int choice) throws IOException;
    public void noCats();

}
