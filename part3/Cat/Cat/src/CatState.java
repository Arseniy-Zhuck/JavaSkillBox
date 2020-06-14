public interface CatState {
    public void feed(double amount);
    void drink(double amount);
    void meow();
    void pee();
    void setCat(Cat cat);
}
