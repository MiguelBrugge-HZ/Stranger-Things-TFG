package game.utils;

import java.util.List;
import java.util.Scanner;

public class InputManager {
    private static InputManager instance;
    private final Scanner scanner;

    private InputManager() {
        scanner = new Scanner(System.in);
    }

    public static InputManager getInstance() {
        if (instance == null) {
            instance = new InputManager();
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

    public <T> T chooseOption(String prompt, List<T> options) {
        if (options == null || options.isEmpty()) {
            throw new IllegalArgumentException("Options cannot be empty");
        }

        System.out.println(prompt);
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }

        while (true) {
            int choice = readInt("Choose an option (1-" + options.size() + "): ");
            if (choice >= 1 && choice <= options.size()) {
                return options.get(choice - 1);
            }
            System.out.println("Invalid choice.");
        }
    }
}
