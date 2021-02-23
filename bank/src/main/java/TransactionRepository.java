import java.util.ArrayList;
import java.util.List;

public class TransactionRepository {

    private List<Transaction> transactions;

    private Clock clock;

    public TransactionRepository(Clock clock) {
        this.clock = clock;
        transactions = new ArrayList<>();
    }

    public void addDeposit(int amount) {
        final Transaction transaction = new Transaction(amount, clock.getLocalDate());
        transactions.add(transaction);
    }

    public void addWithdrawal(int amount) {
        Transaction transaction = new Transaction(-amount, clock.getLocalDate());
        transactions.add(transaction);
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
