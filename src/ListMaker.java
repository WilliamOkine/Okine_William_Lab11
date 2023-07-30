package src;
import java.util.ArrayList;
import java.util.Scanner;

public class ListMaker {
    private static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        final String menu = "A - Add D - Delete P - Print Q - Quit: ";
        boolean quit = false;

        while (!quit) {
            displayMenu(); // Display the menu options to the user.
            String choice = SafeInput.getRegExString( scan, menu, "[AaDdPpQq]");


            System.out.println();

            switch (choice.toLowerCase()) {
                case "a":
                    addItemToList(scan);
                    break;
                case "d":
                    deleteItemFromList(scan);
                    break;
                case "p":
                    printList();
                    break;
                case "q":
                    quit = confirmQuit(scan);
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
        list.add(newItem);
        System.out.println("Item added to the list!");
    }

    private static void deleteItemFromList(Scanner scan) {
        if (list.isEmpty()) {
            System.out.println("The list is empty. Nothing to delete.");
            return;
        }

        System.out.println("Current list:");
        printNumberedList();

        int itemNumber = SafeInput.getRangedInt(scan, "Enter the item number to delete: ", 1, list.size());


        list.remove(itemNumber - 1);
        System.out.println("Item deleted from the list!");
    }

    private static void printList() {
        if (list.isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            System.out.println("Current list:");
            for (String item : list) {
                System.out.println("- " + item);
            }
        }
    }

    private static void printNumberedList() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }

    private static boolean confirmQuit(Scanner scan) {
        return SafeInput.getYNConfirm(scan, "Are you sure you want to quit? (Y/N): ");

    }
}


