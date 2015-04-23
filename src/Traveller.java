/**
 * Created by shrikant on 4/22/2015.
 */
public class Traveller {
    private Car car;

    public Traveller(Car car)
    {
        this.car = car;
    }


    public boolean parkCarToParkingLot(ParkingLot parkingLot) {
        if (parkingLot == null)
            throw new NullPointerException("Traveller should get a parking lot.");
        if (this.car == null)
            throw new NullPointerException("Traveller should have atleast one car.");
        return parkingLot.park(this.car);
    }

    public Car getMyCar(ParkingLot parkingLot)
    {
        if (parkingLot == null)
            throw new NullPointerException("Traveller should get a parking lot.");
        return parkingLot.getCar(car.getId());
    }
}
