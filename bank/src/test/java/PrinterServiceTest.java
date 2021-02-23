import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PrinterServiceTest {

    @Mock
    BankConsole console;

    private PrinterService printerService;

    @BeforeEach
    void setUp() {
        printerService = new PrinterService(console);

    }

    @Test
    void should_always_print_header() {
        printerService.print(new ArrayList<>());

        verify(console).printLine(PrinterService.HEADER);
    }

    @Test
    void should_print_statements_with_date_amount_and_balance() {
        Transaction deposit = new Transaction(500, LocalDate.of(2019, 8, 19));
        Transaction withdraw = new Transaction(-400, LocalDate.of(2019,8,20));
        Transaction transaction = new Transaction(1200, LocalDate.of(2019,8,21));
        List<Transaction> transactions = Arrays.asList(deposit, withdraw, transaction);

        printerService.print(transactions);

        verify(console).printLine(PrinterService.HEADER);
        verify(console).printLine("2019-08-19 || 500 || 500");
        verify(console).printLine("2019-08-20 || -400 || 100");
        verify(console).printLine("2019-08-21 || 1200 || 1300");
    }
}