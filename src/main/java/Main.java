import devices.Car;

public class Main {
    public static void main(String[] args) {
        Car passat = new Car("VW", "passerati", 2001);
        passat.setMillage(78000.0);
        System.out.println(passat.getProducer());
        System.out.println(passat.getModel());
        System.out.println(passat.getYearOfProduction());

        Car fiat = new Car("fiat", "bravo", 2010);
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


        Human human = new Human("Marek");
        human.setCar(new Car("Mercedes", "AMG GTR PRO", 2022));

        System.out.println(human.getCar());

        human.setSalary(50000);
        System.out.println(human.getSalary());

        Car huracan = new Car("Lamborghini", "Huracan", 2022, 5.0, 1_700_000);
        human.setCar(huracan);

        Car huracan2 = new Car("Lamborghini", "Huracan", 2022, 5.0, 1_700_000);
        System.out.println(huracan == huracan2); // porownanie hashcode zwraca false
        System.out.println(huracan.equals(huracan2)); // porownanie equals zwraca true

        System.out.println(huracan);
        System.out.println(huracan2);

        huracan.turnOn();

        Animal pet = new Human("czlowiek");
        Human buyer = new Human("Buyer", "buyer", huracan, pet, 10_000, 70.0, 40_000);
        Human seller = new Human("Seller", "seller", huracan, null, 10_000, 50.0, 10_000);

        buyer.sell(seller, buyer, 50_000);

    }
}
