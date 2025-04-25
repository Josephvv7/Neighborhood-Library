package com.pluralsight;

import java.util.Scanner;

public class NeighborhoodLibrary {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Book[] inventory = initializeInventory();

        while (true) {
            System.out.println("\nWelcome to Neighborhood Library");
            System.out.println("1. Show Available Books");
            System.out.println("2. Show Checked Out Books");
            System.out.println("3. Exit");
            System.out.println("Enter your choice");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    showAvailableBooks(inventory, scanner);
                    break;
                case 2:
                    showCheckedOutBooks(inventory, scanner);
                    break;
                case 3:
                    System.out.println("Thank you for using the Library!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again");
            }
        }
    }

    private static Book[] initializeInventory() {
        Book[] inventory = new Book[5];
        inventory[0] = new Book(1, "978-1-60309-038-4", "All My Friends");
        inventory[1] = new Book(2, "978-0061120084", "To Kill a Mockingbird");
        inventory[2] = new Book(3, "978-0451524935", "1984");
        inventory[3] = new Book(4, "978-0743273565", "The Great Gatsby");
        inventory[4] = new Book(5, "978-0316769488", "The Catcher in the Rye");
        return inventory;
    }

    private static void showAvailableBooks(Book[] inventory, Scanner scanner) {
        System.out.println("\nAvailable Books!");
        boolean hasAvailable = false;

        for (Book book : inventory) {
            if (!book.isCheckedOut()) {
                System.out.printf("ID: %d | ISBN: %s | Title: %s\n", book.getId(), book.getIsbn(), book.getTitle());
                hasAvailable = true;
            }
        }

        if (!hasAvailable) {
            System.out.println("No books available!");
            return;
        }

        System.out.println("\nEnter book ID to check out or hit 0 to cancel: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();

        if (bookId == 0) return;

        for (Book book : inventory) {
            if (book.getId() == bookId && !book.isCheckedOut()) {
                System.out.println("Enter your name: ");
                String name = scanner.nextLine();
                book.checkOut(name);
                System.out.println("Book was checked out successfully to: " + name + "!");
                return;
            }
        }
        System.out.println("Invalid book ID or book is already checked.");
    }

    private static void showCheckedOutBooks(Book[] inventory, Scanner scanner) {
        System.out.println("\nChecked Out Books:");
        boolean hasCheckedOut = false;

        for (Book book : inventory) {
            if (book.isCheckedOut()) {
                System.out.printf("ID: %d | ISBN: %s | Title: %s | Checked out to : %s\n",
                        book.getId(), book.getIsbn(), book.getTitle(), book.getCheckedOutTo());
                hasCheckedOut = true;
            }
        }

        if (!hasCheckedOut) {
            System.out.println("No books are checked out.");
            return;
        }

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("C - Check in a book");
            System.out.println("X - Return to home screen");
            String option = scanner.nextLine();

            if (option.equalsIgnoreCase("X")){
                return;
            } else if (option.equalsIgnoreCase("C")) {
                System.out.println("Enter book ID to check in: ");
                int bookId = scanner.nextInt();
                scanner.nextLine();

            for (Book book : inventory) {
                if (book.getId() == bookId && book.isCheckedOut()) {
                    book.checkIn();
                    System.out.println("Book was checked in!");
                    return;
                }
            }
            System.out.println("Invalid book ID or book is not checked out.");
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

