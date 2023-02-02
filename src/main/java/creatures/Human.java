package creatures;

import devices.Car;

import java.util.*;

public class Human extends Animal {
    private static final Integer DEFAULT_GARAGE_SIZE = 3;
    private String firstName;
    private String lastName;
    public Car[] garage;
    private Animal pet;
    private double salary;
    private double weight;
    public double cash;

    public Human(String firstName) {
        super("homo sapiens");
        this.weight = 70.0;
        this.salary = 5_000_000;
        this.firstName = firstName;
        this.garage = new Car[DEFAULT_GARAGE_SIZE];
    }

    public Human(String firstName, String lastName, Car car, Animal pet, double salary, double weight, double cash) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.garage = new Car[DEFAULT_GARAGE_SIZE];
        this.pet = pet;
        this.salary = salary;
        this.weight = weight;
        this.cash = cash;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public Car[] getGarage() {
        return garage;
    }

    public Car getCar(Integer parkingLotNumber) {
        return garage[parkingLotNumber];
    }

    public void setGarage(Car car) {
        setCar(car, DEFAULT_GARAGE_SIZE);
    }

    public void setCar(Car car, Integer parkingLotNumber) {
        if (parkingLotNumber >= this.garage.length)
            System.out.println("Brakuje miejsca w garazu, za duzo samochodow");
        else if (parkingLotNumber < 0)
            System.out.println("Brak garazu, nie ma miejsca");
        else if (this.garage[parkingLotNumber] != null)
            System.out.println("Miejsce zajete");
        else if (this.salary > car.getValue()) {
            System.out.println("Auto zostalo kupione za gotowke");
            this.garage[parkingLotNumber] = car;
        } else if (this.salary > car.getValue() / 12) {
            System.out.println("udalo się kupić na kredyt (no trudno)");
            this.garage[parkingLotNumber] = car;
        } else
            System.out.println("zapisz sie na studia i znajdz nowa robote albo idz po\n" + "podwyzke");
    }

    public Double getValueOfAllCars() {
        Double valueOfCars = 0.0;
        for (Car car : this.garage) {
            if (car != null) {
                valueOfCars += car.getValue();
            }
        }
        return valueOfCars;
    }

    public List<Car> sortAllCarsByProductionDate() {
        List<Car> cars = new ArrayList<>();
        Collections.addAll(cars, this.garage);
        cars.sort(new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                int result = o1.getYearOfProduction().compareTo(o2.getYearOfProduction());
                return result;
            }
        });
        return cars;
    }

    public Animal getPet() {
        return pet;
    }

    public void setPet(Animal pet) {
        this.pet = pet;
    }

    public double getSalary() {
        Date date = new Date();
        System.out.println("Data pobrania wyplaty" + date + " Wartosc: " + salary);
        return salary;
    }

    public void setSalary(double salary) {
        if (salary < 0)
            System.out.println("Ujemna wartosc wyplaty");
        else {
            System.out.println("nowe dane zostaly wyslane do systemu ksiegowego");
            System.out.println("konieczne jest odebranie aneksu do umowy od Pani Hani z kadr");
            System.out.println("ZUS i US zostaly powiadomione o zmiany wyplaty, nie ma sensu ukrywac dochodu");
            this.salary = salary;
        }
    }

    @Override
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Human{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", garage=" + Arrays.toString(garage) +
                ", pet=" + pet +
                ", salary=" + salary +
                ", weight=" + weight +
                ", cash=" + cash +
                '}';
    }
}
