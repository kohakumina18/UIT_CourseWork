package LAB03;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class GENERIC_CAU04 {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.displayMenu();
    }
}

class Menu {
    private Scanner scanner;
    private List<String> listCars;

    public Menu() {
        scanner = new Scanner(System.in);
        listCars = new LinkedList<>();
        listCars.add("BMW");
        listCars.add("Ford");
        listCars.add("Chervolet");
        listCars.add("Toyota");
        listCars.add("Nissan");
        listCars.add("Honda");
        listCars.add("Mazda");
        listCars.add("Volkswagen");
        listCars.add("Volvo");
        listCars.add("Mercedes");
        listCars.add("Hyundai");
        listCars.add("Kia");
    }

    public void displayMenu() {
        int choice;
        do {
        	System.out.flush();
            System.out.println("Menu:");
            System.out.println("1. Display Car List");
            System.out.println("2. Add a Car");
            System.out.println("3. Modify a Car");
            System.out.println("4. Uppercase all Cars");
            System.out.println("5. Sort Car List");
            System.out.println("6. Remove Cars in Range");
            System.out.println("7. Reverse Car List");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    displayCarList();
                    break;
                case 2:
                    addCar();
                    break;
                case 3:
                    modifyCar();
                    break;
                case 4:
                    uppercaseAllCars();
                    break;
                case 5:
                    sortCarList();
                    break;
                case 6:
                    removeCarsInRange();
                    break;
                case 7:
                    reverseCarList();
                    break;
                case 8:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 8.");
            }
        } while (choice != 8);
    }

    private void displayCarList() {
        System.out.println("Car List:");
        for (String car : listCars) {
            System.out.println(car);
        }
    }

    private void addCar() {
        System.out.print("Enter the new car: ");
        String newCar = scanner.nextLine();
        listCars.add(newCar);
        System.out.println("Car added successfully.");
    }

    private void modifyCar() {
        System.out.print("Enter the index of the car to modify: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        if (index >= 0 && index < listCars.size()) {
            System.out.print("Enter the new value: ");
            String newValue = scanner.nextLine();
            listCars.set(index, newValue);
            System.out.println("Car modified successfully.");
        } else {
            System.out.println("Invalid index.");
        }
    }

    private void uppercaseAllCars() {
        ListIterator<String> iterator = listCars.listIterator();
        while (iterator.hasNext()) {
            String car = iterator.next();
            iterator.set(car.toUpperCase());
        }
        System.out.println("All cars converted to uppercase.");
    }

    private void sortCarList() {
        Collections.sort(listCars);
        System.out.println("Car list sorted.");
    }

    private void removeCarsInRange() {
        System.out.print("Enter the starting index: ");
        int start = scanner.nextInt();
        System.out.print("Enter the ending index: ");
        int end = scanner.nextInt();
        if (start >= 0 && end < listCars.size() && start <= end) {
            listCars.subList(start, end + 1).clear();
            System.out.println("Cars removed successfully.");
        } else {
            System.out.println("Invalid range.");
        }
    }

    private void reverseCarList() {
        Collections.reverse(listCars);
        System.out.println("Car list reversed.");
    }
}
