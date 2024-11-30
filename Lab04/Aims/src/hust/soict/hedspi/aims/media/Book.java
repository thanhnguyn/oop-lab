package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();

    public void addAuthor(String authorName) {
        if(authors.contains(authorName)) {
            System.out.println("This author has already existed.");
        } else {
            authors.add(authorName);
            System.out.println("This author has been added.");
        }
    }

    public void removeAuthor(String authorName) {
        if(authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println("This author has been removed.");
        } else {
            System.out.println("This author doesn't exist.");
        }
    }

    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + getId() +
                ", title='" + getTitle() + '\'' +
                ", category='" + getCategory() + '\'' +
                ", authors=" + authors +
                ", cost=" + getCost() +
                '}';
    }
}
