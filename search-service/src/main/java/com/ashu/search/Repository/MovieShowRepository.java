

@Repository
public class MovieShowRepository {
    public List<MovieShowDocument> find(String movieId,
                                        String city,
                                        LocalDate date) {
        return List.of(); // Elasticsearch stub
    }
}
