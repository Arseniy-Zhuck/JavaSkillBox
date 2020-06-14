
public class Cat
{
    public static final int EYE_COUNT = 2;
    public static final double MIN_WEIGHT = 1000.0;
    public static final double MAX_WEIGHT = 9000.0;

    private static int catCount = 0;

    private final double originWeight;
    private double weight;
    private CatColor catColor;
    private double eatAmount;
    private CatState catState;
    private String name;
    //private boolean isDead = false;

    


    public static Cat deppCatCopy(Cat cat) {
        return new Cat(cat.getWeight(),cat.getName(),cat.getCatColor());
    }

    public static int getCatCount() {
        return Cat.catCount;
    }

    public static Cat getKitten(String name, CatColor color){
        return new Cat(1100.0,name,color);
    }

    public Cat(String name, CatColor color) {
        this(1500.0 + 3000.0 * Math.random(),name, color);

    }

    public Cat(double weight, String name, CatColor color) {
        this.weight = weight;
        originWeight = weight;
        eatAmount = 0;
        catCount++;
        this.catState = new CatAliveState();
        this.catState.setCat(this);
        this.name = name;
        setColor(color);
    }

    private void die() {
        Cat.catCount--;
        System.out.println("The cat is dead");
        this.catState = new CatDeadState();
    }

    private void check() {
        if ((getStatus().equals("Dead"))||(getStatus().equals("Exploded"))) {
            die();
        }
    }

    public String getName() {
        return name;
    }

    public double getEatAmount() {
        return eatAmount;
    }

    public void pee() {
        catState.pee();
    }

    public void meow() {
        catState.meow();
    }

    public void feed(Double amount) {
        catState.feed(amount);
    }

    public void drink(Double amount) {
        catState.drink(amount);
    }

    public Double getWeight() {
        return weight;
    }

    public CatColor getCatColor() {
        return catColor;
    }

    public String getStatus() {
        if(weight < MIN_WEIGHT) {

            return "Dead";
        }
        else if(weight > MAX_WEIGHT) {

            return "Exploded";
        }
        else if(weight > originWeight) {
            return "Sleeping";
        }
        else {
            return "Playing";
        }
    }

    public void setColor(CatColor catColor) {
        this.catColor = catColor;
    }

    @Override
    public String toString() {
        return getCatColor().getCode() +" cat " + getName() + " of weight " + this.weight + " is " + getStatus()+"\n" +
                this.getClass()+ " " + this.hashCode();
    }



    private class CatAliveState implements CatState{
        private Cat cat;

        @Override
        public void feed(double amount) {
            cat.eatAmount += amount;
            cat.weight = weight + amount;
            cat.check();
        }

        @Override
        public void drink(double amount) {
            weight = weight + amount;
            check();
        }

        @Override
        public void meow() {
            weight = weight - 1;
            System.out.println("Meow");
            check();
        }

        @Override
        public void pee() {
            weight -= 200;
            System.out.println("Soon you smell it");
            check();
        }

        @Override
        public void setCat(Cat cat) {
            this.cat = cat;
        }
    }

    private class CatDeadState implements CatState{

        @Override
        public void feed(double amount) {
            System.out.println("Dead cats don't eat");
        }

        @Override
        public void drink(double amount) {
            System.out.println("Dead cats don't drink");
        }

        @Override
        public void meow() {
            System.out.println("Dead cats don't meow");
        }

        @Override
        public void pee() {
            System.out.println("Dead cats don't go pee");
        }

        @Override
        public void setCat(Cat cat) {

        }
    }

}