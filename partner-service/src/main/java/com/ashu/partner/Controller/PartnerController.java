@RestController
@RequestMapping("/api/v1/partners")
public class PartnerController {

    @Autowired
    private final ShowManagementService showService;

    @Autowired
    private final SeatInventoryService seatService;



    @PostMapping("/shows")
    public Show create(@RequestBody Show show) {
        return showService.create(show);
    }

    @PutMapping("/shows/{id}")
    public Show update(@PathVariable Long id, @RequestBody Show show) {
        return showService.update(id, show);
    }

    @DeleteMapping("/shows/{id}")
    public void delete(@PathVariable Long id) {
        showService.delete(id);
    }

    @PutMapping("/shows/{showId}/seats")
    public void updateSeats(@PathVariable Long showId,
                            @RequestBody List<SeatInventory> seats) {
        seatService.updateInventory(showId, seats);
    }
}
