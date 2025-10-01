package Modul4;

public class Magazine extends Book {
    private String category;

    public Magazine(String title, String author, String category) {
        super(title, author);
        this.category = category;
    }

    public String getSubject() { return category; }
}


