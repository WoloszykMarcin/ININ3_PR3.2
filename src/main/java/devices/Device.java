package devices;

public abstract class Device {
    private final String producer;
    private final String model;
    private final int yearOfProducer;

    public Device(String producer, String model, int yearOfProducer) {
        this.producer = producer;
        this.model = model;
        this.yearOfProducer = yearOfProducer;
    }

    public abstract void turnOn();
    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                ", yearOfProducer=" + yearOfProducer +
                '}';
    }
}
