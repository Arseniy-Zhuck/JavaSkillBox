import java.util.Calendar;
import java.util.Date;

public class DepositCurrentAccount extends BankAccount{
    private Calendar DateOfDeposit;

    public DepositCurrentAccount(String owner, double amount) {
        super(owner, amount);
        DateOfDeposit = Calendar.getInstance();
    }

    @Override
    public void withDrawMoney(double money) throws IllegalArgumentException {
        Calendar vspom = ((Calendar) DateOfDeposit.clone());
        vspom.add(Calendar.MONTH, 1);
        if (Calendar.getInstance().getTime().before(vspom.getTime()))
            throw new IllegalArgumentException(this.getAccount()+" Нет возможности снять");
        else super.withDrawMoney(money);
    }

    @Override
    protected String getKind() {
        return "deposit current";
    }
}
