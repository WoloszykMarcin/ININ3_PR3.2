package devices;

public class Diesel extends Car{
    public Diesel(String producer, String model, int yearOfProducer) {
        super(producer, model, yearOfProducer);
    }

    public Diesel(String producer, String model, int yearOfProducer, Double millage, double value) {
        super(producer, model, yearOfProducer, millage, value);
    }

    public Diesel(String producer, String model, int yearOfProducer, Double millage, double value, String fuelType) {
        super(producer, model, yearOfProducer, millage, value, fuelType);
    }

    @Override
    public void refuel() {
        System.out.println("Leje Diesel'a");
    }
}
