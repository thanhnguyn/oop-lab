package hust.soict.hedspi.aims.cart;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] =
            new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    int qtyOrdered=0;

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered == 20) {
            System.out.println("The cart is almost full");
        }
        else {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered += 1;
            System.out.println("The disc has been added");
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {

    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {

    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for (int i=0; i<qtyOrdered;i++) {
            if (itemsOrdered[i] == disc) {
                for(int j=i;j<qtyOrdered;j++) {
                    itemsOrdered[j] = itemsOrdered[j+1];
                }
                itemsOrdered[qtyOrdered-1] = null;
                qtyOrdered -= 1;
                System.out.println("The disc has been removed.");
                return;
            }
        }
    }
    public float totalCost() {
        float sum=0;
        for (int i=0;i<qtyOrdered;i++) {
            sum += itemsOrdered[i].getCost();
        }
        return sum;
    }

    public void printCart() {
        System.out.println("***********************CART***********************");
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println(i+1+ ". DVD - "+itemsOrdered[i].getTitle()
                    +" - "+itemsOrdered[i].getCategory()
                    +" - "+itemsOrdered[i].getDirector()
                    +" - "+itemsOrdered[i].getLength()
                    +": "+itemsOrdered[i].getCost());
        }
        System.out.println("Total cost: " + totalCost() + "$");
        System.out.println("**************************************************");
    }
    public void searchId(int id) {
        for(DigitalVideoDisc item: itemsOrdered) {
            if(item.getId() == id) {
                System.out.println(item);
                return ;
            }
            System.out.println("No DVD is matched!");
        }
    }
    public void searchTitle(String title) {
        for(DigitalVideoDisc item: itemsOrdered) {
            if(item.isMatch(title)) {
                System.out.println(item);
                return ;
            }
            System.out.println("No DVD is matched!");
        }
    }


}
