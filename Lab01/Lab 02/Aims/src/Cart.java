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
        System.out.println("List of DVDs in the cart:");
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println(itemsOrdered[i].toString());
        }
    }


}
