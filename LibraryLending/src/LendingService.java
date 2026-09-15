import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LendingService {

    private FineCalculator fineCalculator;

    public LendingService() {
        this.fineCalculator = new FineCalculator();
    }

    public Loan checkoutLoan(
            Member member,
            LibrarySystem librarySystem,
            LibraryItem item,
            long days) {

        if (!librarySystem.isAvailable(item)) {
            throw new IllegalStateException(
                    "El libro no está disponible."
            );
        }

        Loan loan = new Loan.Builder()
                .member(member)
                .libraryItem(item)
                .dueDate(LocalDate.now().plusDays(days))
                .build();

        item.setAvailable(false);

        return loan;
    }

    public LoanReceipt createReceipt(Loan loan) {

        return new LoanReceipt(
                loan.getMember().getName(),
                loan.getLibraryItem().getTitle(),
                loan.getDueDate()
        );
    }

    public double calculateFine(Loan loan) {

        return fineCalculator.computeFine(loan);
    }

    public List<LibraryItem> findAvailable(
            LibrarySystem librarySystem,
            Predicate<LibraryItem> predicate) {

        return librarySystem.getItems()
                .stream()
                .filter(LibraryItem::isAvailable)
                .filter(predicate)
                .collect(Collectors.toList());
    }
}