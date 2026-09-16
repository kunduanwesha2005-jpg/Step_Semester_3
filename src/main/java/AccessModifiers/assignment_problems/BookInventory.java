package AccessModifiers.assignment_problems;

public class BookInventory {
    private int copiesTotal;
    private int copiesAvailable;

    BookInventory(int copiesTotal) {
        this.copiesTotal = copiesTotal;
        this.copiesAvailable = copiesTotal;
    }

    void checkOut() {
        if (copiesAvailable > 0) {
            copiesAvailable = copiesAvailable - 1;
        }
    }

    void checkIn() {
        if (copiesAvailable < copiesTotal) {
            copiesAvailable = copiesAvailable + 1;
        }
    }

    int getCopiesAvailable() {
        return copiesAvailable;
    }

    public static void main(String[] args) {
        BookInventory b1 = new BookInventory(3);
        b1.checkOut();
        b1.checkOut();
        b1.checkOut();
        b1.checkOut();
        System.out.println(b1.getCopiesAvailable());

        BookInventory b2 = new BookInventory(3);
        b2.checkIn();
        b2.checkIn();
        b2.checkIn();
        b2.checkIn();
        System.out.println(b2.getCopiesAvailable());
    }
}
