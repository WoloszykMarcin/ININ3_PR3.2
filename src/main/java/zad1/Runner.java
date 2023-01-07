package zad1;

public class Runner {
    public static void main(String[] args) {
        Animal animal = new Animal("Kot", "Rick", 1.0, true);

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
    }
}
