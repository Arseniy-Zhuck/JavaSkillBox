public abstract class BankClient {
    private static String currentAccount;

    private static String nextAccount() {
        if (currentAccount == null) {
            currentAccount = "000000";
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


    protected BankClient(String name, String inn, double amount) {
        this.name = name;
        INN = inn;
        this.amount = amount;
        this.account = nextAccount();
    }

    protected String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }

    protected String getAccount() {
        return account;
    }

    public void depositMoney(double money) {
        amount += money;
    }

    public void withDrawMoney(double money) throws IllegalArgumentException {
        if (money > amount) throw new IllegalArgumentException(this.getAccount() + " Недостаточно денег на счете");
        else amount -= money;
    }

    protected abstract String getInfo();

    @Override
    public String toString() {
        return String.format("Банковский счет № %s ИНН %s остаток на счете %f", getAccount(), INN, getAmount()) +
                "\n" + getInfo();
    }
}
