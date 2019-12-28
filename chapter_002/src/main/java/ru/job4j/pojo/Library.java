package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Dictionary", 400);
        Book book2 = new Book("Red and black", 600);
        Book book3 = new Book("Mymy", 100);
        Book book4 = new Book("Clean code", 1000);

        Book[] booksArray = new Book[4];
        booksArray[0] = book1;
        booksArray[1] = book2;
        booksArray[2] = book3;
        booksArray[3] = book4;

        for (int i = 0; i < booksArray.length; i++) {
            System.out.println((i + 1) + ". " + booksArray[i].getName() + " " + booksArray[i].getPageQuantity());
        }
        System.out.println();
        booksArray[0] = book4;
        booksArray[3] = book1;

        for (int i = 0; i < booksArray.length; i++) {
            System.out.println((i + 1) + ". " + booksArray[i].getName() + " " + booksArray[i].getPageQuantity());
        }
        System.out.println();
        for (int i = 0; i < booksArray.length; i++) {
            if (booksArray[i].getName().equals("Clean code")) {
                System.out.println((i + 1) + ". " + booksArray[i].getName() + " " + booksArray[i].getPageQuantity());
            }

        }

    }
}
