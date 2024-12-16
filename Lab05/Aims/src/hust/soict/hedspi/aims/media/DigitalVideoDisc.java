package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable  {

    public DigitalVideoDisc(int id, String title, String category, String director, float length, float cost) {
        super(id, title, category, length, director, cost);  // Call the superclass constructor
    }
    public boolean isMatch(String title) {
        return getTitle().equals(title);
    }

    @Override
    public void play() {
        System.out.println("Playing DVD: " + getTitle());
        System.out.println("DVD length: " + getLength() + " mins");
    }

    @Override
    public String toString() {
        return "DigitalVideoDisc{" +
                "id=" + getId() +
                ", title='" + getTitle() + '\'' +
                ", category='" + getCategory() + '\'' +
                ", director='" + getDirector() + '\'' +
                ", length=" + getLength() +
                ", cost=" + getCost() +
                '}';
    }
}
