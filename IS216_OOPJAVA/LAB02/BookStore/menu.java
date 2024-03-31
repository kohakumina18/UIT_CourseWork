package com.bookstore.models;

import java.util.Scanner;

public class menu {
    private Scanner scanner;

    public menu() {
        scanner = new Scanner(System.in);
    }


    public void displayMenu() {
        System.out.println("Bookstore Menu:");
        System.out.println("1. Add a book");
        System.out.println("2. Pick books - See info or calculate cost");
        System.out.println("3. Return");
        System.out.println("4. Exit");
    }


    public int getUserChoice() {
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        return choice;
    }


    public void closeScanner() {
        scanner.close();
    }
}
