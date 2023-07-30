package src;
import java.util.ArrayList;
import java.util.Scanner;

public class ListMaker {
    private static ArrayList<String> list = new ArrayList<>(); // Declare and initialize the ArrayList to store the items.

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        final String menu = "A - Add D - Delete P - Print Q - Quit: ";
        boolean quit = false;

        while (!quit) {
            displayMenu(); // Display the menu options to the user.
            String choice = SafeInput.getRegExString( scan, menu, "[AaDdPpQq]");
            // Get the user's choice using the SafeInput.getRegExString method, which ensures a valid menu option.

            System.out.println();

            switch (choice.toLowerCase()) {
                case "a":
                    addItemToList(scan); // Call the method to add an item to the list.
                    break;
                case "d":
                    deleteItemFromList(scan); // Call the method to delete an item from the list.
                    break;
                case "p":
                    printList(); // Call the method to print the current list.
                    break;
                case "q":
                    quit = confirmQuit(scan); // Call the method to confirm quitting the program.
                    break;
            }
        }

        System.out.println("Goodbye!");
    }

    private static void displayMenu() {
        System.out.println("========== MENU ==========");
        System.out.println("A - Add an item to the list");
        System.out.println("D - Delete an item from the list");
        System.out.println("P - Print the list");
        System.out.println("Q - Quit the program");
        System.out.println("==========================");
    }

    private static void addItemToList(Scanner scan) {
        System.out.print("Enter the item to add: ");
        String newItem = scan.nextLine();
        list.add(newItem); // Add the user's input to the ArrayList.
        System.out.println("Item added to the list!");
    }

    private static void deleteItemFromList(Scanner scan) {
        if (list.isEmpty()) {
            System.out.println("The list is empty. Nothing to delete.");
            return;
        }

        System.out.println("Current list:");
        printNumberedList(); // Display the current list with item numbers.

        int itemNumber = SafeInput.getRangedInt(scan, "Enter the item number to delete: ", 1, list.size());
        // Get the item number to delete using SafeInput.getRangedInt, which ensures a valid number within the list size.

        list.remove(itemNumber - 1); // Remove the item from the ArrayList.
        System.out.println("Item deleted from the list!");
    }

    private static void printList() {
        if (list.isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            System.out.println("Current list:");
            for (String item : list) {
                System.out.println("- " + item); // Display the items in the list.
            }
        }
    }

    private static void printNumberedList() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i)); // Display the items in the list with item numbers.
        }
    }

    private static boolean confirmQuit(Scanner scan) {
        return SafeInput.getYNConfirm(scan, "Are you sure you want to quit? (Y/N): ");
        // Get the user's confirmation to quit using SafeInput.getYNConfirm.
    }
}


