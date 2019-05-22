package junit.lab;

public class Vehicle {

    private String make;
    private int yearOfManufacturing;
    private int newPrice;
    private Condition condition;

    public Vehicle(String make, int yearOfManufacturing, int newPrice, Condition condition){
        this.make = make;
        this.condition = condition;
        this.newPrice = newPrice;
        this.yearOfManufacturing = yearOfManufacturing;
    }

    public int calculatePrice(){

        // First requirement
        int price = newPrice * 9 / 10;

        // age requirement
        double reduction = Math.pow(
                (double)8/10,
                2019 - yearOfManufacturing
        );
        price = (int)(price * reduction);

        // condition requirement
        switch(condition){
            case used:
                price -= 1000;
                break;
            case crap:
                price =-2000;
                break;
        }

        //Brand requirement
        switch(make){
            case "Ferrari":
                price +=2000;
                break;
            case "Lamborghini":
                price +=1000;
                break;
        }
        // never less than 0
        price = price <0?0:price;

        // Finished
        return price;
    }

    public enum Condition{
        mint,
        used,
        crap
    }
}
