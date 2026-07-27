public class LuxuryCar extends Car {

    private final double insuranceFee;
    private int minRentalDays;

    public LuxuryCar(int carID, String brand, String model, int year, double pricePerDay,
                     boolean isAvailable , double insuranceFee ) {
        super(carID, brand, model, year, pricePerDay, isAvailable);
        this.insuranceFee = insuranceFee;
        this.minRentalDays = 3;
    }
    public LuxuryCar(int carID, String brand, String model, int year, double pricePerDay
                     , double insuranceFee ) {
        super(carID, brand, model, year, pricePerDay, true);
        this.insuranceFee = insuranceFee;
        this.minRentalDays = 3;
    }


    public double getInsuranceFee() {
        return insuranceFee;
    }

    public int getMinRentalDays() {
        return minRentalDays;
    }

    public void setMinRentalDays(int minRentalDays) {
        this.minRentalDays = minRentalDays;
    }
}
