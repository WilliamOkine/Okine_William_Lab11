package src;
import java.util.Scanner;
public class SafeInput {

// Get Non Zero Length String

    public static String getNonZeroLenStr(Scanner scanner, String message) {
        String input = "";
        do {
            System.out.println(message);
            input = scanner.nextLine().trim();
        } while (input.isEmpty());
        return input;
    }

    //Get Non empty String
    public static String getNonEmptyString(Scanner scanner, String message) {
        String input = "";
        do {
            System.out.println(message);
            input = scanner.nextLine().trim();
        } while (input.isEmpty());
        return input;
    }

    //GetInt
    public static int getInt(Scanner pipe, String prompt) {
        int value = 0; // Default value
        boolean validInput = false;

        do {
            System.out.print(prompt);

            if (pipe.hasNextInt()) {
                value = pipe.nextInt();
                validInput = true;
            } else {
                String trash = pipe.next(); // Read and discard non-integer input
                System.out.println("Invalid input. Please enter an integer.");
            }
        } while (!validInput);

        pipe.nextLine(); // Clear the newline character from the input

        return value;
    }

    //getDouble
    public static double getDouble(Scanner pipe, String prompt) {
        double value = 0;
        boolean validInput = false;

        do {
            System.out.print(prompt);

            if (pipe.hasNextDouble()) {
                value = pipe.nextDouble();
                validInput = true;
            } else {
                String trash = pipe.next();
                System.out.println("Invalid input. Please enter a double value.");
            }
        } while (!validInput);

        pipe.nextLine();

        return value;
    }

    //Get Ranged Integer


    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int value = 0;
        boolean validInput = false;

        do {
            System.out.print(prompt + " [" + low + " - " + high + "]: ");

            if (pipe.hasNextInt()) {
                value = pipe.nextInt();
                if (value >= low && value <= high) {
                    validInput = true;
                } else {
                    System.out.println("Invalid input. Please enter an integer within the specified range.");
                }
            } else {
                String trash = pipe.next(); // Read and discard non-integer input
                System.out.println("Invalid input. Please enter an integer value.");
            }
        } while (!validInput);

        pipe.nextLine(); // Clear the newline character from the input

        return value;
    }


    //Get Ranged Double
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double value = 0.0; // Default value
        boolean validInput = false;

        do {
            System.out.print(prompt + " [" + low + " - " + high + "]: ");

            if (pipe.hasNextDouble()) {
                value = pipe.nextDouble();
                if (value >= low && value <= high) {
                    validInput = true;
                } else {
                    System.out.println("Invalid input. Please enter a double value within the specified range.");
                }
            } else {
                String trash = pipe.next(); // Read and discard non-double input
                System.out.println("Invalid input. Please enter a double value.");
            }
        } while (!validInput);

        pipe.nextLine(); // Clear the newline character from the input

        return value;
    }

    //Get Y/N Confirm
    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        boolean confirmed = false;
        boolean validInput = false;

        do {
            System.out.print(prompt);
            String input = pipe.nextLine().trim().toLowerCase();

            if (input.equals("y") || input.equals("yes")) {
                confirmed = true;
                validInput = true;
            } else if (input.equals("n") || input.equals("no")) {
                confirmed = false;
                validInput = true;
            } else {
                System.out.println("Invalid input. Please enter Y or N.");
            }
        } while (!validInput);

        return confirmed;
    }


    //GetRegExString
    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        String input;
        boolean validInput = false;


        do {
            System.out.print(prompt);

            if (pipe.hasNextLine()) {
                input = pipe.nextLine();
                if (input.matches(regEx)) {
                    validInput = true;
                } else {
                    System.out.println("Invalid input. Please enter a string matching the specified pattern.");
                }
            } else {
                input = pipe.next(); // Read and discard non-line input
                System.out.println("Invalid input. Please enter a string.");
            }
        } while (!validInput);

        return input;
    }


    // Pretty Header
    public static void prettyHeader(String msg) {
        int headerWidth = 60;
        int msgLength = msg.length();
        int spaceLength = (headerWidth - msgLength - 6) / 2;


        for (int i = 0; i < headerWidth; i++) {
            System.out.print("*");
        }
        System.out.println();


        System.out.print("***");
        for (int i = 0; i < spaceLength; i++) {
            System.out.print(" ");
        }
        System.out.print(msg);
        for (int i = 0; i < spaceLength; i++) {
            System.out.print(" ");
        }

        if (msgLength % 2 != 0) {
            System.out.print(" ");
        }
        System.out.println("***");


        for (int i = 0; i < headerWidth; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}






