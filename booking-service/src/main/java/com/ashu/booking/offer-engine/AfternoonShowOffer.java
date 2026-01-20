public class AfternoonShowOffer implements OfferRule {
    public boolean applicable(int count, LocalTime time) {
        return time.isAfter(LocalTime.NOON)
                && time.isBefore(LocalTime.of(16, 0));
    }
    public double apply(double amount) {
        return amount * 0.8;
    }
}
