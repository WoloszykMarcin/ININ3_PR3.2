package devices;

public class Phone extends Device {
    private double screenSize;
    private String os;

    public Phone(String producer, String model, int yearOfProducer, double screenSize, String os) {
        super(producer, model, yearOfProducer);
        this.screenSize = screenSize;
        this.os = os;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", screenSize=" + screenSize +
                ", os='" + os + '\'' +
                '}';
    }
}