package classes;
import java.io.IOException;
import java.util.Scanner;

public class Utils {
    public static void printLogo() {
        String logo = """
                        
                        _            _   _      _        _  \s
                    ___(_)_ __   ___| |_(_) ___| | _____| |_\s
                   / __| | '_ \\ / _ \\ __| |/ __| |/ / _ \\ __|
                  | (__| | | | |  __/ |_| | (__|   <  __/ |_\s
                   \\___|_|_| |_|\\___|\\__|_|\\___|_|\\_\\___|\\__|
                \s
                              developed by c4nkn
                """;

        System.out.println(logo);
    }
    public static void printLine() {
        System.out.println("=============================================");
    }
    public static int optionableMenu(String[] options) {
        Scanner scanner = new Scanner(System.in);
        int selectedOpt = -1;
        boolean isSelected = false;
        int menu_idx = 1;

        for (String option : options) {
            if (option.equals("Exit") || option.equals("Back")) {
                System.out.println("\n0" + ". " + option);
                menu_idx -= 1;
            } else {
                System.out.println(menu_idx + ". " + option);
                menu_idx += 1;
            }
        }
        printLine();

        while (!isSelected) {
            System.out.print("Enter an option: ");

            if (scanner.hasNextInt()) { // check if its int
                selectedOpt = scanner.nextInt();

                if (selectedOpt >= 0 && selectedOpt <= menu_idx) {
                    isSelected = true;
                } else {
                    System.out.println("Invalid option.");
                }
            } else {
                scanner.next(); // skip non-int input
                System.out.println("Invalid input.");
            }
        }

        return selectedOpt;
    }
    public static void clearConsole() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}
