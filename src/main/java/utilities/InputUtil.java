package src.main.java.utilities;

import java.util.Scanner;

public class InputUtil {

    private static final Scanner scanner = new Scanner(System.in);


    public static String getStringInput() {
        System.out.print("Waiting for input... ");
        while (!scanner.hasNextLine()) {
            System.out.println("Invalid input, try again: ");
            scanner.nextLine();  // Clear invalid input
        }
        return scanner.nextLine();
    }

    public static int getIntInput() {
        System.out.print("Waiting for integer input... ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input, please enter a number: ");
            scanner.nextLine();  // Clear invalid input
        }
        int input = scanner.nextInt();
        scanner.nextLine();  // Consume the newline
        return input;
    }

    // Additional methods for other types of inputs can be added similarly


}
