package Assignment_1_solutions;

import java.util.Calendar;

// Main class to test the functionality
public class Main {
    public static void main(String[] args) {
        BankAccount ba = new BankAccount(1000);

        // Test DepositTransaction
        DepositTransaction dt = new DepositTransaction(500, Calendar.getInstance(), "DT001");
        dt.printTransactionDetails();
        dt.apply(ba);

        // Test WithdrawalTransaction
        WithdrawalTransaction wt = new WithdrawalTransaction(200, Calendar.getInstance());
        wt.printTransactionDetails();
        try {
            wt.apply(ba);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }

        // Test WithdrawalTransaction with force withdrawal
        wt.apply(ba, true);

        // Test WithdrawalTransaction reversal
        wt.reverse(ba);


        BaseTransaction bt = new DepositTransaction(300, Calendar.getInstance(), "DT002");
        bt.printTransactionDetails();
        bt.apply(ba);

        bt = new WithdrawalTransaction(400, Calendar.getInstance());
        bt.printTransactionDetails();
        try {
            bt.apply(ba);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
    }
}