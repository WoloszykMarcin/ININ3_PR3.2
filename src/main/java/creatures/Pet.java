package creatures;

public class Pet extends Animal{
    public Pet(String species) {
        super(species);
    }

    public Pet(String species, Double weight) {
        super(species, weight);
    }

    public Pet(String species, String name, Double weight, Boolean alive) {
        super(species, name, weight, alive);
    }
}
