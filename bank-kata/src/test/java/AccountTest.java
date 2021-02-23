import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AccountTest {

    private static final List<Transaction> TRANSACTIONS = new ArrayList<>();

    @Mock
    private TransactionRepository transactionRepository;
    @Mock
    private PrinterService printerService;

    private Account account;

    @BeforeEach
    void setUp() {
        account = new Account(transactionRepository, printerService);
    }

    @Test
    void should_store_a_deposit() {
        account.deposit(500);

        verify(transactionRepository).addDeposit(500);
    }

    @Test
    void should_store_a_withdrawal() {
        account.withdraw(300);

        verify(transactionRepository).addWithdrawal(300);
    }

    @Test
    void should_print_statements_in_order_they_occurred() {
        when(transactionRepository.getTransactions()).thenReturn(TRANSACTIONS);

        account.printStatement();

        verify(printerService).print(TRANSACTIONS);
    }
}