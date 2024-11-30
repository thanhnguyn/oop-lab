package hust.soict.hedspi.aims.media;

public class Disc extends Media {
    private float length;
    private String director;

    public Disc(int id, String title, String category, float length, String director, float cost) {
        super(id, title, category, cost);
        this.length = length;
        this.director = director;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Disc Title: " + getTitle() + ", Category: " + getCategory() +
                ", Director: " + director + ", Length: " + length + " mins, Cost: $" + getCost();
    }
}
