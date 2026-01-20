public class ThirdTicketOffer implements OfferRule {
    public boolean applicable(int count, LocalTime t) {
        return count >= 3;
    }
    public double apply(double amount) {
        return amount * 0.5;
    }
}
