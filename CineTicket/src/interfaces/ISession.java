package interfaces;
import java.time.LocalDate;
import java.util.List;

public interface ISession {
    int getSessions(int selectedMovie);
    List<String> createSessions(int selectedMovie, LocalDate sessionDate);
}
