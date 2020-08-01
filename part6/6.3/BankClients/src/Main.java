import java.util.ArrayList;

public class Main {
    private static ArrayList<BankClient> bankClientArrayList;
    static {
        bankClientArrayList = new ArrayList<>();
        bankClientArrayList.add(new IndividualClient("Ars", "222333222", 100000));
        bankClientArrayList.add(new EntityClient("OOO \"Ars\"", "222333223", 100000));
        bankClientArrayList.add(new EntrepreneurClient("Ars", "222333224", 100000));
    }

    private static void printClients() {
        System.out.printf("Now we have %d clients\n", bankClientArrayList.size());
        for (BankClient client : bankClientArrayList) {
            System.out.println(client);
        }
        System.out.println("\\\\---------------------------------------------------------------------------\\\\");
    }

    private static void deposit() {
        for (BankClient bankClient : bankClientArrayList) {
            bankClient.depositMoney(100000);
        }
    }

    private static void bigWithdraw() {
        for (BankClient bankClient : bankClientArrayList) {
            try {
                bankClient.withDrawMoney(100000);
            } catch (IllegalArgumentException e) {
                System.out.println(bankClient.getAccount()+ "  " + e.getMessage());
            }
        }
    }

    private static void smallWithdraw() {
        for (BankClient bankClient : bankClientArrayList) {
            bankClient.withDrawMoney(100);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        printClients();
        Thread.sleep(10000);

        bigWithdraw();
        printClients();
        Thread.sleep(10000);

        deposit();
        deposit();
        printClients();
        Thread.sleep(10000);

        bigWithdraw();
        printClients();
        Thread.sleep(10000);





    }
}
