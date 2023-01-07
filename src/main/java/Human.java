import zad1.Animal;

public class Human extends Animal {

    private String firstName;
    private String lastName;
    private Car car;
    private double salary;
    private double weight;

    public Human(String firstName) {
        super("homo sapiens");
        this.weight = 70.0;
        this.salary = 111110.0;
        this.firstName = firstName;
    }
}
