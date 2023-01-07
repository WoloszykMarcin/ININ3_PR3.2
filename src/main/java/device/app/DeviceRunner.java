package device.app;

import device.model.Car;
import device.model.Phone;

public class DeviceRunner {
    public static void main(String[] args) {
        Car car = new Car("Alfa Romeo", "159 jtdm", 2011, 50000, "black", "PB");
        System.out.println(car);

        Phone phone = new Phone("Samsung", "S22", 2022,13, "Android");
        System.out.println(phone);
    }
}
