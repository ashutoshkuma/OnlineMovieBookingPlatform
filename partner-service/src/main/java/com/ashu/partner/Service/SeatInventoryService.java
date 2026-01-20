@Service
public class SeatInventoryService {

    @Autowired
    private final SeatInventoryRepository repo;



    public void updateInventory(Long showId,
                                List<SeatInventory> seats) {
        seats.forEach(s -> s.setShowId(showId));
        repo.saveAll(seats);
    }
}
