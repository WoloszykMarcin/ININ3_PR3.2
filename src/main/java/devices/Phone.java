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
    public void turnOn() {
        System.out.println("odpalam przycisk");
        System.out.println("trzymam przycisk");
        System.out.println("czekam");
        System.out.println("widze logo");
        System.out.println("urzadzenie wlaczone");
    }

    @Override
    public String toString() {
        return super.toString() +
                ", screenSize=" + screenSize +
                ", os='" + os + '\'' +
                '}';
    }
}