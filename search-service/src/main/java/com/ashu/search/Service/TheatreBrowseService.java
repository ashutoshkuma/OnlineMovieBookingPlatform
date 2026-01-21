@Service
public class TheatreBrowseService {

    @Autowired
    private MovieShowRepository repo;


    public List<MovieShowDocument> browse(String movieId,
                                          String city,
                                          LocalDate date) {
        return repo.find(movieId, city, date);
    }
}
