package classes;
import interfaces.ITheater;

import java.util.*;

public class Theater implements ITheater {
    public String theaterName;
    public int capacity;

    // get methods
    public String getTheaterName() {
        return theaterName;
    }
    public int getCapacity() {
        return capacity;
    }

    // set methods
    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String createTheaters() {
        Theater theater = new Theater();
        theater.capacity = 91;

        Random random = new Random();
        char randomChar = (char) ('A' + random.nextInt(26)); //A to Z
        theater.theaterName = Character.toString(randomChar);

        return theater.theaterName;
    }

    public List<String> seatSelection(int numberOfTickets) {
        String screen = "       ████████████████████████████████████████████████████";
        String doors = "[ <Door                                                    Door> ]";
        char[] letters = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M' };

        int rowSize = 7;
        int columnSize = 13;
        int seatsCount = numberOfTickets;

        // create seats and randomly fills them
        boolean[][] seats = new boolean[rowSize][columnSize];
        Random random = new Random();
        for (int i = 0; i < random.nextInt(6, 24); i++)
        {
            seats[random.nextInt(0, rowSize)][random.nextInt(0, columnSize)] = true;
        }

        System.out.println(screen + "\n\n" + doors + "\n");
        Dictionary<Character, Integer> rowAndLetter = new Hashtable<>();

        for (int i = 0; i < rowSize; i++) {
            System.out.print("            ");

            // I have changed colors by using ANSI escape sequences (ie. \033[0m (reset)).
            for (int j = 0; j < columnSize; j++) {
                if (j == columnSize - 1) {
                    if (seats[i][j]) {
                        System.out.print("\033[31m");
                        System.out.print("[x]            " + "\033[0m" + letters[i]);
                    } else {
                        System.out.print("\033[0m");
                        System.out.print("[_]            " + "\033[0m" + letters[i]);
                    }
                } else {
                    if (seats[i][j]) {
                        System.out.print("\033[31m");
                        System.out.print("[x]");
                    } else {
                        System.out.print("\033[0m");
                        System.out.print("[_]");
                    }
                }
            }

            rowAndLetter.put(letters[i], i);
            System.out.println();
        }

        System.out.println("\n             1  2  3  4  5  6  7  8  9  10 11 12 13");
        Utils.printLine();

        Scanner scanner = new Scanner(System.in);
        boolean seatSelected = false;
        int ticketNumber = 1;
        List<String> finalSeats = new ArrayList<>();

        while (!seatSelected) {
            String input;
            String regex = "[A-Z][1-9]|1[0-3]"; // limits input to only char-int like A1, C8.

            do {
                System.out.print("Choose seat (ticket " + ticketNumber + "): ");
                input = scanner.nextLine().trim(); // .trim() deletes spaces

                if (!input.matches(regex)) {
                    System.out.println("Invalid input.");
                    continue;
                }

                break;
            } while (true);

            char inputChar = input.charAt(0);
            int inputColumn = Integer.parseInt(input.substring(1)); // got number as str and converted it to int
            int inputRow = rowAndLetter.get(inputChar);

            if (seats[inputRow][inputColumn-1]) { // column index starts with 0 (if user input=1 this equals 0)
                System.out.print("Seat is taken.\n");
            } else {
                System.out.print("Seat " + input + " choosed successfully!\n");
                seats[inputRow][inputColumn] = true;
                finalSeats.add(input);
                seatsCount--;
                ticketNumber++;

                if (seatsCount == 0)
                {
                    seatSelected = true;
                }
            }
        }

        return finalSeats;
    }
}
