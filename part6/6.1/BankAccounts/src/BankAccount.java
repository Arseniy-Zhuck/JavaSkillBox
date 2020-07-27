import java.util.ArrayList;

public class BankAccount {
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
    private double amount;
    private String owner;
    private String account;
//    private final String kind = "Simple";

    private static String getAccount;

    public BankAccount(String owner, double amount) {
        this.amount = amount;
        this.owner = owner;
        this.account = nextAccount();
    }

    public void depositMoney(double money) {
        amount += money;
    }

    public void withDrawMoney(double money) throws IllegalArgumentException {
        if (money > amount) throw new IllegalArgumentException(this.getAccount() + " Недостаточно денег на счете");
        else amount -= money;
    }

    private double getAmount() {
        return amount;
    }

    private String getOwner() {
        return owner;
    }

//    public void setOwner(String owner) {
//        this.owner = owner;
//    }

    protected String getAccount() {
        return account;
    }

    @Override
    public String toString() {
        return String.format("The %s account № %s of %s with amount %f", this.getKind(), getAccount(), getOwner(), getAmount());
    }

    protected String getKind() {
        return "simple";
    }

    public boolean send(BankAccount receiver, double amount) {
        try {
            this.withDrawMoney(amount);
        } catch (IllegalArgumentException e) {
            return false;
        }
        receiver.depositMoney(amount);
        return true;
    }
}
