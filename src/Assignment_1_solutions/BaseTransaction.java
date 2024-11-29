package Assignment_1_solutions;

import org.jetbrains.annotations.NotNull;
import java.util.Calendar;

/**
 * Represents a base transaction with common transaction properties and methods.
 */
public class BaseTransaction implements TransactionInterface {
    private final double amount;
    private final Calendar date;
    private final String transactionID;
    protected BankAccount changedAccount;
    protected boolean isChanged = false;

    /**
     * Constructs a BaseTransaction with the specified amount, date, and transaction ID.
     *
     * @param amount the amount involved in the transaction
     * @param date the date of the transaction, must not be null
     * @param transactionID the unique identifier for the transaction
     * @throws IllegalArgumentException if date is null
     */
    public BaseTransaction(double amount, @NotNull Calendar date, String transactionID) {
        this.amount = amount;
        this.date = (Calendar) date.clone();
        int uniq = (int) (Math.random() * 10000);
        this.transactionID = date.toString() + uniq;
    }

    /**
     * Returns the amount involved in the transaction.
     * @return the transaction amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Returns the date of the transaction.
     * @return the transaction date
     */
    public Calendar getDate() {
        return (Calendar) date.clone();
    }

    /**
     * Returns the unique identifier of the transaction.
     * @return the transaction ID
     */
    public String getTransactionID() {
        return transactionID;
    }

    public void printTransactionDetails() {
        System.out.println("Transaction Details:");
        System.out.println("ID: " + getTransactionID());
        System.out.println("Amount: $" + getAmount());
        System.out.println("Date: " + getDate().getTime());
    }

    /**
     * Applies the transaction to the specified bank account.
     *
     * @param ba the bank account to which the transaction is applied
     * @throws InsufficientFundsException if there is an insufficient balance
     */
    public void apply(BankAccount ba) throws InsufficientFundsException {
        System.out.println("Processing transaction: " + transactionID);
        System.out.println("Current balance before transaction: $" + ba.getBalance());
        this.changedAccount = ba;
    }

    /**
     * Reverses the transaction. Base transactions cannot be reversed.
     * @return false indicating the transaction cannot be reversed
     */
    @Override
    public boolean reverse() {
        System.out.println("Base transactions cannot be reversed");
        return false;
    }
}
