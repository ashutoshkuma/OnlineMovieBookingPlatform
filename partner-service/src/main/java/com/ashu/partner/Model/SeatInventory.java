@Entity
public class SeatInventory {
    @Id @GeneratedValue
    private Long id;
    private Long showId;
    private String seatNumber;
    private boolean available;
}
