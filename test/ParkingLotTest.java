import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by shrikant on 4/22/2015.
 */
public class ParkingLotTest {
    @Test
    public void testIfAbleToParkTheCar()
    {
        Car car =new Car("C001");
        boolean isParked = ParkingLot.park(car);
        assertTrue("Should be able to park the car.", isParked);
    }

    @Test
    public void testIfAbleToRetrieveTheCar(){
        Car car =new Car("C001");
        ParkingLot.park(car);
        Car carRetrieved = ParkingLot.getCar(car.getId());
        assertEquals("Should get the same car back", car, carRetrieved);
    }

    @Test
    public void shouldCheckIfTheCarExistsInParkingLot()
    {
        Car carRetrieved = ParkingLot.getCar("C001");
        assertNull("Should get the same car back",carRetrieved);
    }

}