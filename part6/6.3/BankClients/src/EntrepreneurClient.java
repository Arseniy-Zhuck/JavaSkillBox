public class EntrepreneurClient implements BankClient {

    private static String currentAccount;

    private static String nextAccount() {
        if (currentAccount == null) {
            currentAccount = "300000";
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


    public EntrepreneurClient(String name, String inn, double amount) {
        this.name = name;
        INN = inn;
        this.amount = amount;
        this.account = nextAccount();
    }

    @Override
    public String getInfo() {
        return "Владелец - индивидуальный предприниматель: " + getName() + "\n" +
                "условия: пополнение с комиссией 1%, если сумма меньше 1000 рублей. И с комиссией 0,5%, если сумма больше либо равна 1000 рублей";

    }



    private String getName() {
        return name;
    }

    @Override
    public double getAmount() {
        return amount;
    }


    private String getAccount() {
        return account;
    }

    @Override
    public void depositMoney(double money) {
        if (money*0.99 < 1000) amount += money*0.99;
        else amount += money*0.995;
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
