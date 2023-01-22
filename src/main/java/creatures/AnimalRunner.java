package creatures;

import java.net.ProtocolFamily;

public class AnimalRunner {
    public static void main(String[] args) {
        Animal animal = new Pet("Pies", "Dog", 50.0, true);

        System.out.println(animal);
        animal.feed();
        animal.takeForAWalk();
        animal.takeForAWalk();
        animal.takeForAWalk();
        animal.takeForAWalk();
        //next commit
        animal.takeForAWalk();
        animal.takeForAWalk();
        animal.takeForAWalk();
        animal.takeForAWalk();
        animal.takeForAWalk();
        animal.feed();
        animal.feed();

        FarmAnimal kurczak = new FarmAnimal("Kurczak", "kurczak", 15.0, true);
        kurczak.feed(5.0);
        kurczak.feed(5.0);
        kurczak.beEaten();
    }
}
