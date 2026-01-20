@Service
public class BookingService {

    @Autowired
    private final BookingRepository repo;
    @Autowired
    private final SeatLockService seatLock;
    @Autowired
    private final OfferService offerService;



    @Transactional
    public Booking book(BookingRequest req) {
        seatLock.lockSeats(req.getShowId(), req.getSeats());

        double amount = offerService.applyOffers(
                req.getAmount(),
                req.getSeats().size(),
                req.getShowTime());

        Booking booking = new Booking();
        booking.setShowId(req.getShowId());
        booking.setUserId(req.getUserId());
        booking.setStatus(BookingStatus.CONFIRMED);
        booking.setTotalAmount(amount);

        return repo.save(booking);
    }

    @Transactional
    public List<Booking> bulkBook(List<BookingRequest> requests) {
        return requests.stream().map(this::book).toList();
    }

    @Transactional
    public void cancelBulk(List<Long> bookingIds) {
        bookingIds.forEach(id -> {
            Booking b = repo.findById(id).orElseThrow();
            b.setStatus(BookingStatus.CANCELLED);
            repo.save(b);
        });
    }
}
