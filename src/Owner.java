/**
 * Created by shrikant on 4/22/2015.
 */
public class Owner {

    public String isParkingLotFull(ParkingLot parkinglot) {
        if (parkinglot == null)
            throw new IllegalArgumentException("Owner doesn't own a parking lot");
        if (parkinglot.isFull())
            return "FULL";
        return "NOT FULL";
    }
}
