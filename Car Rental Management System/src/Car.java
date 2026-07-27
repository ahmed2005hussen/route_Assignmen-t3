public class Car {


    private int carID;
    private String brand;
    private String model;
    private int year;
    private double pricePerDay;
    private boolean isAvailable;
    private static int count;
    private final double taxRate;

    public Car(int carID, String brand, String model, int year,
               double pricePerDay, boolean isAvailable) {
        this.carID = carID;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.pricePerDay = pricePerDay;
        this.isAvailable = isAvailable;
        this.taxRate = 0.14;
        count++;
    }
    public Car(int carID, String brand, String model, int year,
               double pricePerDay) {
      this(carID , brand , model , year , pricePerDay , true);
    }

    public int getCarID() {
        return carID;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }


    public int getYear() {
        return year;
    }


    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getTaxRate() {
        return taxRate;
    }


    @Override
    public String toString() {
        return "Car{" +
                "carID=" + carID +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", pricePerDay=" + pricePerDay +
                ", isAvailable=" + isAvailable +
                ", taxRate=" + taxRate +
                '}';
    }
}
