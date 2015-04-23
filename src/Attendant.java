import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shrikant on 4/23/2015.
 */
public class Attendant {

    private List<ParkingLot> parkingLotList = new ArrayList<ParkingLot>();

    private Map<String,ParkingLot> carParkedTokenDetail = new HashMap<String,ParkingLot>();

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
        if (parkingLotList == null)
            throw new NullPointerException();
        this.parkingLotList = parkingLotList;
    }

    boolean parkTheCar(Car car) {
        if (parkingLotList.size() == 0)
            throw new NullPointerException();
        ParkingLot parkingLotFree = getFreeParkingLot();
        if (parkingLotFree == null)
            return false;
        carParkedTokenDetail.put(car.getId(),parkingLotFree);
        return parkingLotFree.park(car);
    }

    Car getTheCar(String carId) {
        return carParkedTokenDetail.get(carId).getCar(carId);
    }
}
