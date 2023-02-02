package devices;

import creatures.Human;

import java.net.URL;
import java.util.*;

public class Phone extends Device {
    public static final String DEFAULT_APP_SERVER_ADDRESS = "localhost/v1/app";
    public static final String DEFAULT_PROTOCOL = "http";
    public static final String DEFAULT_APP_VERSION = "latest stable";
    private double screenSize;
    private String os;
    private Human owner;

    private double wallet;
    private List<Application> installedApps;

    public Phone(String producer, String model, int yearOfProducer, double value) {
        super(producer, model, yearOfProducer, value);
    }

    public Phone(String producer, String model, int yearOfProducer, double value, double screenSize, String os) {
        super(producer, model, yearOfProducer, value);
        this.screenSize = screenSize;
        this.os = os;
    }

    public void installApp(Application app) throws Exception {
        if (wallet < app.getPrice()) {
            throw new Exception("Not enough money");
        }
        installedApps.add(app);
        wallet -= app.getPrice();
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

    @Override
    public void sell(Human seller, Human buyer, double price) {

    }
    @Override
    public void installApplication(Application app) throws Exception{
        if (wallet < app.getPrice()) {
            throw new Exception("Not enough money");
        }
        installedApps.add(app);
        wallet -= app.getPrice();
    }

    public boolean isApplicationInstalled(Application app) {
        return installedApps.contains(app);
    }

    public boolean isApplicationInstalled(String appName) {
        for (Application app : installedApps) {
            if (app.getName().equals(appName)) {
                return true;
            }
        }
        return false;
    }

    public List<Application> getFreeApps() {
        List<Application> freeApps = new ArrayList<>();
        for (Application app : installedApps) {
            if (app.getPrice() == 0) {
                freeApps.add(app);
            }
        }
        return freeApps;
    }

    public double getTotalValueOfInstalledApps() {
        double total = 0;
        for (Application app : installedApps) {
            total += app.getPrice();
        }
        return total;
    }

    public List<Application> isApplicationInstalledByName(String name) {
        List<Application> sortedApps = new ArrayList<>(installedApps);
        Collections.sort(sortedApps, (a1, a2) -> a1.getName().compareTo(a2.getName()));
        return sortedApps;
    }

    public List<Application> getInstalledAppsSortedByPrice() {
        List<Application> sortedApps = new ArrayList<>(installedApps);
        Collections.sort(sortedApps, (a1, a2) -> Double.compare(a1.getPrice(), a2.getPrice()));
        return sortedApps;
    }
}