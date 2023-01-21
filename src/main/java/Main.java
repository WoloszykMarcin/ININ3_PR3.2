public class Main {
    public static void main(String[] args) {
        Car passat = new Car("VW", "passerati", 2001);
        passat.millage = 78000.0;
        System.out.println(passat.producer);
        System.out.println(passat.model);
        System.out.println(passat.yearOfProduction);

        Car fiat = new Car("fiat", "bravo", 2010);
        fiat.millage = 312321.5;

        System.out.println("Model auta: " + fiat.model);
        System.out.println("Przebieg: " + fiat.millage);

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


    }
}
