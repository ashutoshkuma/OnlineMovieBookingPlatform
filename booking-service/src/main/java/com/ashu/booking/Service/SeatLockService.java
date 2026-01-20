@Service
public class SeatLockService {

    public void lockSeats(Long showId, List<String> seats) {
        // Redis lock code
        seats.forEach(seat ->
                System.out.println("Locking seat " + seat + " for show " + showId)
        );
    }
}
