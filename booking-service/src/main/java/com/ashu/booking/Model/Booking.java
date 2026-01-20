@Entity
public class Booking {
    @Id @GeneratedValue
    private Long id;
    private Long showId;
    private String userId;
    private BookingStatus status;
    private double totalAmount;


}
