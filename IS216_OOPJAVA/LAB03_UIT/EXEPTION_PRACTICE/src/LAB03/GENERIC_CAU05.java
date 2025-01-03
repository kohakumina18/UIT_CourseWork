package LAB03;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class GENERIC_CAU05 {
	private static Set<String> set1;
    private static Set<String> set2;
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        set1 = new TreeSet<>();
        set2 = new TreeSet<>();

        displayMenu();
    }

    private static void displayMenu() {
        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add subjects to Set 1");
            System.out.println("2. Add subjects to Set 2");
            System.out.println("3. Display all subjects");
            System.out.println("4. Perform Intersection (Giao)");
            System.out.println("5. Perform Union (Hợp)");
            System.out.println("6. Perform Difference (Hiệu) (Set 1 - Set 2)");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addSubjects(set1);
                    break;
                case 2:
                    addSubjects(set2);
                    break;
                case 3:
                    displayAllSubjects();
                    break;
                case 4:
                    performIntersection();
                    break;
                case 5:
                    performUnion();
                    break;
                case 6:
                    performDifference();
                    break;
                case 7:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
            }
        } while (choice != 7);
    }

    private static void addSubjects(Set<String> set) {
        System.out.print("Enter subjects separated by commas: ");
        String input = scanner.nextLine();
        String[] subjects = input.split(",");
        set.addAll(Arrays.asList(subjects));
        System.out.println("Subjects added successfully.");
    }

    private static void displayAllSubjects() {
        System.out.println("All Subjects in Set 1: " + set1);
        System.out.println("All Subjects in Set 2: " + set2);
    }

    private static void performIntersection() {
        Set<String> intersection = new TreeSet<>(set1);
        intersection.retainAll(set2);
        System.out.println("Intersection (Giao): " + intersection);
    }

    private static void performUnion() {
        Set<String> union = new TreeSet<>(set1);
        union.addAll(set2);
        System.out.println("Union (Hợp): " + union);
    }

    private static void performDifference() {
        Set<String> difference = new TreeSet<>(set1);
        difference.removeAll(set2);
        System.out.println("Difference (Hiệu) (Set 1 - Set 2): " + difference);
    }
}
