package core.conroller.wholeBehaviour;

import core.conroller.CatShelter;

public class WhiteState implements State {
    private CatShelter catShelter;
    public WhiteState(CatShelter catShelter) {
        this.catShelter = catShelter;
    }
}
