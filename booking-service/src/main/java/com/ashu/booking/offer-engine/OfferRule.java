public interface OfferRule {
    boolean applicable(int ticketCount, LocalTime showTime);
    double apply(double amount);
}
