package classes;
import interfaces.IReservation;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.List;

public class Reservation implements IReservation {
    public Session session;
    public Movie movie;
    public Theater theater;
    public int ticketPrice;
    public int numberOfTickets;
    public String selectedSeat;
    public String[] customerName;

    // get methods
    public int getNumberOfTickets() {
        return numberOfTickets;
    }
    public int getTicketPrice() {
        return ticketPrice;
    }
    public String[] getCustomerName() {
        return customerName;
    }
    public String getSelectedSeat() {
        return selectedSeat;
    }

    // set methods
    public void setSelectedSeat(String selectedSeat) {
        this.selectedSeat = selectedSeat;
    }
    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
    public void setCustomerName(String[] customerName) {
        this.customerName = customerName;
    }
    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public void getCustomerInfo(){
        Utils.clearConsole();
        Utils.printLogo();
        System.out.println("Select how many tickets you want to buy.");
        Utils.printLine();

        Scanner scanner = new Scanner(System.in);

        while (true) { // do until breaks
            System.out.print("Enter number of tickets: ");
            if (scanner.hasNextInt()) {
                numberOfTickets = scanner.nextInt();
                scanner.nextLine();

                if (numberOfTickets > 0 && numberOfTickets < 65) {
                    break;
                } else {
                    System.out.println("Invalid number. Choose between 1-65.");
                }
            } else {
                scanner.next();
                System.out.println("Invalid input.");
            }
        }

        String[] customerNames = new String[numberOfTickets];
        //System.out.println(Arrays.toString(customerNames));

        for (int i = 0; i < numberOfTickets; i++) {
            System.out.print("Name (ticket " + (i + 1) + "): ");
            String customerName = scanner.nextLine();
            customerNames[i] = customerName;
        }

        getMovieSelection(customerNames, numberOfTickets);
    }

    public void getMovieSelection(String[] customerNames, int numberOfTickets) {
        Utils.clearConsole();
        Utils.printLogo();

        Movie movie = new Movie();
        List<Movie> movies = movie.createMovies();

        System.out.println("Please, select movie.");
        Utils.printLine();
        String[] options = { movies.get(0).getMovieName(), movies.get(1).getMovieName(), movies.get(2).getMovieName(), movies.get(3).getMovieName(), movies.get(4).getMovieName() };

        int selectedMovie = Utils.optionableMenu(options);
        getAvailableSessions(customerNames, numberOfTickets, selectedMovie-1);
    }

    public void getAvailableSessions(String[] customerNames, int numberOfTickets, int selectedMovie) {
        Utils.clearConsole();
        Utils.printLogo();
        System.out.println("Please, select session.");
        Utils.printLine();

        Session session = new Session();
        int selectedSession = session.getSessions(selectedMovie);

        getSeatSelection(customerNames, numberOfTickets, selectedMovie, selectedSession-1);
    }

    public void getSeatSelection(String[] customerNames, int numberOfTickets, int selectedMovie, int selectedSession) {
        Utils.clearConsole();
        Utils.printLogo();
        System.out.println("Please, select seat(s).");
        System.out.println("Empty seat: [_]     Taken seat: [x]");
        Utils.printLine();

        Theater theater = new Theater();
        List<String> finalSeats = theater.seatSelection(numberOfTickets);
        showTicketInfo(customerNames, numberOfTickets, selectedMovie, selectedSession, finalSeats);
    }

    public void showTicketInfo(String[] customerNames, int numberOfTickets, int selectedMovie, int selectedSession, List<String> selectedSeats) {
        Utils.clearConsole();
        Utils.printLogo();

        Movie movie = new Movie();
        List<Movie> movies = movie.createMovies();
        String movieName = movies.get(selectedMovie).movieName;
        int movieTime = movies.get(selectedMovie).duration;

        Session session = new Session();
        LocalDate today = LocalDate.now();
        List<String> sessions = session.createSessions(selectedMovie, today);

        Theater theater = new Theater();
        String theaterName = theater.createTheaters();

        System.out.print("Name(s): ");
        for (int i = 0; i < customerNames.length; i++) {
            System.out.print(customerNames[i]);
            if (i < customerNames.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("\nMovie: " + movieName);
        System.out.println("Session: " + sessions.get(selectedSession));
        System.out.println("Time: " + movieTime);
        System.out.println("Theater: " + theaterName);
        System.out.print("Selected seat(s):" + selectedSeats.get(0));
        for (int i = 1; i < selectedSeats.size(); i++) {
            System.out.print(", " + selectedSeats.get(i));
        }
        System.out.println();
        Utils.printLine();
        confirmation();
    }

    public void confirmation() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you confirm ticket? (y/N): ");
        String confirmation = scanner.nextLine();

        if (confirmation.equalsIgnoreCase("Y")) {
            System.out.print("\033[32m");
            System.out.println("\nTicket confirmed. Ticket ID: #2478");
            System.out.print("\033[0m");
            System.out.println("Please, note this ticket ID. Returning main menu... (60s)");
            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Menu.loadMainMenu();
        } else if (confirmation.equalsIgnoreCase("N")) {
            System.out.print("\033[31m");
            System.out.println("\nTicket cancelled.");
            System.out.print("\033[0m");
            System.out.println("Returning main menu... (5s)");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Menu.loadMainMenu();
        } else {
            System.out.println("Invalid input.");
            confirmation();
        }
    }
}