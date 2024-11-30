package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.MediaComparatorByTitleCost;
import hust.soict.hedspi.aims.MediaComparatorByCostTitle;

import java.util.*;

public class Aims {

    private static Scanner scanner = new Scanner(System.in);
    private static Store store = new Store();
    private static List<Media> currentCart = new ArrayList<>();

    public static void main(String[] args) {
        showMenu();
    }

    public static void showMenu() {
        System.out.println("AIMS:");
        System.out.println();
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println();
        System.out.print("Please choose a number: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character after nextInt()

        switch (choice) {
            case 1:
                viewStoreMenu();
                break;
            case 2:
                updateStoreMenu();
                break;
            case 3:
                showCartMenu();
                break;
            case 0:
                System.out.println("Exiting AIMS. Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please choose again.");
                showMenu();
                break;
        }
    }

    public static void viewStoreMenu() {
        System.out.println("Options:");
        System.out.println();
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println();
        System.out.print("Please choose a number: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character after nextInt()

        switch (choice) {
            case 1:
                seeMediaDetails();
                break;
            case 2:
                addMediaToCart();
                break;
            case 3:
                playMedia();
                break;
            case 4:
                showCartMenu();
                break;
            case 0:
                showMenu();
                break;
            default:
                System.out.println("Invalid choice. Please choose again.");
                viewStoreMenu();
                break;
        }
    }

    public static void seeMediaDetails() {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();

        Media media = store.searchMediaByTitle(title);
        if (media != null) {
            System.out.println(media.toString());
            mediaDetailsMenu(media);
        } else {
            System.out.println("Media not found in store.");
        }
    }

    public static void mediaDetailsMenu(Media media) {
        System.out.println("Options:");
        System.out.println();
        System.out.println("1. Add to cart");
        if (media instanceof Playable) {
            System.out.println("2. Play");
        }
        System.out.println("0. Back");
        System.out.println();
        System.out.print("Please choose a number: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character after nextInt()

        switch (choice) {
            case 1:
                addToCart(media);
                break;
            case 2:
                if (media instanceof Playable) {
                    ((Playable) media).play();
                }
                break;
            case 0:
                viewStoreMenu();
                break;
            default:
                System.out.println("Invalid choice. Please choose again.");
                mediaDetailsMenu(media);
                break;
        }
    }

    public static void addToCart(Media media) {
        currentCart.add(media);
        System.out.println("Media added to cart.");
        System.out.println("Current number of items in cart: " + currentCart.size());
        viewStoreMenu();
    }

    public static void addMediaToCart() {
        System.out.print("Enter the title of the media to add to cart: ");
        String title = scanner.nextLine();

        Media media = store.searchMediaByTitle(title);
        if (media != null) {
            addToCart(media);
        } else {
            System.out.println("Media not found in store.");
        }
    }

    public static void playMedia() {
        System.out.print("Enter the title of the media to play: ");
        String title = scanner.nextLine();

        Media media = store.searchMediaByTitle(title);
        if (media != null && media instanceof Playable) {
            ((Playable) media).play();
        } else if (media != null) {
            System.out.println("This media is not playable.");
        } else {
            System.out.println("Media not found in store.");
        }
        viewStoreMenu();
    }

    public static void updateStoreMenu() {
        System.out.println("Options:");
        System.out.println();
        System.out.println("1. Add a media to store");
        System.out.println("2. Remove a media from store");
        System.out.println("0. Back");
        System.out.println();
        System.out.print("Please choose a number: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character after nextInt()

        switch (choice) {
            case 1:
                addMediaToStore();
                break;
            case 2:
                removeMediaFromStore();
                break;
            case 0:
                showMenu();
                break;
            default:
                System.out.println("Invalid choice. Please choose again.");
                updateStoreMenu();
                break;
        }
    }

    public static void addMediaToStore() {
        // Implement adding media to store functionality
        // For simplicity, not implemented in this example
        System.out.println("Adding media to store.");
        updateStoreMenu();
    }

    public static void removeMediaFromStore() {
        // Implement removing media from store functionality
        // For simplicity, not implemented in this example
        System.out.println("Removing media from store.");
        updateStoreMenu();
    }

    public static void showCartMenu() {
        System.out.println("Options:");
        System.out.println();
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println();
        System.out.print("Please choose a number: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character after nextInt()

        switch (choice) {
            case 1:
                filterMediaInCart();
                break;
            case 2:
                sortMediaInCart();
                break;
            case 3:
                removeMediaFromCart();
                break;
            case 4:
                playMediaFromCart();
                break;
            case 5:
                placeOrder();
                break;
            case 0:
                showMenu();
                break;
            default:
                System.out.println("Invalid choice. Please choose again.");
                showCartMenu();
                break;
        }
    }

    public static void filterMediaInCart() {
        System.out.println("Filter options:");
        System.out.println();
        System.out.println("1. Filter by ID");
        System.out.println("2. Filter by title");
        System.out.println("0. Back");
        System.out.println();
        System.out.print("Please choose a number: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character after nextInt()

        switch (choice) {
            case 1:
                System.out.print("Enter the ID to filter: ");
                int id = scanner.nextInt();
                scanner.nextLine(); // Consume newline character after nextInt()
                filterById(id);
                break;
            case 2:
                System.out.print("Enter the title to filter: ");
                String title = scanner.nextLine();
                filterByTitle(title);
                break;
            case 0:
                showCartMenu();
                break;
            default:
                System.out.println("Invalid choice. Please choose again.");
                filterMediaInCart();
                break;
        }
    }

    public static void filterById(int id) {
        List<Media> filteredList = new ArrayList<>();
        for (Media media : currentCart) {
            if (media.getId() == id) {
                filteredList.add(media);
            }
        }
        displayFilteredMedia(filteredList);
    }

    public static void filterByTitle(String title) {
        List<Media> filteredList = new ArrayList<>();
        for (Media media : currentCart) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                filteredList.add(media);
            }
        }
        displayFilteredMedia(filteredList);
    }

    public static void displayFilteredMedia(List<Media> filteredList) {
        if (filteredList.isEmpty()) {
            System.out.println("No media found matching the criteria.");
        } else {
            System.out.println("Filtered media:");
            for (Media media : filteredList) {
                System.out.println(media.toString());
            }
        }
        showCartMenu();
    }

    public static void sortMediaInCart() {
        System.out.println("Sort options:");
        System.out.println();
        System.out.println("1. Sort by title");
        System.out.println("2. Sort by cost");
        System.out.println("0. Back");
        System.out.println();
        System.out.print("Please choose a number: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character after nextInt()

        switch (choice) {
            case 1:
                Collections.sort(currentCart, Media.COMPARE_BY_TITLE_COST);
                break;
            case 2:
                Collections.sort(currentCart, Media.COMPARE_BY_COST_TITLE);
                break;
            case 0:
                showCartMenu();
                break;
            default:
                System.out.println("Invalid choice. Please choose again.");
                sortMediaInCart();
                break;
        }
        System.out.println("Media in cart sorted.");
        showCartMenu();
    }

    public static void removeMediaFromCart() {
        System.out.print("Enter the title of the media to remove from cart: ");
        String title = scanner.nextLine();

        Iterator<Media> iterator = currentCart.iterator();
        boolean found = false;
        while (iterator.hasNext()) {
            Media media = iterator.next();
            if (media.getTitle().equalsIgnoreCase(title)) {
                iterator.remove();
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("Media removed from cart.");
        } else {
            System.out.println("Media not found in cart.");
        }
        showCartMenu();
    }

    public static void playMediaFromCart() {
        System.out.print("Enter the title of the media to play from cart: ");
        String title = scanner.nextLine();

        Media media = searchMediaInCartByTitle(title);
        if (media != null && media instanceof Playable) {
            ((Playable) media).play();
        } else if (media != null) {
            System.out.println("This media is not playable.");
        } else {
            System.out.println("Media not found in cart.");
        }
        showCartMenu();
    }

    public static Media searchMediaInCartByTitle(String title) {
        for (Media media : currentCart) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }

    public static void placeOrder() {
        System.out.println("Order placed. Thank you!");

        // Clear the current cart
        currentCart.clear();

        showMenu();
    }
}
