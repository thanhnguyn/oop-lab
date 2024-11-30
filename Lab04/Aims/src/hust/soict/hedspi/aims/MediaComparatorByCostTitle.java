package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.media.Media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    @Override
    public int compare(Media media1, Media media2) {
        int costComparison = Float.compare(media2.getCost(), media1.getCost());

        if (costComparison == 0) {
            return media1.getTitle().compareTo(media2.getTitle());
        }

        return costComparison;
    }
}

