package devices;

import java.net.URL;
import java.util.List;

public class Phone extends Device {
    public static final String DEFAULT_APP_SERVER_ADDRESS = "localhost/v1/app";
    public static final String DEFAULT_PROTOCOL = "http";
    public static final String DEFAULT_APP_VERSION = "latest stable";

    private double screenSize;
    private String os;

    public Phone(String producer, String model, int yearOfProducer, double screenSize, String os) {
        super(producer, model, yearOfProducer);
        this.screenSize = screenSize;
        this.os = os;
    }

    public void installAnApp(String name) {
        this.installAnApp(name, DEFAULT_APP_VERSION);
    }

    public void installAnApp(String name, String version) {
        this.installAnApp(name, version, DEFAULT_APP_SERVER_ADDRESS);
    }

    public void installAnApp(String name, String version, String serverName) {
        System.out.println("Instaluje aplikacje: " + name);
        System.out.println("Wersja " + version);
        System.out.println("Serwer " + serverName);
        System.out.println("Pobieram... pobieram...");
        System.out.println("Pobrane");
    }

    public void installAnApp(List<String> names) {
        for (String name : names) {
            this.installAnApp(name);
        }
    }

    public void installAnApp(URL url) {
        this.installAnApp(url.getFile(), DEFAULT_APP_VERSION, url.getHost());
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