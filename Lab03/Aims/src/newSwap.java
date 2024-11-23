import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class newSwap {

    public static void main(String[] args) {
        DigitalVideoDisc jungleDigitalVideoDisc = new DigitalVideoDisc("The Jungle Book");
        DigitalVideoDisc cinderellaDigitalVideoDisc = new DigitalVideoDisc("Cinderella");

        System.out.println("Before swap:");
        System.out.println("Jungle hust.soict.hedspi.aims.disc.DigitalVideoDisc title: " + jungleDigitalVideoDisc.getTitle());
        System.out.println("Cinderella hust.soict.hedspi.aims.disc.DigitalVideoDisc title: " + cinderellaDigitalVideoDisc.getTitle());

        swap(jungleDigitalVideoDisc, cinderellaDigitalVideoDisc);

        System.out.println("\nAfter swap:");
        System.out.println("Jungle hust.soict.hedspi.aims.disc.DigitalVideoDisc title: " + jungleDigitalVideoDisc.getTitle());
        System.out.println("Cinderella hust.soict.hedspi.aims.disc.DigitalVideoDisc title: " + cinderellaDigitalVideoDisc.getTitle());
    }

    // Swap method
    public static void swap(DigitalVideoDisc DigitalVideoDisc1, DigitalVideoDisc DigitalVideoDisc2) {
        String tempTitle = DigitalVideoDisc1.getTitle();
        DigitalVideoDisc1.setTitle(DigitalVideoDisc2.getTitle());
        DigitalVideoDisc2.setTitle(tempTitle);
    }

}
