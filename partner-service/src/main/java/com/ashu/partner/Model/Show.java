@Entity
public class Show {
    @Id @GeneratedValue
    private Long id;
    private String movieId;
    private Long theatreId;
    private LocalDateTime startTime;
}
