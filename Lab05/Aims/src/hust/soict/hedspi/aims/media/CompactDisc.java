package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks;

    public String getArtist() {
        return artist;
    }

    public CompactDisc(int id, String title, String category, String artist, String director, float length, float cost) {
        super(id, title, category, length, director,cost);
        this.artist = artist;
        this.tracks = new ArrayList<>();
    }

    public CompactDisc(int id, String title, String category, String artist, String director, float length, float cost, ArrayList<Track> tracks) {
        super(id, title, category, length, director,cost);
        this.artist = artist;
        this.tracks = tracks;
    }
    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("This track is already on the CD.");
        } else {
            tracks.add(track);
            System.out.println("Track added: " + track.getTitle());
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track removed: " + track.getTitle());
        } else {
            System.out.println("This track is not on the CD.");
        }
    }
    public float getLength() {
        float totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    @Override
    public void play() {
        System.out.println("Playing CD: " + getTitle());
        System.out.println("CD Artist: " + artist);
        System.out.println("Total tracks: " + tracks.size());
        System.out.println("Tracks:");
        for (Track track : tracks) {
            track.play();
        }
    }

    @Override
    public String toString() {
        return "CompactDisc{" +
                "id=" + getId() +
                ", title='" + getTitle() + '\'' +
                ", category='" + getCategory() + '\'' +
                ", artist='" + artist + '\'' +
                ", tracks=" + tracks +
                ", cost=" + getCost() +
                '}';
    }
}
