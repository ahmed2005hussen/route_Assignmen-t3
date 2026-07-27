import java.util.Scanner;

class Main {

    Scanner sc = new Scanner(System.in);

    Car[] cars = new Car[20];
    Customer[] customers = new Customer[20];

    int currentCar = 0;
    int currentCustomer = 0;


    int menu() {
        System.out.println("========================================");
        System.out.println("SPEEDWAY RENTALS SYSTEM");
        System.out.println("========================================");
        System.out.println("1. Add Regular Car");
        System.out.println("2. Add Luxury Car");
        System.out.println("3. Add Customer");
        System.out.println("4. Display All Cars");
        System.out.println("5. Display Available Cars");
        System.out.println("6. Rent a Car");
        System.out.println("7. Return a Car");
        System.out.println("8. Search Car by ID");
        System.out.println("9. Search Car by Brand");
        System.out.println("10. Display All Customers");
        System.out.println("0. Exit");
        System.out.println("========================================");
        System.out.println("Enter your choice: ");

        int choice = sc.nextInt();

        return (choice >= 0 && choice <= 10) ? choice : -1;
    }

    boolean isfindCarWithCarId(int id) {

        for (int i = 0; i < currentCar; i++) {
            if (cars[i].getCarID() == id) return true;
        }
        return false;
    }

    boolean isFullCarsCapicity() {

        return currentCar == 20;
    }

    boolean isfindCustomerWithCustomerId(int id) {

        for (int i = 0; i < currentCustomer; i++) {
            if (customers[i].getCutomerId() == id) return true;
        }
        return false;
    }

    boolean isFullCustomerCapicity() {

        return currentCustomer == 20;
    }

