import java.util.List;

/**
 * Created by shrikant on 4/23/2015.
 */
public class Attendant {

    public ParkingLot getFreeParkingLot(List<ParkingLot> parkingLotList) {
        if (parkingLotList == null)
            throw new IllegalArgumentException("Attendant should have parking lots to attend.");
        for(ParkingLot parkingLot : parkingLotList)
        {
            if (parkingLot != null && !parkingLot.isFull())
                return parkingLot;
        }
        return null;
    }
}
