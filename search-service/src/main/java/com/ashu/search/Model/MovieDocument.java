@Document(indexName = "movie_shows")
public class MovieShowDocument {
    @Id
    private String showId;
    private String movieId;
    private String theatreId;
    private String theatreName;
    private String city;
    private String language;
    private LocalDate showDate;
    private LocalTime showTime;
}
