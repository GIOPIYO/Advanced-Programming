package Assignment_1_solutions;

import java.util.Calendar;

class WithdrawalTransaction extends BaseTransaction {
    public WithdrawalTransaction(double amount, Calendar date, String transactionID) {
        super(amount, date, transactionID);
    }

    @Override
    public void apply(BankAccount ba) throws InsufficientFundsException {
        if (ba.getBalance() < getAmount()) {
            throw new InsufficientFundsException("Insufficient funds in account");
        }
        ba.withdraw(getAmount());
        System.out.println("Withdrawal successful. New balance: " + ba.getBalance());
    }

    public boolean reverse(BankAccount ba) {
        ba.deposit(getAmount());
        System.out.println("Withdrawal reversed. New balance: " + ba.getBalance());
        return true;
    }

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