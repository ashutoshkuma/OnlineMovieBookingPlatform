@Service
public class OfferService {

    private final List<OfferRule> rules = List.of(
            new ThirdTicketOffer(),
            new AfternoonShowOffer()
    );

    public double applyOffers(double amount, int count, LocalTime time) {
        double finalAmount = amount;
        for (OfferRule rule : rules) {
            if (rule.applicable(count, time)) {
                finalAmount = rule.apply(finalAmount);
            }
        }
        return finalAmount;
    }
}
