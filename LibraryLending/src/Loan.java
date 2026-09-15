import java.time.LocalDate;

public class Loan {
    private Member member;
    private LibraryItem libraryitem;
    private LocalDate dueDate;

    private Loan(Builder builder) {
        this.member = builder.member;
        this.libraryitem = builder.libraryitem;
        this.dueDate = builder.dueDate;
    }

    public Member getMember() {
        return member;
    }

    public LibraryItem getLibraryItem() {
        return libraryitem;
    }

    public LocalDate getDueDate () {
        return dueDate;
    }

    public void returnItem() {
        libraryItem.setAvailable(true);
    }

  public static class Builder {

        private Member member;
        private LibraryItem libraryItem;
        private LocalDate dueDate;

        public Builder member(Member member) {
            this.member = member;
            return this;
        }

        public Builder libraryItem(LibraryItem libraryItem) {
            this.libraryItem = libraryItem;
            return this;
        }

        public Builder dueDate(LocalDate dueDate) {
            this.dueDate = dueDate;
            return this;
        }

        public Loan build() {

            if (member == null) {
                throw new IllegalStateException("El miembro es obligatorio.");
            }

            if (libraryItem == null) {
                throw new IllegalStateException("El elemento de biblioteca es obligatorio.");
            }

            if (dueDate == null) {
                throw new IllegalStateException("La fecha de devolución es obligatoria.");
            }

            return new Loan(this);
        }
    }

    @Override
    public String toString() {
        return "Préstamo de: " + libraryItem.getTitle()
                + " | Miembro: " + member.getName()
                + " | Fecha de devolución: " + dueDate;
    }
    }
}