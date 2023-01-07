public class Car {
    String producer;
    String model;
    Integer yearOfProduction;
    Double millage;

    public Car(String producer, String model, Integer yearOfProduction) {
        this.producer = producer;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.millage = 0.0;
    }

    public void drive() {
        this.millage += 10.0;
        System.out.println("Aktualny przebieg to: " + this.millage);
    }
}
