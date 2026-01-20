@Service
public class ShowManagementService {

    @Autowired
    private final ShowRepository repo;


    public Show create(Show show) {
        return repo.save(show);
    }

    public Show update(Long id, Show show) {
        show.setId(id);
        return repo.save(show);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
