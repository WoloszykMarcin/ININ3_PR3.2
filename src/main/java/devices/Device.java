package devices;

import creatures.Human;

public abstract class Device implements creatures.Salleable {
    private final String producer;
    private final String model;
    private final int yearOfProducer;
    private final double value;

    public Device(String producer, String model, int yearOfProducer, double value) {
        this.producer = producer;
        this.model = model;
        this.yearOfProducer = yearOfProducer;
        this.value = value;
    }

    @Override
    public void sell(Human seller, Human buyer, double price) throws Exception {
        boolean hasCar = false;
        for (int i = 0; i < seller.garage.length; i++) {
            if (seller.garage[i] instanceof Car) {
                hasCar = true;
                break;
            }
        }
        if (!hasCar) {
            throw new Exception("Seller does not have a car in the garage.");
        }

        boolean hasSpace = false;
        for (int i = 0; i < buyer.garage.length; i++) {
            if (buyer.garage[i] == null) {
                hasSpace = true;
                break;
            }
        }
        if (!hasSpace) {
            throw new Exception("Buyer does not have any space in the garage.");
        }

        if (buyer.getCash() < price) {
            throw new Exception("Buyer does not have enough cash.");
        }

        Object car = null;
        int sellerIndex = -1;
        for (int i = 0; i < seller.garage.length; i++) {
            if (seller.garage[i] instanceof Car) {
                car = seller.garage[i];
                sellerIndex = i;
                break;
            }
        }
        seller.garage[sellerIndex] = null;

        int buyerIndex = -1;
        for (int i = 0; i < buyer.garage.length; i++) {
            if (buyer.garage[i] == null) {
                buyer.garage[i] = (Car) car;
                buyerIndex = i;
                break;
            }
        }

        buyer.cash -= price;
        seller.cash += price;

        System.out.println("The transaction was successful.");
    }

    private void buyerHasACash(Human buyer, Double price) throws Exception {
        if (buyer.getCash() < price) {
            throw new Exception("Buyer has not enough cash");
        }
    }

    public abstract void turnOn();
    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                ", yearOfProducer=" + yearOfProducer +
                '}';
    }
}
