public class IndividualClient implements BankClient {

    private static String currentAccount;

    private static String nextAccount() {
        if (currentAccount == null) {
            currentAccount = "100000";
        } else {
            currentAccount = String.valueOf(Integer.parseInt(currentAccount) + 1);
            while (currentAccount.length() < 6)
                currentAccount = "0" + currentAccount;
        }
        return currentAccount;
    }

    private String name;
    private String INN;
    private double amount;
    private String account;

    public IndividualClient(String name, String inn, double amount) {
        this.name = name;
        INN = inn;
        this.amount = amount;
        this.account = nextAccount();
    }

    @Override
    public String getInfo() {
        return "Владелец: " + getName() +
                " условия: пополнение и снятие без комиссии";
    }

    private String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }

    private String getAccount() {
        return account;
    }

    @Override
    public void depositMoney(double money) {
        amount += money;
    }

    @Override
    public void withDrawMoney(double money) throws IllegalArgumentException {
        if (money > amount) throw new IllegalArgumentException(this.getAccount() + " Недостаточно денег на счете");
        else amount -= money;
    }

    @Override
    public String toString() {
        return String.format("Банковский счет № %s ИНН %s остаток на счете %f", getAccount(), INN, getAmount()) +
                "\n" + getInfo();
    }

}
