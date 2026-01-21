@RestController
@RequestMapping("/api/v1/bookings")
public class BookingController {

    @Autowired
    private BookingService service;

    @PostMapping
    public Booking book(@RequestBody BookingRequest request) {
        return service.book(request);
    }

    @PostMapping("/bulk")
    public List<Booking> bulkBook(@RequestBody List<BookingRequest> requests) {
        return service.bulkBook(requests);
    }

    @PostMapping("/cancel")
    public void cancel(@RequestBody List<Long> bookingIds) {
        service.cancelBulk(bookingIds);
    }
}
