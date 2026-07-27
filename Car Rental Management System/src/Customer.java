public class Customer {

    private int cutomerId;
    private String name;
    private String phone;
    private int rentedCarId;
    private int rentedDays;
    private double paid;
    private static int count;
    private static double totalPaid;

    public Customer(int cutomerId, String name, String phone,
                    int rentedCarId, int rentedDays, double paid) {
        this.cutomerId = cutomerId;
        this.name = name;
        this.phone = phone;
        this.rentedCarId = rentedCarId;
        this.rentedDays = rentedDays;
        this.paid = paid;
        count++;
    }

    public Customer(int cutomerId, String name, String phone) {
        this(cutomerId, name, phone, -1, 0, 0);
    }

    public int getCutomerId() {
        return cutomerId;
    }

    public void setCutomerId(int cutomerId) {
        this.cutomerId = cutomerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRentedCarId() {
        return rentedCarId;
    }

    public void setRentedCarId(int rentedCarId) {
        this.rentedCarId = rentedCarId;
    }

    public int getRentedDays() {
        return rentedDays;
    }

    public void setRentedDays(int rentedDays) {
        this.rentedDays = rentedDays;
    }

    public double getPaid() {
        return paid;
    }

    public void setPaid(double paid) {
        this.paid = paid;
        totalPaid += paid;
    }

    public static int getCount() {
        return count;
    }

    public static double getTotalPaid() {
        return totalPaid;
    }

    @Override
    public String toString() {
        return " Customer{" +
                "cutomerId=" + cutomerId +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", rentedCarId=" + rentedCarId +
                ", rentedDays=" + rentedDays +
                ", paid=" + paid +
                '}';
    }
}
