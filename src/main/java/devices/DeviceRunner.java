package devices;

public class DeviceRunner {
    public static void main(String[] args) {
        Car car = new Benzine("Alfa Romeo", "159 jtdm", 2011, 50000.0, 50000.0, "PB");
        System.out.println(car);

        Phone phone = new Phone("Samsung", "S22", 2022,4000, 13, "Android");
        System.out.println(phone);

    }
}