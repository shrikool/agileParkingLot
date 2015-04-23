import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by shrikant on 4/23/2015.
 */
public class AttendantTest {

    @Test
    public void shouldGiveFreeParkingLot()
    {
        List<ParkingLot> parkingLotList = new ArrayList<ParkingLot>();
        ParkingLot parkingLotOne = new ParkingLot(2);
        ParkingLot parkingLotTwo = new ParkingLot(2);
        parkingLotList.add(parkingLotOne);
        parkingLotList.add(parkingLotTwo);
        Attendant attendant = new Attendant();
        ParkingLot parkingLotFree = attendant.getFreeParkingLot(parkingLotList);
        assertTrue(!parkingLotFree.isFull());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotGiveFreeParkingLotIfParkingLotListIsEmpty()
    {
        List<ParkingLot> parkingLotList = null;

        Attendant attendant = new Attendant();
        ParkingLot parkingLotFree = attendant.getFreeParkingLot(parkingLotList);

    }

    @Test
    public void shouldGiveFreeParkingLotIfOneParkingLotIsEmpty()
    {
        List<ParkingLot> parkingLotList = new ArrayList<ParkingLot>();
        ParkingLot parkingLotOne = null;
        ParkingLot parkingLotTwo = new ParkingLot(2);
        parkingLotList.add(parkingLotOne);
        parkingLotList.add(parkingLotTwo);
        Attendant attendant = new Attendant();
        ParkingLot parkingLotFree = attendant.getFreeParkingLot(parkingLotList);
        assertTrue(!parkingLotFree.isFull());
    }

    @Test
    public void shouldNotGiveFreeParkingLotIfAllParkingLotFull()
    {
        List<ParkingLot> parkingLotList = new ArrayList<ParkingLot>();
        ParkingLot parkingLotOne = new ParkingLot(1);
        ParkingLot parkingLotTwo = new ParkingLot(1);
        parkingLotList.add(parkingLotOne);
        parkingLotList.add(parkingLotTwo);
        Attendant attendant = new Attendant();
        ParkingLot parkingLotFree = attendant.getFreeParkingLot(parkingLotList);
        Traveller traveller = new Traveller(new Car("001"));
        traveller.parkCarToParkingLot(parkingLotFree);
        parkingLotFree = attendant.getFreeParkingLot(parkingLotList);
        Traveller travellerTwo = new Traveller(new Car("002"));
        travellerTwo.parkCarToParkingLot(parkingLotFree);
        parkingLotFree = attendant.getFreeParkingLot(parkingLotList);
        assertNull(parkingLotFree);
    }
}