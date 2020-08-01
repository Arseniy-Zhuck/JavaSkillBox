public class IndividualClient extends BankClient {
    protected IndividualClient(String name, String inn, double amount) {
        super(name, inn, amount);
    }

    @Override
    protected String getInfo() {
        return "Владелец: " + getName() +
                " условия: пополнение и снятие без комиссии";
    }


}
