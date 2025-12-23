package game.utils;

import java.util.Scanner;

public class InputFacade {
    private static InputFacade instance;
    private final Scanner scanner;

    private InputFacade() {
        scanner = new Scanner(System.in);
    }

    public static InputFacade getInstance() {
        if (instance == null) {
            instance = new InputFacade();
        }
        return instance;
    }

    public String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    public boolean readYesNo(String prompt) {
        while (true) {
            System.out.print(prompt + " [Y/N]: ");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("Y")) return true;
            if (input.equalsIgnoreCase("N")) return false;
            System.out.println("Invalid input. Enter Y or N.");
        }
    }
}
