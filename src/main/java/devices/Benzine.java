package devices;

public class Benzine extends Car{
    public Benzine(String producer, String model, int yearOfProducer) {
        super(producer, model, yearOfProducer);
    }

    public Benzine(String producer, String model, int yearOfProducer, Double millage, double value) {
        super(producer, model, yearOfProducer, millage, value);
    }

    public Benzine(String producer, String model, int yearOfProducer, Double millage, double value, String fuelType) {
        super(producer, model, yearOfProducer, millage, value, fuelType);
    }

    @Override
    public void refuel() {
        System.out.println("laduje benzyne");
    }
}
