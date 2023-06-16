package interfaces;
import java.util.List;

public interface IReservation {
    void getCustomerInfo();
    void getMovieSelection(String[] customerNames, int numberOfTickets);
    void getAvailableSessions(String[] customerNames, int numberOfTickets, int selectedMovie);
    void getSeatSelection(String[] customerNames, int numberOfTickets, int selectedMovie, int selectedSession);
    void showTicketInfo(String[] customerNames, int numberOfTickets, int selectedMovie, int selectedSession, List<String> selectedSeats);
    void confirmation();
}
