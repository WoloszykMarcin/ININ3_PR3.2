package devices;

public class Electric extends Car{
    public Electric(String producer, String model, int yearOfProducer) {
        super(producer, model, yearOfProducer);
    }

    public Electric(String producer, String model, int yearOfProducer, Double millage, double value) {
        super(producer, model, yearOfProducer, millage, value);
    }

    public Electric(String producer, String model, int yearOfProducer, Double millage, double value, String fuelType) {
        super(producer, model, yearOfProducer, millage, value, fuelType);
    }

    @Override
    public void refuel() {
        System.out.println("Laduje");
    }
}
