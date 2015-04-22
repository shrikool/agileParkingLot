import java.util.*;

/**
 * Created by shrikant on 4/22/2015.
 */
public class ParkingLot extends Observable {
    private HashMap<String , Car> parkingArea;
    private int parkingLotSize;

    public ParkingLot(int parkingLotSize){
        this.parkingLotSize = parkingLotSize;
        parkingArea = new HashMap<String, Car>();
    }

    public boolean park(Car car) {
        if (isFull())
            throw new IndexOutOfBoundsException("Parking lot is full.");

        boolean isSuccess =  parkingArea.put(car.getId(), car) == null;

        if (isSuccess && isFull()) {
            setChanged();
            notifyObservers(new Boolean(true));
            return isSuccess;
        }

        setChanged();
        notifyObservers(new Boolean(false));
        return isSuccess;
    }

    public Car getCar(String id) {
        Car car=parkingArea.get(id);
        parkingArea.remove(id);
        setChanged();
        notifyObservers(new Boolean(false));
        return car;
    }

    public boolean isFull() {
        return (parkingArea.size() >= parkingLotSize);
    }
}