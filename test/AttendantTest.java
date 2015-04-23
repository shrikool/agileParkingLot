import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by shrikant on 4/23/2015.
 */
public class AttendantTest {

    @Test
    public void attendantShouldSuccesfullyParkTheCar()
    {
        List<ParkingLot> parkingLotList = new ArrayList<ParkingLot>();
        ParkingLot parkingLotOne = new ParkingLot(2);
        ParkingLot parkingLotTwo = new ParkingLot(2);
        parkingLotList.add(parkingLotOne);
        parkingLotList.add(parkingLotTwo);
        Attendant attendant = new Attendant();
        attendant.assignParkingLotListToAttendant(parkingLotList);
        boolean isSuccess = attendant.parkTheCar(new Car("a"));
        assertTrue(isSuccess);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotParkIfParkingLotListIsEmpty()
    {
        List<ParkingLot> parkingLotList = null;
        Attendant attendant = new Attendant();
        attendant.assignParkingLotListToAttendant(parkingLotList);
        attendant.parkTheCar(new Car("a"));

    }


    @Test
    public void shouldParkTheCarIfOneParkingLotIsEmpty()
    {
        List<ParkingLot> parkingLotList = new ArrayList<ParkingLot>();
        ParkingLot parkingLotOne = null;
        ParkingLot parkingLotTwo = new ParkingLot(2);
        parkingLotList.add(parkingLotOne);
        parkingLotList.add(parkingLotTwo);
        Attendant attendant = new Attendant();
        attendant.assignParkingLotListToAttendant(parkingLotList);
        boolean isSuccess = attendant.parkTheCar(new Car("b"));
        assertTrue(isSuccess);
    }


    @Test
    public void shouldNotParkInParkingLotIfAllParkingLotFull()
    {
        List<ParkingLot> parkingLotList = new ArrayList<ParkingLot>();
        ParkingLot parkingLotOne = new ParkingLot(1);
        ParkingLot parkingLotTwo = new ParkingLot(1);
        parkingLotList.add(parkingLotOne);
        parkingLotList.add(parkingLotTwo);
        Attendant attendant = new Attendant();
        attendant.assignParkingLotListToAttendant(parkingLotList);
        attendant.parkTheCar(new Car("a"));
        attendant.parkTheCar(new Car("b"));
        boolean isSuccess = attendant.parkTheCar(new Car("c"));
        assertTrue(!isSuccess);
    }

    @Test(expected=IllegalArgumentException.class)
    public void attendantShouldNotBeAbleToUnparkHisCarIfParkingLotEmpty()
    {

        Attendant attendant = new Attendant();
        ParkingLot parkingLot = new ParkingLot(2);
        List<ParkingLot> parkingLotList = new ArrayList<ParkingLot>();
        parkingLotList.add(parkingLot);
        attendant.assignParkingLotListToAttendant(parkingLotList);
        Car car = new Car("a");
        attendant.parkTheCar(car);
        attendant.assignParkingLotListToAttendant(null);
        Car carUnParked = attendant.getTheCar(car.getId());

    }

    @Test(expected=NullPointerException.class)
    public void attendantShouldNotBeAbleToParkCarIfParkingListIsNotGivenToHim()
    {
        Attendant attendant = new Attendant();
        ParkingLot parkingLot = new ParkingLot(2);
        List<ParkingLot> parkingLotList = new ArrayList<ParkingLot>();
        parkingLotList.add(parkingLot);

        Car car = new Car("a");
        attendant.parkTheCar(car);


    }

    @Test(expected=NullPointerException.class)
    public void attendantShouldNotBeAbleToParkCarIfCarIsEmpty()
    {
        Attendant attendant = new Attendant();
        ParkingLot parkingLot = new ParkingLot(2);
        List<ParkingLot> parkingLotList = new ArrayList<ParkingLot>();
        parkingLotList.add(parkingLot);
        attendant.assignParkingLotListToAttendant(parkingLotList);
        Car car = null;
        attendant.parkTheCar(car);


    }


}