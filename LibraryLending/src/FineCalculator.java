import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class FineCalculator {

    private static final double FINE_PER_DAY = 2.0;

    public double computeFine(Loan loan) {

        LocalDate today = LocalDate.now();
        LocalDate dueDate = loan.getDueDate();

        if (!today.isAfter(dueDate)) {
            return 0.0;
        }

        long daysLate = ChronoUnit.DAYS.between(dueDate, today);

        return daysLate * FINE_PER_DAY;
    }
}
