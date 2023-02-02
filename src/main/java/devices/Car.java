package devices;

import creatures.Human;

import java.sql.Date;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Car extends Device {
    private List<Human> owners;
    private String producer;
    private String model;
    private Integer yearOfProduction;
    private Double millage;
    private double value;
    private String fuelType;
    private ArrayList<Transaction> transactions;
    private int currentGarageIndex;


    public Car(String producer, String model, int yearOfProducer, double value, List<Human> owners, ArrayList<Transaction> transactions) {
        super(producer, model, yearOfProducer, value);
        this.owners = owners;
        this.transactions = transactions;
    }

    public Car(String producer, String model, int yearOfProducer, double value, List<Human> owners) {
        super(producer, model, yearOfProducer, value);
        this.owners = owners;
    }

    public Car(String producer, String model, int yearOfProducer, double value) {
        super(producer, model, yearOfProducer, value);
    }

    public Car(String producer, String model, int yearOfProducer, Double millage, double value) {
        super(producer, model, yearOfProducer, value);
        this.millage = millage;
        this.value = value;
    }

    public Car(String producer, String model, int yearOfProducer, Double millage, double value, String fuelType) {
        super(producer, model, yearOfProducer, value);
        this.millage = millage;
        this.value = value;
        this.fuelType = fuelType;
    }

    public abstract void refuel();

    //    public Car(String producer, String model, Integer yearOfProduction) {
//        this.producer = producer;
//        this.model = model;
//        this.yearOfProduction = yearOfProduction;
//        this.millage = 0.0;
//    }
//
//    public Car(String producer, String model, Integer yearOfProduction, Double millage, double value) {
//        this.producer = producer;
//        this.model = model;
//        this.yearOfProduction = yearOfProduction;
//        this.millage = millage;
//        this.value = value;
//    }
//
//    public Car(String producer, String model, Integer yearOfProduction, Double millage, double value, String fuelType) {
//        this.producer = producer;
//        this.model = model;
//        this.yearOfProduction = yearOfProduction;
//        this.millage = millage;
//        this.value = value;
//        this.fuelType = fuelType;
//    }


    public List<Human> getOwners() {
        return owners;
    }

    public void setOwners(List<Human> owners) {
        this.owners = owners;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public int getCurrentGarageIndex() {
        return currentGarageIndex;
    }

    public void setCurrentGarageIndex(int currentGarageIndex) {
        this.currentGarageIndex = currentGarageIndex;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(Integer yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public Double getMillage() {
        return millage;
    }

    public void setMillage(Double millage) {
        this.millage = millage;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void drive() {
        this.millage += 10.0;
        System.out.println("Aktualny przebieg to: " + this.millage);
    }

    public boolean wasSoldBy(Human seller, Human buyer) {
        for (Transaction t : transactions) {
            if (t.seller == seller && t.buyer == buyer) {
                return true;
            }
        }
        return false;
    }

    public void sell(Human seller, Human buyer, double price) throws Exception {
        if (transactions.isEmpty() || transactions.get(transactions.size() - 1).buyer != seller) {
            throw new Exception("Seller is not the current owner of the car.");
        }

        boolean hasCar = false;
        for (int i = 0; i < seller.garage.length; i++) {
            if (seller.garage[i] == this) {
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

        if (buyer.cash < price) {
            throw new Exception("Buyer does not have enough cash.");
        }

        int sellerIndex = -1;
        for (int i = 0; i < seller.garage.length; i++) {
            if (seller.garage[i] == this) {
                sellerIndex = i;
                break;
            }
        }
        seller.garage[sellerIndex] = null;

        int buyerIndex = -1;
        for (int i = 0; i < buyer.garage.length; i++) {
            if (buyer.garage[i] == null) {
                buyer.garage[i] = this;
                buyerIndex = i;
                break;
            }
        }

        buyer.cash -= price;
        seller.cash += price;

        transactions.add(new Transaction(seller, buyer, price, new Date(System.currentTimeMillis())));

        System.out.println("The transaction was successful.");
    }

    public boolean wasOwner(Human human) {
        for (Transaction t : transactions) {
            if (t.seller == human || t.buyer == human) {
                return true;
            }
        }
        return false;
    }

    public boolean wasSoldByTo(Human seller, Human buyer) {
        for (Transaction t : transactions) {
            if (t.seller == seller && t.buyer == buyer) {
                return true;
            }
        }
        return false;
    }

    public int getTransactionCount() {
        return transactions.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return Double.compare(car.value, value) == 0 && Objects.equals(getProducer(), car.getProducer()) && Objects.equals(getModel(), car.getModel()) && Objects.equals(getYearOfProduction(), car.getYearOfProduction()) && Objects.equals(getMillage(), car.getMillage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProducer(), getModel(), getYearOfProduction(), getMillage(), value);
    }

    @Override
    public void turnOn() {
        System.out.println("Klikam Start / Stop");
        System.out.println("odpala");
    }

    class Transaction {
        Human seller;
        Human buyer;
        Double price;
        Date date;

        public Transaction(Human seller, Human buyer, double price, Date date) {
            this.seller = seller;
            this.buyer = buyer;
            this.price = price;
        }
    }

    @Override
    public String toString() {
        return "devices.Car{" +
                "producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                ", millage=" + millage +
                '}';
    }
}
