package Assignment_1_solutions;
import java.util.Calendar;

public interface TransactionInterface {
    double getAmount();
    Calendar getDate();
    String getTransactionID();
    void printTransactionDetails();
    void apply(BankAccount ba);
    boolean reverse();
}

