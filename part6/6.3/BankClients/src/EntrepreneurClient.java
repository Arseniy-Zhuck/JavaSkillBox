public class EntrepreneurClient extends BankClient {
    protected EntrepreneurClient(String name, String inn, double amount) {
        super(name, inn, amount);
    }

    @Override
    protected String getInfo() {
        return "Владелец - индивидуальный предприниматель: " + getName() + "\n" +
                "условия: пополнение с комиссией 1%, если сумма меньше 1000 рублей. И с комиссией 0,5%, если сумма больше либо равна 1000 рублей";

    }

    @Override
    public void depositMoney(double money) {
        super.depositMoney(money*0.99 < 1000 ? money*0.99 : money*0.995);
    }
}
