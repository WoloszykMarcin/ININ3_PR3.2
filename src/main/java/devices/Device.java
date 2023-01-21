package devices;

public class Device {
    private String producer;
    private String model;
    private int yearOfProducer;

    public Device(String producer, String model, int yearOfProducer) {
        this.producer = producer;
        this.model = model;
        this.yearOfProducer = yearOfProducer;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                ", yearOfProducer=" + yearOfProducer +
                '}';
    }
}
