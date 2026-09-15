public class LibraryItem {
    private String title;
    private boolean available;

    public LibraryItem(String title) {
        this.title = title;
        this.available = true;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @override
    public String toString() {
        return title;
    }
}