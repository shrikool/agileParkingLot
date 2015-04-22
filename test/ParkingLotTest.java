import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

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

    @Test
    public void shouldSendMessageToAllMyObseversWhenParkingLotIsFull() {
        ParkingLot parkingLot = new ParkingLot(1);
        TestObserver testObserver = mock(TestObserver.class);
        parkingLot.addObserver(testObserver);

        parkingLot.park(car);

        verify(testObserver).update(parkingLot, new Boolean(true));
    }

    @Test
    public void shouldSendMessageToAllMyObseversWhenParkingLotIsAvailable() {
        ParkingLot parkingLot = new ParkingLot(2);
        TestObserver testObserver = mock(TestObserver.class);
        parkingLot.addObserver(testObserver);

        parkingLot.park(car);
        parkingLot.park(new Car("CAR_ID"));

        verify(testObserver).update(parkingLot, new Boolean(false));
        verify(testObserver).update(parkingLot, new Boolean(true));
    }

    @Test
    public void shouldSendMessageToAllMyObseversWhenParkingLotIsAvailableWhenRetrievingACar() {
        ParkingLot parkingLot = new ParkingLot(1);
        TestObserver testObserver = mock(TestObserver.class);
        parkingLot.addObserver(testObserver);

        parkingLot.park(car);
        parkingLot.getCar(car.getId());

        verify(testObserver).update(parkingLot, new Boolean(true));
        verify(testObserver).update(parkingLot, new Boolean(false));
    }

}