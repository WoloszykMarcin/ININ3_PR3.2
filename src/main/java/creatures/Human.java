package creatures;

import devices.Car;

import java.util.Date;

public class Human extends Animal {

    private String firstName;
    private String lastName;
    private Car car;
    private Animal pet;
    private double salary;
    private double weight;
    private double cash;

    public Human(String firstName) {
        super("homo sapiens");
        this.weight = 70.0;
        this.salary = 111110.0;
        this.firstName = firstName;
    }

    public Human(String firstName, String lastName, Car car, Animal pet, double salary, double weight, double cash) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.car = car;
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

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        if (this.salary > car.getValue()) {
            System.out.println("Auto zostalo kupione za gotowke");
            this.car = car;
        } else if (this.salary > car.getValue() / 12) {
            System.out.println("udalo się kupić na kredyt (no trudno)");
            this.car = car;
        } else
            System.out.println("zapisz sie na studia i znajdz nowa robote albo idz po\n" + "podwyzke");
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
        return "creatures.Human{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", car=" + car +
                ", pet=" + pet +
                ", salary=" + salary +
                ", weight=" + weight +
                '}';
    }
}
