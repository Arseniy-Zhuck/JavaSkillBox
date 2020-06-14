package core.model.list;

import core.conroller.catBehavour.CatState;
import core.model.example.Cat;
import core.view.term.AbstractTerm;

import java.io.IOException;

public abstract class CatCollection {
    protected AbstractTerm gUI;

    public abstract Cat getCurrentCat();
    public abstract boolean hasCurrentCat();
    public abstract void nextCat();
    public abstract void deleteCat(Cat cat);
    public abstract void deleteCat(int catIndex);
    public abstract Cat getCatByIndex(int index);
    public abstract int getIndexByCat(Cat cat);
    public abstract void setCurrentCat(Cat cat);
    public abstract void setCurrentCat(int catIndex);
    public abstract Cat firstCat();
    public abstract int getCatCount();
    public abstract void showCats() throws IOException;
    public abstract void setAllCatsState(CatState catState);

    public void addNewCat(Cat cat) {

    }

    public void initialize() {

    }

    protected abstract void addCat(Cat cat);

}
