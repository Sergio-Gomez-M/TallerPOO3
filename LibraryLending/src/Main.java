import java.util.List;

public class Main {

    public static void main(String[] args) {

        LibrarySystem library = new LibrarySystem();

        LibraryItem book1 = new LibraryItem("1984");
        LibraryItem book2 = new LibraryItem("El Principito");
        LibraryItem book3 = new LibraryItem("Cien años de soledad");

        library.addItem(book1);
        library.addItem(book2);
        library.addItem(book3);

        Member member = new Member("Sergio", "001");

        LendingService service = new LendingService();

        Loan loan = service.checkoutLoan(
                member,
                library,
                book1,
                14
        );

        System.out.println("PRÉSTAMO REALIZADO");
        System.out.println(loan);

        LoanReceipt receipt = service.createReceipt(loan);

        System.out.println();
        System.out.println(receipt);

        double fine = service.calculateFine(loan);

        System.out.println();
        System.out.println("Multa actual: $" + fine);

        List<LibraryItem> availableBooks =
                service.findAvailable(
                        library,
                        book -> book.getTitle().length() > 5
                );

        System.out.println();
        System.out.println("LIBROS DISPONIBLES:");

        for (LibraryItem item : availableBooks) {
            System.out.println("- " + item.getTitle());
        }
    }
}