    void addRegularCar() {

        System.out.print("Enter the id, integer id: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("\nEnter the brand name: ");
        String brand = sc.nextLine();

        System.out.print("\nEnter the model: ");
        String model = sc.nextLine();

        System.out.print("\nEnter the year: ");
        int year = sc.nextInt();

        if (year < 1990 || year > 2026) {
            System.out.println("Manufacturing year must be between 1990 and 2026.");
            return;
        }

        System.out.print("\nEnter the price per day: ");
        int pricePerDay = sc.nextInt();
        if (pricePerDay <= 0) {
            System.out.println("Price Per day must greater than zero ");
            return;
        }
        if (!isfindCarWithCarId(id) && !isFullCarsCapicity()) {
            Car car = new Car(id, brand, model, year, pricePerDay);
            System.out.print("\nAdd Regular car successfully");
            cars[currentCar++] = car;
            System.out.println(car);
        } else {
            if (isFullCarsCapicity()) {
                System.out.println("\nWe don't have place in our array :( ");
            } else {
                System.out.println("\nThis id was Used, try another one ");
            }
        }

        System.out.println("\n-----------------------");


    }

    void addLuxuryCar() {
        System.out.print("Enter the id, integer id: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("\nEnter the brand name: ");
        String brand = sc.nextLine();

        System.out.print("\nEnter the model: ");
        String model = sc.nextLine();

        System.out.print("\nEnter the year: ");
        int year = sc.nextInt();

        if (year < 1990 || year > 2026) {
            System.out.println("Manufacturing year must be between 1990 and 2026.");
            return;
        }

        System.out.print("\nEnter the price per day: ");
        int pricePerDay = sc.nextInt();
        if (pricePerDay <= 0) {
            System.out.println("Price Per day must greater than zero ");
            return;
        }
        System.out.print("\nEnter insurance fee: ");
        double insuranceFee = sc.nextDouble();
        if (insuranceFee < 0) {
            System.out.println("Price Per day must greater than zero or equal zero ");
            return;
        }

        if (!isfindCarWithCarId(id) && !isFullCarsCapicity()) {
            LuxuryCar car = new LuxuryCar(id, brand, model, year, pricePerDay, insuranceFee);
            System.out.println("\nAdd Luxury Car successfully");
            cars[currentCar++] = car;
            System.out.println(car);
        } else {
            if (isFullCarsCapicity()) {
                System.out.println("\nWe don't have place in our array :( ");
            } else {
                System.out.println("\nThis id was Used, try another one ");
            }
        }

        System.out.println("\n-----------------------");


    }

    void addCustomer() {

        System.out.print("Enter Customer id, integer id: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("\nEnter customer name: ");
        String name = sc.nextLine();

        System.out.println("\nEnter phone number: ");
        String phone = sc.next();


        if (!isfindCustomerWithCustomerId(id) && !isFullCustomerCapicity()) {
            Customer customer = new Customer(id, name, phone);
            System.out.println("\nAdd customer successfully");
            customers[currentCustomer++] = customer;
            System.out.println(customer);
        } else {
            if (isFullCustomerCapicity()) {
                System.out.println("\nWe don't have place in our array :( ");
            } else {
                System.out.println("\nThis id was Used, try another one ");
            }
        }

        System.out.println("\n-----------------------");


    }

    void displayAllCars() {
        if (currentCar == 0) {
            System.out.println("We don't have any cars now ");
            return;
        }
        System.out.println("Our Cars: ");
        for (int i = 0; i < currentCar; i++) {
            System.out.println("    Car " + (i + 1) + cars[i]);
        }

        System.out.println("----------------------------");

    }

    void avaliableCares() {
        if (currentCar == 0) {
            System.out.println("We don't have any cars now ");
            return;
        }
        int count = 0;
        System.out.println("Our Cars: ");
        for (int i = 0; i < currentCar; i++) {
            if (cars[i].isAvailable()) {
                System.out.println("    Car " + (i + 1) + cars[i]);
                count++;
            }
        }
        if (count != 0) {
            System.out.println("Count avaliable: " + count + ", from " + cars[0].getCount());
        } else {
            System.out.println("We don't have any avaliable cars ");
        }

        System.out.println("----------------------------");

    }

    Car findCarById(int id) {
        for (int i = 0; i < currentCar; i++) {
            if (cars[i].getCarID() == id) return cars[i];
        }
        return null;
    }

    Customer findCustomerByCustomerId(int id) {

        for (int i = 0; i < currentCustomer; i++) {
            if (customers[i].getCutomerId() == id) return customers[i];
        }
        return null;
    }

    void rentCar() {

        System.out.print("Enter customer id: ");
        int customerId = sc.nextInt();

        if (!isfindCustomerWithCustomerId(customerId)) {
            System.out.println("\nCustomer does not exist\n-------------------");
            return;
        }
        Customer customer = findCustomerByCustomerId(customerId);

        if (customer.getRentedCarId() != -1) {
            System.out.println("\n This customer have a car already ");
            return;
        }

        System.out.print("\nEnter Car Id: ");
        int carId = sc.nextInt();

        if (!isfindCarWithCarId(carId)) {

            System.out.println("\nCar does not exist\n-------------------");
            return;
        }

        Car car = findCarById(carId);

        if (!car.isAvailable()) {
            System.out.println("\nThis car not avaliable now ");
            return;
        }

        System.out.print("\nEnter number of days for rent: ");
        int daysRent = sc.nextInt();

        if (daysRent <= 0) {
            System.out.println("\nInvalid number enter a valid number :| ");
            return;
        }

        boolean isLuxury = false;

        if (car.getClass() == LuxuryCar.class) {
            isLuxury = true;
            if (((LuxuryCar) car).getMinRentalDays() > daysRent) {
                System.out.println("Minumnuim number for rent luxury car is " + ((LuxuryCar) car).getMinRentalDays());
                System.out.println("Try again with a larger number :| ");
                return;
            }
        }

        car.setAvailable(false);

        double cost = daysRent * car.getPricePerDay() + car.getTaxRate();
        if (isLuxury) {
            cost += ((LuxuryCar) car).getInsuranceFee();
        }

        customer.setRentedCarId(carId);
        customer.setPaid(cost);

        System.out.println("Receipt: ");
        System.out.println("Customer: " + customer.getName());
        System.out.println("Car brand: " + car.getBrand() + ", car model: " + car.getModel());
        System.out.println("Days of rent: " + daysRent);
        System.out.println("Final cost: " + cost);

        System.out.println("--------------------------------------");
    }

    void returnCar() {

        System.out.print("Enter customer id: ");
        int customerId = sc.nextInt();

        if (!isfindCustomerWithCustomerId(customerId)) {
            System.out.println("\nCustomer does not exist\n-------------------");
            return;
        }
        Customer customer = findCustomerByCustomerId(customerId);

        if (customer.getRentedCarId() == -1) {
            System.out.println("\n This customer have no car already ");
            return;
        }
        int carId = customer.getRentedCarId();

        Car car = findCarById(carId);

        car.setAvailable(true);
        customer.setRentedCarId(-1);
        customer.setPaid(0);

        System.out.println("\n Return Car done \n--------------------------------------");
    }

    void returnCarById() {
        System.out.print("\nEnter Car Id: ");
        int carId = sc.nextInt();

        if (!isfindCarWithCarId(carId)) {

            System.out.println("\nCar does not exist\n-------------------");
            return;
        }

        Car car = findCarById(carId);

        System.out.println(car);

        System.out.println("---------------");
    }

    void searchCarByBrand() {

        int match = 0;
        System.out.print("Enter the brand name: ");
        sc.nextLine();
        String brand = sc.nextLine();

        for (int i = 0; i < currentCar; i++) {
            if (cars[i].getBrand().equalsIgnoreCase(brand)) {
                match++;
                System.out.println(cars[i]);
            }


        }

        if (match == 0) {
            System.out.println("Not found cars \n -----------------");
            return;
        }

        System.out.println("number of matches car is: " + match + "\n ----------------");

    }

    void displayAllCustomer() {
        System.out.println("Customers: ");

        for (int i = 0; i < currentCustomer; i++) {
            System.out.println(customers[i]);
            if (customers[i].getRentedCarId() != -1) {
                System.out.println("his rented car:\n " + cars[customers[i].getRentedCarId()]);
            }
            System.out.println("--------");
        }

    }

    public void main(String[] args) {


        loop:
        while (true) {


            int choice = menu();

            switch (choice) {

                case 0 -> {
                    break loop;
                }

                case 1 -> addRegularCar();

                case 2 -> addLuxuryCar();

                case 3 -> addCustomer();

                case 4 -> displayAllCars();

                case 5 -> avaliableCares();

                case 6 -> rentCar();

                case 7 -> returnCar();

                case 8 -> returnCarById();

                case 9 -> searchCarByBrand();

                case 10 -> displayAllCustomer();
            }

        }

        System.out.println("Good Bye ");
        System.out.println("Number of Customer:  " + Customer.getCount());
        System.out.println("Total Paid: " + Customer.getTotalPaid());


    }

}