package classes;
import interfaces.ISession;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class Session implements ISession {
    public Movie movie;
    public Theater theater;
    public String time;
    public String format;

    // get methods
    public String getFormat() {
        return format;
    }
    public String getTime() {
        return time;
    }

    // set methods
    public void setTime(String time) {
        this.time = time;
    }
    public void setFormat(String format) {
        this.format = format;
    }

    public int getSessions(int selectedMovie) {
        Movie movie = new Movie();
        List<Movie> movies = movie.createMovies();

        LocalDate today = LocalDate.now();
        Random random = new Random();

        int movieTime = movies.get(selectedMovie).duration;
        int timeHour = movieTime / 60;
        int timeMinute = movieTime - timeHour*2;

        String[] formats = {"Subtitled", "Dubbed"};

        List<String> sessionTimes;
        sessionTimes = createSessions(selectedMovie, today);
        List<String> sessions = new ArrayList<>();

        for (String sessionTime : sessionTimes) {
            Session session = new Session();
            session.format = formats[random.nextInt(formats.length)];
            session.time = sessionTime;

            sessions.add(session.time + " (" + session.format + ")");
        }

        String[] sessionArray = sessions.toArray(new String[0]);
        return Utils.optionableMenu(sessionArray);
    }

    public List<String> createSessions(int selectedMovie, LocalDate sessionDate) {
        Movie movie = new Movie();
        List<Movie> movies = movie.createMovies();

        int year = sessionDate.getYear();
        int month = sessionDate.getMonthValue();
        int day = sessionDate.getDayOfMonth();

        List<String> sessionTimes = new ArrayList<>();

        LocalDateTime startTime = LocalDateTime.of(year, month, day, 11, 0, 0);
        LocalDateTime endTime = LocalDateTime.of(year, month, day, 23, 50, 0);
        int duration = (movies.get(selectedMovie).duration + 20);

        LocalDateTime currentTime = startTime;

        // Formats dateTime -> like this: 6/16/23, 11:00 AM
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(Locale.getDefault());

        while (currentTime.isBefore(endTime) || currentTime.isEqual(endTime)) {
            String formattedTime = currentTime.format(formatter);
            sessionTimes.add(formattedTime);
            currentTime = currentTime.plusMinutes(duration);
        }

        return sessionTimes;
    }
}
