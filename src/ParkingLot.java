import java.util.*;

/**
 * Created by shrikant on 4/22/2015.
 */
public class ParkingLot implements Observable {
    private HashMap<String , Car> parkingArea;
    private HashMap<String ,Object> listOfPersonsToNotify;
    private int parkingLotSize;


    @Override
    public void registerObserver(Object personToNotify) {
        if (personToNotify instanceof Owner)
            listOfPersonsToNotify.put(OwnerEvent, personToNotify);
        if (personToNotify instanceof FBIAgent)
            listOfPersonsToNotify.put(FBIEvent, personToNotify);
    }


    @Override
    public void notifyObservers(String eventType,Object result) {
        Object personToNotify = listOfPersonsToNotify.get(eventType);
        Observer observerToNotify = (Observer) personToNotify;
        if (observerToNotify != null)
            observerToNotify.update(this, result);
    }


    public ParkingLot(int parkingLotSize){
        this.parkingLotSize = parkingLotSize;
        this.listOfPersonsToNotify = new HashMap<String, Object>();
        parkingArea = new HashMap<String, Car>();
    }

    public boolean park(Car car) {
        if (isFull())
            throw new IndexOutOfBoundsException("Parking lot is full.");

        boolean isSuccess =  parkingArea.put(car.getId(), car) == null;

        if (isSuccess && isFull()) {


            notifyObservers(OwnerEvent,new Boolean(true));

            return isSuccess;
        }

       /* setChanged();
        notifyObservers(new Boolean(false));*/
        return isSuccess;
    }

    public Car getCar(String id) {
        Car car=parkingArea.get(id);
        parkingArea.remove(id);

        notifyObservers(OwnerEvent,new Boolean(false));
        return car;
    }

    public boolean isFull() {
        return (parkingArea.size() >= parkingLotSize);
    }
}