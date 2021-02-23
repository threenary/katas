import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class TransactionRepositoryTest {

    @Mock
    private Clock clock;

    private TransactionRepository transactionRepository;

    @BeforeEach
    public void setUp() {
        LocalDate localDate = LocalDate.of(2019, 8, 22);
        Mockito.when(clock.getLocalDate()).thenReturn(localDate);
        transactionRepository = new TransactionRepository(clock);
    }

    @Test
    void should_increment_number_of_transactions() {
        transactionRepository.addDeposit(300);
        transactionRepository.addWithdrawal(400);

        assertEquals(2, transactionRepository.getTransactions().size());
    }

    @Test
    void should_increase_the_balance() {
        transactionRepository.addDeposit(500);

        evaluateTransactionBalance(500);
    }

    @Test
    void should_reduce_the_balance() {
        transactionRepository.addWithdrawal(500);

        evaluateTransactionBalance(-500);
    }

    private void evaluateTransactionBalance(int i) {
        assertEquals(1, transactionRepository.getTransactions().size());
        assertEquals(i, transactionRepository.getTransactions().stream().mapToInt(Transaction::getAmount).sum());
    }
}