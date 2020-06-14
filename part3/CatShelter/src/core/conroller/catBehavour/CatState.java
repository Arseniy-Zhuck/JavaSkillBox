package core.conroller.catBehavour;

import core.model.example.Cat;

public interface CatState {


    void setCat(Cat cat);

    public String toStr();
}
