import java.util.HashMap;

/**
 * Created by shrikant on 4/22/2015.
 */
public class ParkingLot {
    private HashMap<String , Car> parkingArea;
    private int parkingLotSize;

    public ParkingLot(int parkingLotSize){
        this.parkingLotSize = parkingLotSize;
        parkingArea = new HashMap<String, Car>();
    }

    public boolean park(Car car) {
        if (parkingArea.size() >= parkingLotSize)
            throw new IndexOutOfBoundsException("Parking lot is full.");
        return parkingArea.put(car.getId(), car) == null;
    }

    public Car getCar(String id) {
        return parkingArea.get(id);
    }

    public boolean isFull() {
        return (parkingArea.size() >= parkingLotSize);
    }
}
