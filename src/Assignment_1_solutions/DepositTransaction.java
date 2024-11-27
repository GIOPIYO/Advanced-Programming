package Assignment_1_solutions;
import java.util.Calendar;

public class DepositTransaction extends BaseTransaction{
    public DepositTransaction(double amount, Calendar date, String transactionID) {
        super(amount, date, transactionID);
    }

    @Override
    public void apply(BankAccount ba) {
        ba.deposit(getAmount());
        System.out.println("Deposit successful. New balance: " + ba.getBalance());
    }

}
