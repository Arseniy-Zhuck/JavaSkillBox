package core.model.list;

import core.conroller.catBehavour.CatState;
import core.model.example.Cat;

import java.util.ArrayList;

public class CatArrayList extends CatCollection {
    private ArrayList<Cat> cats;
    private int currentCatIndex;


    public CatArrayList(int maxCount) {
        cats = new ArrayList<Cat>();
        currentCatIndex = -1;
    }

    @Override
    public Cat getCurrentCat() {
        return cats.get(currentCatIndex);
    }

    @Override
    public boolean hasCurrentCat() {
        return (currentCatIndex<cats.size())&&(cats.size()>0);
    }

    @Override
    public void nextCat() {
        currentCatIndex++;
     }

    @Override
    public void addCat(Cat cat) {
        cats.add(cat);
        setCurrentCat(cat);
    }

    @Override
    public void deleteCat(Cat cat) {
        setCurrentCat(firstCat());
        cats.remove(cat);
    }

    @Override
    public void deleteCat(int catIndex) {
        setCurrentCat(catIndex);
        cats.remove(catIndex);
    }

    @Override
    public Cat getCatByIndex(int index) {
        return cats.get(index);
    }

    @Override
    public int getIndexByCat(Cat cat) {
        return cats.indexOf(cat);
    }

    @Override
    public void setCurrentCat(Cat cat) {
        currentCatIndex = cats.indexOf(cat);
    }

    @Override
    public void setCurrentCat(int catIndex) {
        currentCatIndex = catIndex;
    }

    @Override
    public Cat firstCat() {
        setCurrentCat(0);
        return cats.get(0);
    }

    @Override
    public int getCatCount() {
        return cats.size();
    }

    @Override
    public void showCats() {

    }

    @Override
    public void setAllCatsState(CatState catState) {

    }

}
