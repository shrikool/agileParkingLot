import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by shrikant on 4/22/2015.
 */
public class ParkingLotTest {
    private Car car ;
    private ParkingLot parkinglot;

    @Before
    public void setup()
    {
        parkinglot = new ParkingLot(10);
        car = new Car("C001");
    }

    @Test
    public void testIfAbleToParkTheCar()
    {
        boolean isParked = parkinglot.park(car);
        assertTrue("Should be able to park the car.", isParked);
    }

    @Test
    public void testIfAbleToRetrieveTheCar(){
        parkinglot.park(car);
        Car carRetrieved = parkinglot.getCar(car.getId());
        assertEquals("Should get the same car back", car, carRetrieved);
    }

    @Test
    public void shouldCheckIfTheCarExistsInParkingLot()
    {
        Car carRetrieved = parkinglot.getCar("C001");
        assertNull("Should get the same car back", carRetrieved);
    }

    @Test
    public void testParkingLotIsFull()
    {
        ParkingLot parkinglot = new ParkingLot(1);
        parkinglot.park(car);
        assertTrue("Parking lot should be full.", parkinglot.isFull());
    }

}