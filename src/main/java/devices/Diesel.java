package devices;

import creatures.Human;

public class Diesel extends devices.Car{

    public Diesel(String producer, String model, int yearOfProducer, double value) {
        super(producer, model, yearOfProducer, value);
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

    @Override
    public void sell(Human seller, Human buyer, double price) {

    }

    @Override
    public void installApplication(Application app) throws Exception {

    }
}
