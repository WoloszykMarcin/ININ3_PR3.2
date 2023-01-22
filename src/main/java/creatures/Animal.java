package creatures;

public abstract class Animal implements Salleable, Feedable{
    private String species;
    private String name;
    private double weight;
    private boolean alive;

    public Animal() {
    }

    public Animal(String species) {
        this.species = species;
    }

    public Animal(String species, Double weight) {
        this.species = species;
        this.weight = weight;
        this.alive = true;
    }

    public Animal(String species, String name, Double weight, Boolean alive) {
        this.species = species;
        this.name = name;
        this.weight = weight;
        this.alive = alive;
    }

    @Override
    public void feed() {
        if(this.alive) {
            this.weight += 0.5;
            System.out.println("Najedzone");
        } else {
            System.out.println("troche za pozno na jedzenie");
        }
    }

    @Override
    public void feed(double foodWeight) {
        if(this.alive) {
            this.weight += foodWeight;
            System.out.println("Najedzone");
        } else {
            System.out.println("troche za pozno na jedzenie");
        }
    }

    public void takeForAWalk() {
        if (!this.alive) {
            System.out.println("halo policja");
        } else {
            this.weight -= 0.5;
            System.out.println("Aktualna waga: " + weight);
            if (this.weight <= 0) {
                this.alive = false;
                System.out.println("Twoje zwierze jest martwe");
            }
        }
    }

    public String getSpecies() {
        return species;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    @Override
    public String toString() {
        return "creatures.Animal{" +
                "species='" + species + '\'' +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", alive=" + alive +
                '}';
    }

    @Override
    public void sell(Human seller, Human buyer, double price) {
        if (this instanceof Human)
            System.out.println("Zakaz handlu ludzmi");
        else if (seller.getPet() != this)
            System.out.println("Sprzedawca nie ma takiego zwierzecia");
        else if (buyer.getCash() < price)
            System.out.println("Kupujacy nie posiada wystarczajacej ilosci gotowki");
        else {
            buyer.setCash(buyer.getCash() - price);
            seller.setCash(seller.getCash() + price);
            buyer.setPet(this);
            seller.setPet(null);
            System.out.println(buyer.getFirstName() + " wlasnie zakupil" + this.species + " od" + seller.getFirstName() + " za " + price);
        }
    }
}
