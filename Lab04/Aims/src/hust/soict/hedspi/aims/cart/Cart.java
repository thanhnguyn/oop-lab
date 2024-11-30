package hust.soict.hedspi.aims.cart;

import hust.soict.hedspi.aims.media.Media;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cart {
    private List<Media> itemsOrdered = new ArrayList<>();
    public static final int MAX_NUMBERS_ORDERED = 20;
//    private ArrayList<Media> itemsOrdered = new ArrayList<>();

    // Method to add Media objects to the cart
    public void addMedia(Media media) {
        if (itemsOrdered.size() == MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is almost full.");
        } else {
            itemsOrdered.add(media);
            System.out.println("The media has been added to the cart.");
        }
    }

    // Method to remove Media objects from the cart
    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("The media has been removed from the cart.");
        } else {
            System.out.println("The media is not in the cart.");
        }
    }

    // Method to calculate the total cost of all items in the cart
    public float totalCost() {
        float sum = 0;
        for (Media media : itemsOrdered) {
            sum += media.getCost();
        }
        return sum;
    }

    // Method to print the cart contents
    public void printCart() {
        System.out.println("***********************CART***********************");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            Media media = itemsOrdered.get(i);
            System.out.println((i + 1) + ". " + media.getClass().getSimpleName() +
                    " - " + media.getTitle() +
                    " - " + media.getCategory() +
                    " - Cost: " + media.getCost());
        }
        System.out.println("Total cost: " + totalCost() + "$");
        System.out.println("**************************************************");
    }

    // Method to search for Media by its ID
    public void searchId(int id) {
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println(media);
                return;
            }
        }
        System.out.println("No media matched with ID: " + id);
    }

    // Method to search for Media by its title
    public void searchTitle(String title) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.isMatch(title)) {
                System.out.println(media);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No media matched with title: " + title);
        }
    }

    public void sortByTitleThenCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }

    public void sortByCostThenTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }
}
