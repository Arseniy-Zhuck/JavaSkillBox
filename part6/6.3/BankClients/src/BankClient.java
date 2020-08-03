public interface BankClient {

    double getAmount();

    void depositMoney(double money) ;

    void withDrawMoney(double money) throws IllegalArgumentException;

    String getInfo();

    //String getAccount();
}
