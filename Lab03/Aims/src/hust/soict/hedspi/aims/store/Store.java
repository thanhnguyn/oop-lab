package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

import java.util.ArrayList;
public class Store {
    private ArrayList<DigitalVideoDisc> itemsInStore = new ArrayList<DigitalVideoDisc>();
    private int nbItems = 0;
    public void addDVD(DigitalVideoDisc dvd) {
        itemsInStore.add(dvd);
        nbItems += 1;
        System.out.println("The disc is added to store!");
    }
    public void removeDVD(DigitalVideoDisc dvd) {
        try {
            itemsInStore.remove(dvd);
            nbItems -= 1;
            System.out.println("The disc is removed from store!");
        }
        catch (Exception e) {
            System.out.println("Disc doesn't exist!");
            return ;
        }
    }
    public ArrayList<DigitalVideoDisc> getItemsInStore() {
        return itemsInStore;
    }
}