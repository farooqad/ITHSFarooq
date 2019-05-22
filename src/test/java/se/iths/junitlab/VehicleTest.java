package se.iths.junitlab;

import junit.lab.Vehicle;
import org.junit.Assert;
import org.junit.Test;

public class VehicleTest {

    @Test
    public void carWorthNintyPercentOfTheNewPrice() {

        Vehicle myVehicle = new Vehicle(
                "Volvo",
                2019,
                100000,
                Vehicle.Condition.mint
        );

        Assert.assertEquals(
                90000,
                myVehicle.calculatePrice()
        );
    }

    @Test
    public void carDecreasesTwentyPercentInValueEveryYear() {

        Vehicle myVehicle = new Vehicle(
                "Volvo",
                2018,
                100000,
                Vehicle.Condition.mint
        );

        Assert.assertEquals(
                72000,
                myVehicle.calculatePrice()
        );
    }

    @Test
    public void carDecreasesTwentyPercentInValueEachYearWithTwoYears() {

        Vehicle myVehicle = new Vehicle(
                "Volvo",
                2017,
                100000,
                Vehicle.Condition.mint
        );

        Assert.assertEquals(
                57600,
                myVehicle.calculatePrice()
        );
    }

    @Test
    public void carDecreasesTwentyPercentLessForEachYear(){
        Vehicle myVehicle = new Vehicle(
                "Toyota",
                2015,
                800000,
                Vehicle.Condition.used
        );
        Assert.assertEquals(
                293912,
                myVehicle.calculatePrice()
        );
    }

    @Test
    public void carCrapTest() {
        Vehicle myVehicle = new Vehicle(
                "hondai",
                2000,
                500000,
                Vehicle.Condition.crap
        );
        Assert.assertEquals(
                0,
                myVehicle.calculatePrice()
        );
    }
    @Test
    public void carCrapSecondTest() {
        Vehicle myVehicle = new Vehicle(
                "hondai",
                2018,
                500000,
                Vehicle.Condition.crap
        );
        Assert.assertEquals(
                0,
                myVehicle.calculatePrice()
        );
    }
    @Test
    public void lamborginiUsedTest(){
        Vehicle myVehicle = new Vehicle(
                "Lamborghini",
                2018,
                100000,
                Vehicle.Condition.used
        );
        Assert.assertEquals(
                72000,
                myVehicle.calculatePrice()
        );
    }
    @Test
    public void lamborginiMintTest(){
        Vehicle myVehicle = new Vehicle(
                "Lamborghini",
                2019,
                100000,
                Vehicle.Condition.used
        );
        Assert.assertEquals(
                90000,
                myVehicle.calculatePrice()
        );
    }

    @Test
    public void FerrariMintTest(){
        Vehicle myVehicle = new Vehicle(
                "Ferrari",
                2019,
                100000,
                Vehicle.Condition.mint
        );
        Assert.assertEquals(
                92000,
                myVehicle.calculatePrice()
        );
    }

    @Test
    public void FerrariUsedTest(){
        Vehicle myVehicle = new Vehicle(
                "Ferrari",
                2018,
                100000,
                Vehicle.Condition.used
        );
        Assert.assertEquals(
                73000,
                myVehicle.calculatePrice()
        );
    }
}
