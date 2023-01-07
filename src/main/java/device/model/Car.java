package device.model;

public class Car extends Device{
    private double millage;
    private String color;
    private String fuelType;

    public Car(String producer, String model, int yearOfProducer, double millage, String color, String fuelType) {
        super(producer, model, yearOfProducer);
        this.millage = millage;
        this.color = color;
        this.fuelType = fuelType;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", millage=" + millage +
                ", color='" + color + '\'' +
                ", fuelType='" + fuelType + '\'' +
                '}';
    }
}
