package core.model.example;

import core.conroller.catBehavour.AlienCat;
import core.conroller.catBehavour.CatAliveOur;
import core.conroller.catBehavour.CatDead;
import core.conroller.catBehavour.CatState;

import java.util.Date;

public class Cat
{
    private static double minWeight = 1000.0;
    private static double maxWeight = 9000.0;

    private double originWeight;
    private double weight;
    private String name;
    private boolean isDead;
    private CatState state;
    private boolean isOur;
    private String owner;
    private String address;
    private Date deathDate;
    private Date giveDate;

    // static privated methods

    //static public methods
    public static void giveCatToShelter(Cat cat) {
        cat.setOur();
    }

    public static Cat getTemporaryCAt(double weight, String name) {
        return new Cat(weight,name);
    }

    public static Cat getHomelessCat(double weight) {
        return new Cat(weight);
    }

    public static Cat getOurCat(double weight, String name) {
        Cat cat = new Cat(weight,name);
        cat.setOur();
        return cat;
    }

    public static Cat getDeadCat(String name, Date deathDate) {
        Cat cat = new Cat(name,deathDate,new CatDead());
        cat.isOur = true;
        cat.isDead = true;
        return cat;
    }

    public static Cat getGivenCat(String name, Date giveDate, String owner, String address) {
        Cat cat = new Cat(name,giveDate,owner,address,new AlienCat());
        cat.isOur = false;
        cat.isDead = false;
        return cat;
    }

    // private constructors
    private Cat(String name, Date giveDate, String owner, String address, CatState state){
        setName(name);
        this.giveDate = giveDate;
        this.owner = owner;
        this.address = address;
        this.setState(state);
    }

    private Cat(String name, Date deathDate, CatState state){
        setName(name);
        this.deathDate = deathDate;
        this.setState(state);
    }

    private Cat(double weight, String name, CatState state) {
        this(weight,name);
        this.setState(state);
    }

    private Cat(String name) {
        this(1500.0 + 3000.0 * Math.random(),name);
    }

    private Cat(double weight, String name){
        this(weight);
        setName(name);
    }

    private Cat(double weight){
        this.weight = weight;
        originWeight = weight;
    }

    private void setState(CatState state){
        this.state = state;
        this.state.setCat(this);
    }

    private void setOur() {
        setState(new CatAliveOur());
        this.isDead = false;
        this.isOur = true;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void meow() {
        weight = weight - 1;
        System.out.println("Meow");
    }

    public void feed(Double amount)
    {
        weight = weight + amount;
    }

    public void drink(Double amount)
    {
        weight = weight + amount;
    }

    public String toString(){
        return state.toStr();
    }

    public Double getWeight()
    {
        return weight;
    }

    public String getStatus()
    {
        if(weight < minWeight) {
            return "Dead";
        }
        else if(weight > maxWeight) {
            return "Exploded";
        }
        else if(weight > originWeight) {
            return "Sleeping";
        }
        else {
            return "Playing";
        }
    }
}