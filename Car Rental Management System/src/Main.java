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

    void addRegularCar() {

        System.out.println("Enter the id, integer id: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter the brand name: ");
        String brand = sc.nextLine();

        System.out.println("Enter the model: ");
        String model = sc.nextLine();

        System.out.println("Enter the year: ");
        int year = sc.nextInt();

        System.out.println("Enter the price per day: ");
        int pricePerDay = sc.nextInt();
        if (!isfindCarWithCarId(id) && !isFullCarsCapicity()) {
            Car car = new Car(id, brand, model, year, pricePerDay);
            System.out.println("Add successfully");

            System.out.println(car);
        }
        else{
            if(isFullCarsCapicity()) {
                System.out.println("We don't have place in our array :( ");
            }
            else{
                System.out.println("This id was Used, try another one ");
            }
        }

        System.out.println("-----------------------");


    }

    void addLuxuryCar() {
        System.out.println("Enter the id, integer id: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter the brand name: ");
        String brand = sc.nextLine();

        System.out.println("Enter the model: ");
        String model = sc.nextLine();

        System.out.println("Enter the year: ");
        int year = sc.nextInt();

        System.out.println("Enter the price per day: ");
        int pricePerDay = sc.nextInt();

        System.out.println("Enter insurance fee: ");
        double insuranceFee = sc.nextDouble();

        if (!isfindCarWithCarId(id) && !isFullCarsCapicity()) {
            LuxuryCar car = new LuxuryCar(id, brand, model, year, pricePerDay , insuranceFee);
            System.out.println("Add successfully");
            System.out.println(car);
        }
        else{
            if(isFullCarsCapicity()) {
                System.out.println("We don't have place in our array :( ");
            }
            else{
                System.out.println("This id was Used, try another one ");
            }
        }

        System.out.println("-----------------------");


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

            }

        }


    }

}