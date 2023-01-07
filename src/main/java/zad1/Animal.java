package zad1;

public class Animal {
    String species;
    String name;
    Double weight;
    Boolean alive;


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

    public void feed() {
        if(!this.alive) {
            System.out.println("troche za pozno na jedzenie");
        } else {
            this.weight += 0.5;
            System.out.println("Najedzone");
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

    @Override
    public String toString() {
        return "Animal{" +
                "species='" + species + '\'' +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", alive=" + alive +
                '}';
    }
}
