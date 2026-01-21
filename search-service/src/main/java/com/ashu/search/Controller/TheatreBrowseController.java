@RestController
@RequestMapping("/api/v1/search")
public class TheatreBrowseController {

    @Autowired
    private TheatreBrowseService service;


    @GetMapping("/theatres")
    public List<MovieShowDocument> browse(
            @RequestParam String movieId,
            @RequestParam String city,
            @RequestParam LocalDate date) {
        return service.browse(movieId, city, date);
    }
}
