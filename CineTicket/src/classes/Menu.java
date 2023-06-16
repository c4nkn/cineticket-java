package classes;
import java.util.List;

public class Menu {
    public static void loadMainMenu() {
        System.out.println("Welcome!");
        System.out.println("Please choose what do you want do.");

        String[] options = { "Purchase ticket", "List movies", "Exit" };
        Utils.printLine();
        int selectedOpt = Utils.optionableMenu(options);

        switch (selectedOpt) {
            case 1 -> {
                Reservation reservation = new Reservation();
                reservation.getCustomerInfo();
            }
            case 2 -> Menu.listMovies();
            case 0 -> System.out.close();
        }
    }
    public static void movieInfoMenu() {
        String[] opts = { "Show available sessions", "Back" };
        int selected = Utils.optionableMenu(opts);

        if (selected == 1)
        {
            Reservation reservation = new Reservation();
            reservation.getCustomerInfo();
        }
        else if (selected == 0)
        {
            listMovies();
        }
    }
    public static void listMovies() {
        Utils.printLogo();
        System.out.println("\nYou can see movie information by choosing movie.");
        Utils.printLine();

        Movie movie = new Movie();
        List<Movie> movies = movie.createMovies();

        String[] options = { movies.get(0).getMovieName(), movies.get(1).getMovieName(), movies.get(2).getMovieName(), movies.get(3).getMovieName(), movies.get(4).getMovieName(), "Back" };
        int selectedMovie = Utils.optionableMenu(options);

        switch (selectedMovie) {
            case 1 -> {
                Utils.printLogo();
                System.out.println("Movie Information");
                Utils.printLine();
                movie.getMovies(1);
                Utils.printLine();
                movieInfoMenu();
            }
            case 2 -> {
                Utils.printLogo();
                System.out.println("Movie Information");
                Utils.printLine();
                movie.getMovies(2);
                Utils.printLine();
                movieInfoMenu();
            }
            case 3 -> {
                Utils.printLogo();
                System.out.println("Movie Information");
                Utils.printLine();
                movie.getMovies(3);
                Utils.printLine();
                movieInfoMenu();
            }
            case 4 -> {
                Utils.printLogo();
                System.out.println("Movie Information");
                Utils.printLine();
                movie.getMovies(4);
                Utils.printLine();
                movieInfoMenu();
            }
            case 5 -> {
                Utils.printLogo();
                System.out.println("Movie Information");
                Utils.printLine();
                movie.getMovies(5);
                Utils.printLine();
                movieInfoMenu();
            }
            case 0 -> {
                Utils.printLogo();
                loadMainMenu();
            }
        }
    }
}
