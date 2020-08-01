public class EntityClient extends BankClient {
    protected EntityClient(String name, String inn, double amount) {
        super(name, inn, amount);
    }

    @Override
    protected String getInfo() {
        return "Владелец - юр.лицо: " + getName() + " условия: пополнение без комиссии; снятие с комиссией 1%";
    }

    @Override
    public void withDrawMoney(double money) throws IllegalArgumentException {
        super.withDrawMoney(money*1.01);
    }
}
