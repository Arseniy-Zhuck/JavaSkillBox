public class Main {
    public static void main(String[] args) {
        BankAccount[] myAccounts = new BankAccount[3];
        myAccounts[0] = new BankAccount("Арсений", 10000.00);
        myAccounts[1] = new DepositCurrentAccount("Арсений", 10000.00);
        myAccounts[2] = new CardAccount("Арсений", 10000.00);
        for (int i = 0; i < 3; i++) {
            try {
                myAccounts[i].withDrawMoney(10000);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        for (int i = 0; i < 3; i++) {
            System.out.println(myAccounts[i]);
        }
        for (int i = 0; i < 3; i++) {
            myAccounts[i].depositMoney(10000);
        }
        for (int i = 0; i < 3; i++) {
            System.out.println(myAccounts[i]);
        }
        for (int i = 0; i < 3; i++) {
            try {
                myAccounts[i].withDrawMoney(7000);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        for (int i = 0; i < 3; i++) {
            System.out.println(myAccounts[i]);
        }
        BankAccount creditAccount = new BankAccount("Долбанные кредиты", 0);
        for (int i = 0; i < 3; i++) {
            if (myAccounts[i].send(creditAccount, 7000))
                System.out.println(myAccounts[i] + " платеж 7000 выполнен");
            else System.out.println(myAccounts[i] + " платеж 7000 НЕ выполнен");
        }
    }

}
