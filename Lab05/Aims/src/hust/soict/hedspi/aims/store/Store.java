package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.Media;

import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<>();
    private int nbItems = 0;

    public void addMedia(Media media) {
        itemsInStore.add(media);
        nbItems++;
        System.out.println("The media has been added to the store!");
    }

    public void removeMedia(Media media) {
        if (itemsInStore.remove(media)) {
            nbItems--;
            System.out.println("The media has been removed from the store!");
        } else {
            System.out.println("Media doesn't exist in the store!");
        }
    }

    public Media searchMediaByTitle(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }

        public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }


}
