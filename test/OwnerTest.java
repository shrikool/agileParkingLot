import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by shrikant on 4/22/2015.
 */
public class OwnerTest {

    @Test(expected = IllegalArgumentException.class)
    public void ownerShouldOwnsAParkingLot()
    {
        Owner owner = new Owner();
        String status = owner.isParkingLotFull(null);
    }

    @Test
    public void checkParkingLotIsFull()
    {
        Owner owner = new Owner();
        ParkingLot parkinglot = new ParkingLot(1);
        Car car = new Car("C001");
        parkinglot.park(car);
        String status = owner.isParkingLotFull(parkinglot);
        assertEquals("Parking lot should be full", "FULL", status);
    }

    @Test
    public void checkParkingLotHaveSpace()
    {
        Owner owner = new Owner();
        ParkingLot parkinglot = new ParkingLot(2);
        Car car = new Car("C001");
        parkinglot.park(car);
        String status = owner.isParkingLotFull(parkinglot);
        assertEquals("Parking lot should be full", "NOT FULL", status);
    }

}