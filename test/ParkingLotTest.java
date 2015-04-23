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

//    @Before
//    public void setup()
//    {
//        parkinglot = new ParkingLot(10);
//        car = new Car("C001");
//    }
//
//    @Test
//    public void testIfAbleToParkTheCar()
//    {
//        boolean isParked = parkinglot.park(car);
//        assertTrue("Should be able to park the car.", isParked);
//    }
//
//    @Test
//    public void testIfAbleToRetrieveTheCar(){
//        parkinglot.park(car);
//        Car carRetrieved = parkinglot.getCar(car.getId());
//        assertEquals("Should get the same car back", car, carRetrieved);
//    }
//
//    @Test
//    public void shouldCheckIfTheCarExistsInParkingLot()
//    {
//        Car carRetrieved = parkinglot.getCar("C001");
//        assertNull("Should get the same car back", carRetrieved);
//    }
//
//    @Test
//    public void testParkingLotIsFull()
//    {
//        ParkingLot parkinglot = new ParkingLot(1);
//        parkinglot.park(car);
//        assertTrue("Parking lot should be full.", parkinglot.isFull());
//    }
//
//    @Test
//    public void shouldSendMessageToParkingLotOwnerWhenParkingLotIsFull() {
//        ParkingLot parkingLot = new ParkingLot(1);
//        Owner owner = mock(Owner.class);
//        parkingLot.registerObserver(owner);
//
//        parkingLot.park(car);
//
//        verify(owner).update(parkingLot, new Boolean(true));
//    }
//
//    @Test
//    public void shouldSendMessageToAllMyObseversWhenParkingLotIsAvailable() {
//        ParkingLot parkingLot = new ParkingLot(2);
//        Owner owner = mock(Owner.class);
//        parkingLot.registerObserver(owner);
//
//        parkingLot.park(car);
//        parkingLot.park(new Car("CAR_ID"));
//
//       //verify(testObserver).update(parkingLot, new Boolean(false));
//        verify(owner).update(parkingLot, new Boolean(true));
//    }
//
//    @Test
//    public void shouldSendMessageToAllMyObseversWhenParkingLotIsAvailableWhenRetrievingACar() {
//        ParkingLot parkingLot = new ParkingLot(1);
//        Owner owner = mock(Owner.class);
//        parkingLot.registerObserver(owner);
//
//        parkingLot.park(car);
//        parkingLot.getCar(car.getId());
//
//        verify(owner).update(parkingLot, new Boolean(true));
//        verify(owner).update(parkingLot, new Boolean(false));
//    }

    @Test
    public void testIfGarageIs80PercentFull()
    {
        ParkingLot parkingLot = new ParkingLot(5);

        FBIAgent fbiAgent = mock(FBIAgent.class);
        parkingLot.registerObserver(fbiAgent);

        parkingLot.park(new Car("C001"));
        parkingLot.park(new Car("C002"));
        parkingLot.park(new Car("C003"));
        parkingLot.park(new Car("C004"));

        verify(fbiAgent).update(parkingLot, new Boolean(true));

    }



}