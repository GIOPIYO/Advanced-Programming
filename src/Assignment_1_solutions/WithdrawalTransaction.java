package Assignment_1_solutions;

import java.util.Calendar;

class WithdrawalTransaction extends BaseTransaction {

    /**
     * Constructs a WithdrawalTransaction with the specified amount, date, and transaction ID.
     * @param amount the amount to be withdrawn
     * @param date the date of the transaction
     * @param transactionID the unique identifier for the transaction
     */
    public WithdrawalTransaction(double amount, Calendar date, String transactionID) {
        super(amount, date, transactionID);
    }

    /**
     * Applies the withdrawal transaction to the specified bank account.
     * @param ba the bank account to which the transaction is applied
     * @throws InsufficientFundsException if the account has insufficient funds
     */
    @Override
    public void apply(BankAccount ba) throws InsufficientFundsException {
        if (ba.getBalance() < getAmount()) {
            throw new InsufficientFundsException("Insufficient funds in account");
        }
        ba.withdraw(getAmount());
        System.out.println("Withdrawal successful. New balance: " + ba.getBalance());
    }

    /**
     * Reverses the withdrawal transaction by depositing the amount back into the specified bank account.
     * @param ba the bank account to which the amount is deposited
     * @return true if the reversal is successful
     */
    public boolean reverse(BankAccount ba) {
        ba.deposit(getAmount());
        System.out.println("Withdrawal reversed. New balance: " + ba.getBalance());
        return true;
    }

    /**
     * Applies the withdrawal transaction to the specified bank account
     * @param ba the bank account to which the transaction is applied
     * @param forceWithdrawal if true, forces the withdrawal even if the account has insufficient funds
     */
    public void apply(BankAccount ba, boolean forceWithdrawal) {
        try {
            if (ba.getBalance() < getAmount()) {
                if (forceWithdrawal) {
                    double amountWithdrawn = ba.getBalance();
                    ba.withdraw(amountWithdrawn);
                    System.out.println("Withdrew " + amountWithdrawn + ". Remaining amount not withdrawn: " + (getAmount() - amountWithdrawn));
                } else {
                    throw new InsufficientFundsException("Insufficient funds in account");
                }
            } else {
                ba.withdraw(getAmount());
                System.out.println("Withdrawal successful. New balance: " + ba.getBalance());
            }
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Withdrawal operation completed.");
        }
    }
}