package creatures;

public class FarmAnimal extends Animal implements Edible{

    public FarmAnimal(String species) {
        super(species);
    }

    public FarmAnimal(String species, String name, Double weight, Boolean alive) {
        super(species, name, weight, alive);
    }

    @Override
    public void beEaten() {
        if (this.isAlive())
            this.setAlive(false);
        System.out.println(this.getSpecies() + " został zjedzony");
    }
}
