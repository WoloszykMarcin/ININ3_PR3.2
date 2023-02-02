import creatures.Animal;
import creatures.Human;
import devices.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
        Car passat = new LPG("VW", "passerati", 2001, 10000);
        passat.setMillage(78000.0);
        System.out.println(passat.getProducer());
        System.out.println(passat.getModel());
        System.out.println(passat.getYearOfProduction());

        Car fiat = new Diesel("fiat", "bravo", 2010, 30000);
        fiat.setMillage(312321.5);

        System.out.println("Model auta: " + fiat.getModel());
        System.out.println("Przebieg: " + fiat.getMillage());

        fiat.drive();
        fiat.drive();
        fiat.drive();

        Human kacper = new Human("Kacper");
        kacper.feed();
        System.out.println(kacper.getWeight());
        System.out.println(kacper.getSpecies());


        System.out.println("Kupowanie auta");
        Human human = new Human("Marek");
        human.setCar(new Benzine("Mercedes", "AMG GTR PRO", 2022, 0.0, 1_400_000), 0);
        human.setCar(new Benzine("Lamborghini", "Huracan", 2020, 5.0, 1_700_000), 1);

        try {
            human.setCar(fiat, Device.getParkingLotNumberIfBuyerHasAFreeSpace(human));
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Wartosc wszystkich samochodow w garazu");
        System.out.println(human.getValueOfAllCars());

        human.setSalary(50000);
        System.out.println(human.getSalary());

        Car huracan = new Benzine("Lamborghini", "Huracan", 2022, 5.0, 1_700_000);
        human.setCar(huracan, 5);

        Car huracan2 = new Benzine("Lamborghini", "Huracan", 2022, 5.0, 1_700_000);
        System.out.println(huracan == huracan2); // porownanie hashcode zwraca false
        System.out.println(huracan.equals(huracan2)); // porownanie equals zwraca true

        System.out.println(huracan);
        System.out.println(huracan2);

        huracan.turnOn();

        Animal pet = new Human("czlowiek");
        Human buyer = new Human("Buyer", "buyer", huracan, pet, 10_000, 70.0, 40_000);
        Human seller = new Human("Seller", "seller", huracan, null, 10_000, 50.0, 10_000);

        buyer.sell(seller, buyer, 50_000);

        passat.refuel();
        fiat.refuel();
        huracan.refuel();

        Phone phone = new Phone("Samsung", "S22", 2022,4000, 13, "Android");
        System.out.println(phone);

        phone.installAnApp("Hello Kitty");
        phone.installAnApp("Hello Kitty", "1.3.2");

        List<String> appsToInstall = new ArrayList<String>();
        appsToInstall.add("Facebook");
        appsToInstall.add("Instagram");
        appsToInstall.add("HelloKitty");

        phone.installAnApp(appsToInstall);

        URL git = new URL("https", "git-scm.com", "https://github.com/git/git");

        phone.installAnApp(git);

        Phone samsung = new Phone("Samsung", "S20", 2020, 4000.0);
        Application app1 = new Application("App 1", "1.0", 10);
        Application app2 = new Application("App 2", "2.0", 20);
        Application app3 = new Application("App 3", "1.0", 5);
        Application app4 = new Application("App 4", "2.0", 0);

        try {
            samsung.installApplication(app1);
            samsung.installApplication(app2);
            samsung.installApplication(app3);
            samsung.installApplication(app4);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Is App 1 installed: " + samsung.isApplicationInstalled(app1));
        System.out.println("Is App 2 installed: " + samsung.isApplicationInstalledByName("App 2"));

    }
}
