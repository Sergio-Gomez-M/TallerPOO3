import java.util.ArrayList;
import java.util.List;

public class LibrarySystem {

    private List<LibraryItem> items;

    public LibrarySystem() {
        items = new ArrayList<>();
    }

    public void addItem(LibraryItem item) {
        items.add(item);
    }

    public List<LibraryItem> getItems() {
        return items;
    }

    public boolean isAvailable(LibraryItem item) {
        return item.isAvailable();
    }
}