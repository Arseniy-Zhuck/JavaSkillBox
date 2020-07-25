public class CardAccount extends BankAccount{

    public CardAccount(String owner, double amount) {
        super(owner, amount);
    }

    @Override
    public void withDrawMoney(double money) throws IllegalArgumentException {
        super.withDrawMoney(money*1.01);
    }

    @Override
    protected String getKind() {
        return "card";
    }
}
