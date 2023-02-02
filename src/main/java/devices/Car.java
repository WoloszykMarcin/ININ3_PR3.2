package devices;

import java.util.Comparator;
import java.util.Objects;

public abstract class Car extends Device {
    private String producer;
    private String model;
    private Integer yearOfProduction;
    private Double millage;
    private double value;
    private String fuelType;

    public Car(String producer, String model, int yearOfProducer, double value) {
        super(producer, model, yearOfProducer, value);
    }

    public Car(String producer, String model, int yearOfProducer, Double millage, double value) {
        super(producer, model, yearOfProducer, value);
        this.millage = millage;
        this.value = value;
    }

    public Car(String producer, String model, int yearOfProducer, Double millage, double value, String fuelType) {
        super(producer, model, yearOfProducer, value);
        this.millage = millage;
        this.value = value;
        this.fuelType = fuelType;
    }

    public abstract void refuel();

    //    public Car(String producer, String model, Integer yearOfProduction) {
//        this.producer = producer;
//        this.model = model;
//        this.yearOfProduction = yearOfProduction;
//        this.millage = 0.0;
//    }
//
//    public Car(String producer, String model, Integer yearOfProduction, Double millage, double value) {
//        this.producer = producer;
//        this.model = model;
//        this.yearOfProduction = yearOfProduction;
//        this.millage = millage;
//        this.value = value;
//    }
//
//    public Car(String producer, String model, Integer yearOfProduction, Double millage, double value, String fuelType) {
//        this.producer = producer;
//        this.model = model;
//        this.yearOfProduction = yearOfProduction;
//        this.millage = millage;
//        this.value = value;
//        this.fuelType = fuelType;
//    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(Integer yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public Double getMillage() {
        return millage;
    }

    public void setMillage(Double millage) {
        this.millage = millage;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void drive() {
        this.millage += 10.0;
        System.out.println("Aktualny przebieg to: " + this.millage);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return Double.compare(car.value, value) == 0 && Objects.equals(getProducer(), car.getProducer()) && Objects.equals(getModel(), car.getModel()) && Objects.equals(getYearOfProduction(), car.getYearOfProduction()) && Objects.equals(getMillage(), car.getMillage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProducer(), getModel(), getYearOfProduction(), getMillage(), value);
    }

    @Override
    public void turnOn() {
        System.out.println("Klikam Start / Stop");
        System.out.println("odpala");
    }

    @Override
    public String toString() {
        return "devices.Car{" +
                "producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                ", millage=" + millage +
                '}';
    }
}
