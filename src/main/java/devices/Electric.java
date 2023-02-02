package devices;

import creatures.Human;

public class Electric extends Car{

    public Electric(String producer, String model, int yearOfProducer, double value) {
        super(producer, model, yearOfProducer, value);
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

    @Override
    public void sell(Human seller, Human buyer, double price) {

    }

    @Override
    public void installApplication(Application app) throws Exception {

    }
}
