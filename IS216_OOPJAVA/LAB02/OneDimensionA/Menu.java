package com.oneDArray.models;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Array Operations Menu!");
        
        // Creating an instance of the OneD_Arr class
        OneD_Arr array = null;

        boolean exit = false;
        while (!exit) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Initialize array");
            System.out.println("2. Input array elements");
            System.out.println("3. Output array elements");
            System.out.println("4. Find minimum value");
            System.out.println("5. Find maximum value");
            System.out.println("6. Search for an element");
            System.out.println("7. Delete a number");
            System.out.println("8. Order array");
            System.out.println("9. Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter the size of the array: ");
                    int size = scanner.nextInt();
                    array = new OneD_Arr(size);
                    System.out.println("Array initialized successfully." +"\n"+ "You can input its elements now.");
                    break;
                case 2:
                    if (array == null) {
                        System.out.println("Array not initialized. Please initialize the array first.");
                    } else {
                        int[] inputArray = new int[array.getN()];
                        System.out.println("Enter array elements:");
                        for (int i = 0; i < array.getN(); i++) {
                            inputArray[i] = scanner.nextInt();
                        }
                        array.input(inputArray);
                        System.out.println("Array elements updated successfully.");
                    }
                    break;
                case 3:
                    if (array == null) {
                        System.out.println("Array not initialized. Please initialize the array first.");
                    } else {
                        array.output();
                    }
                    break;
                case 4:
                    if (array == null) {
                        System.out.println("Array not initialized. Please initialize the array first.");
                    } else {
                        System.out.println("Minimum value in the array: " + array.binarySearchMin());
                    }
                    break;
                case 5:
                    if (array == null) {
                        System.out.println("Array not initialized. Please initialize the array first.");
                    } else {
                        System.out.println("Maximum value in the array: " + array.binarySearchMax());
                    }
                    break;
                case 6:
                    if (array == null) {
                        System.out.println("Array not initialized. Please initialize the array first.");
                    } else {
                        System.out.print("Enter the element to search: ");
                        int element = scanner.nextInt();
                        if (array.binarySearch(element)) {
                            System.out.println("Element found in the array.");
                        } else {
                            System.out.println("Element not found in the array.");
                        }
                    }
                    break;
                case 7:
                    if (array == null) {
                        System.out.println("Array not initialized. Please initialize the array first.");
                    } else {
                        System.out.print("Enter the number to delete: ");
                        int numToDelete = scanner.nextInt();
                        array.deleteNumber(numToDelete);
                        System.out.println("Number deleted from the array.");
                    }
                    break;
                case 8:
                    if (array == null) {
                        System.out.println("Array not initialized. Please initialize the array first.");
                    } else {
                        System.out.print("Enter 'asc' for ascending order or 'dsc' for descending order: ");
                        String order = scanner.next();
                        array.orderArray(order);
                        System.out.println("Array ordered successfully.");
                    }
                    break;
                case 9:
                    exit = true;
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
        scanner.close();
    }
}
