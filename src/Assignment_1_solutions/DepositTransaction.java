package Assignment_1_solutions;
import java.util.Calendar;

/**
 * Represents a deposit transaction.
 */
public class DepositTransaction extends BaseTransaction {

    /**
     * Constructs a DepositTransaction with the specified amount, date, and transaction ID.
     *
     * @param amount the amount to be deposited
     * @param date the date of the transaction
     * @param transactionID the unique identifier for the transaction
     */
    public DepositTransaction(double amount, Calendar date, String transactionID) {
        super(amount, date, transactionID);
    }

    /**
     * Applies the deposit transaction to the specified bank account.
     * @param ba the bank account to which the transaction is applied
     */
    @Override
    public void apply(BankAccount ba)  {
        ba.deposit(getAmount());
        System.out.println("Deposit successful. New balance: " + ba.getBalance());
    }
}
