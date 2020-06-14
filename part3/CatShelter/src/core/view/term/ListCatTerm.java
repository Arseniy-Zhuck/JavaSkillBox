package core.view.term;

import core.conroller.CatShelter;
import core.model.list.CatCollection;
import core.view.io.SimpleReading;

import java.io.IOException;

public class ListCatTerm extends AbstractTerm {
    private CatCollection catCollection;



    public ListCatTerm(CatCollection catCollection, CatShelter catShelter) {
        super(catShelter);
        this.catCollection = catCollection;
    }

    @Override
    public void showCats() {
        if (catCollection.getCatCount()==0) strategy.noCats();
        else {
            while (catCollection.hasCurrentCat()) {
                System.out.println(catCollection.getCurrentCat());
                catCollection.nextCat();
            }
        }
    }
}
