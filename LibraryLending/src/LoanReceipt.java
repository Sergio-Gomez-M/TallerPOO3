import java.time.LocalDate;

public class LoanReceipt {

    private String memberName;
    private String title;
    private LocalDate dueDate;

    public LoanReceipt(String memberName, String title, LocalDate dueDate) {
        this.memberName = memberName;
        this.title = title;
        this.dueDate = dueDate;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    @Override
    public String toString() {
        return "========== RECIBO ==========\n"
                + "Miembro: " + memberName + "\n"
                + "Libro: " + title + "\n"
                + "Fecha de devolución: " + dueDate + "\n"
                + "=============================";
    }
}