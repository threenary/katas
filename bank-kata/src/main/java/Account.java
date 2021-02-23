public class Account implements AccountService {

    private TransactionRepository transactionRepository;
    private PrinterService printerService;

    public Account(TransactionRepository transactionRepository, PrinterService printerService) {
        this.transactionRepository = transactionRepository;
        this.printerService = printerService;
    }

    @Override
    public void deposit(int amount) {
        transactionRepository.addDeposit(amount);
    }

    @Override
    public void withdraw(int amount) {
        transactionRepository.addWithdrawal(amount);
    }

    @Override
    public void printStatement() {
        printerService.print(transactionRepository.getTransactions());
    }
}
