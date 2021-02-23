import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class PrinterService {

    public final static String HEADER = "DATE || AMOUNT || BALANCE";

    private final BankConsole console;
    private final static String SEPARATOR = " || ";

    public PrinterService(BankConsole console) {
        this.console = console;
    }

    public void print(List<Transaction> transactions) {

        AtomicInteger runningBalance = new AtomicInteger(0);

        console.printLine(HEADER);
        transactions
                .stream()
                .forEach(transaction -> printStatementLine(runningBalance, transaction));

    }

    private void printStatementLine(AtomicInteger balance, Transaction transaction) {
        console.printLine(transaction.getDate() + SEPARATOR + transaction.getAmount() + SEPARATOR + balance.addAndGet(transaction.getAmount()));
    }
}
