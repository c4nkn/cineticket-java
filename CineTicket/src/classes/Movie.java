package classes;
import interfaces.IMovie;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Movie implements IMovie {
    public Session session;
    public String movieName;
    public String movieGenre;
    public LocalDate releaseDate;
    public int duration;
    public Float imdbRating;
    public String ageRating;

    // get methods
    public String getMovieName() {
        return movieName;
    }
    public String getMovieGenre() {
        return movieGenre;
    }
    public String getAgeRating() {
        return ageRating;
    }
    public int getDuration() {
        return duration;
    }
    public Float getImdbRating() {
        return imdbRating;
    }
    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    // set methods
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }
    public void setAgeRating(String ageRating) {
        this.ageRating = ageRating;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public void setImdbRating(Float imdbRating) {
        this.imdbRating = imdbRating;
    }
    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    // creates new movies and sets their information.
    // returns list of movies with their information such as name, genre, date, etc.
    public List<Movie> createMovies() {
        List<Movie> movieInfo = new ArrayList<>(5);

        Movie movie1 = new Movie();
        movie1.setMovieName("Guardians of the Galaxy Vol.3");
        movie1.setMovieGenre("Action, Sci-Fi, Adventure, Comedy");
        movie1.setReleaseDate(LocalDate.of(2022, 4, 22));
        movie1.setDuration(150);
        movie1.setImdbRating(8.4F);
        movie1.setAgeRating("13+");

        Movie movie2 = new Movie();
        movie2.setMovieName("John Wick 4");
        movie2.setMovieGenre("Action, Crime, Thriller");
        movie2.setReleaseDate(LocalDate.of(2023, 3, 22));
        movie2.setDuration(169);
        movie2.setImdbRating(8.2F);
        movie2.setAgeRating("R");

        Movie movie3 = new Movie();
        movie3.setMovieName("Thor: Love and Thunder");
        movie3.setMovieGenre("Action, Adventure, Comedy");
        movie3.setReleaseDate(LocalDate.of(2022, 7, 6));
        movie3.setDuration(118);
        movie3.setImdbRating(6.2F);
        movie3.setAgeRating("13+");

        Movie movie4 = new Movie();
        movie4.setMovieName("The Menu");
        movie4.setMovieGenre("Comedy, Horror, Thriller");
        movie4.setReleaseDate(LocalDate.of(2022, 11, 18));
        movie4.setDuration(107);
        movie4.setImdbRating(7.2F);
        movie4.setAgeRating("16+");

        Movie movie5 = new Movie();
        movie5.setMovieName("Babylon");
        movie5.setMovieGenre("Comedy, Drama, History");
        movie5.setReleaseDate(LocalDate.of(2023, 1, 20));
        movie5.setDuration(189);
        movie5.setImdbRating(7.2F);
        movie5.setAgeRating("18+");

        movieInfo.add(movie1); movieInfo.add(movie2); movieInfo.add(movie3); movieInfo.add(movie4); movieInfo.add(movie5);

        return movieInfo;
    }

    public void getMovies(int movieNumber) {
        List<Movie> movies = createMovies();

        String movie1Info = "  Name: " + movies.get(0).movieName + "\n  Genre: " + movies.get(0).movieGenre + "\n  Release Date: " + movies.get(0).releaseDate + "\n  Time: " + movies.get(0).duration + " minutes" + "\n  Rating (IMDb): " + movies.get(0).imdbRating + "\n  Age Rating: " + movies.get(0).ageRating;
        String movie2Info = "  Name: " + movies.get(1).movieName + "\n  Genre: " + movies.get(1).movieGenre + "\n  Release Date: " + movies.get(1).releaseDate + "\n  Time: " + movies.get(1).duration + " minutes" + "\n  Rating (IMDb): " + movies.get(1).imdbRating + "\n  Age Rating: " + movies.get(1).ageRating;
        String movie3Info = "  Name: " + movies.get(2).movieName + "\n  Genre: " + movies.get(2).movieGenre + "\n  Release Date: " + movies.get(2).releaseDate + "\n  Time: " + movies.get(2).duration + " minutes" + "\n  Rating (IMDb): " + movies.get(2).imdbRating + "\n  Age Rating: " + movies.get(2).ageRating;
        String movie4Info = "  Name: " + movies.get(3).movieName + "\n  Genre: " + movies.get(3).movieGenre + "\n  Release Date: " + movies.get(3).releaseDate + "\n  Time: " + movies.get(3).duration + " minutes" + "\n  Rating (IMDb): " + movies.get(3).imdbRating + "\n  Age Rating: " + movies.get(3).ageRating;
        String movie5Info = "  Name: " + movies.get(4).movieName + "\n  Genre: " + movies.get(4).movieGenre + "\n  Release Date: " + movies.get(4).releaseDate + "\n  Time: " + movies.get(4).duration + " minutes" + "\n  Rating (IMDb): " + movies.get(4).imdbRating + "\n  Age Rating: " + movies.get(4).ageRating;

        switch (movieNumber) {
            case 1 -> System.out.println(movie1Info);
            case 2 -> System.out.println(movie2Info);
            case 3 -> System.out.println(movie3Info);
            case 4 -> System.out.println(movie4Info);
            case 5 -> System.out.println(movie5Info);
        }
    }
}