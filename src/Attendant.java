import java.util.ArrayList;
import java.util.List;

/**
 * Created by shrikant on 4/23/2015.
 */
public class Attendant {

    private List<ParkingLot> parkingLotList = new ArrayList<ParkingLot>();

    private ParkingLot getFreeParkingLot() {
        if (parkingLotList == null)
            throw new IllegalArgumentException("Attendant should have parking lots to attend.");
        for(ParkingLot parkingLot : parkingLotList)
        {
            if (parkingLot != null && !parkingLot.isFull())
                return parkingLot;
        }
        return null;
    }

    public void assignParkingLotListToAttendant(List<ParkingLot> parkingLotList)
    {
        this.parkingLotList = parkingLotList;
    }

    boolean parkTheCar(Car car) {
    ParkingLot parkingLotFree = getFreeParkingLot();
       return parkingLotFree.park(car);
    }

    Car getTheCar(String carId) {

        return parkingLotFree.park(car);
    }
}
