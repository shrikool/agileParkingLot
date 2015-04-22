/**
 * Created by shrikant on 4/22/2015.
 */
public class Traveller {
    private Car car;

    public Traveller(Car car)
    {
        this.car = car;
    }


    public boolean parkCarToParkingLot() {
        if (this.car == null)
            throw new NullPointerException("Traveller should have atleast one car.");
        return ParkingLot.park(this.car);
    }
}
