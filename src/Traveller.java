/**
 * Created by shrikant on 4/22/2015.
 */
public class Traveller {
    private Car car;

    public Traveller(Car car)
    {
        this.car = car;
    }


    public boolean parkCarToParkingLot(Attendant attendant) {
        if (attendant == null)
            throw new NullPointerException("Traveller should get a attendant for parking.");
        if (this.car == null)
            throw new NullPointerException("Traveller should have atleast one car.");
        return attendant.parkTheCar(this.car);
    }
//    public boolean parkCarToParkingLot(ParkingLot parkingLot) {
//        if (parkingLot == null)
//            throw new NullPointerException("Traveller should get a parking lot.");
//        if (this.car == null)
//            throw new NullPointerException("Traveller should have atleast one car.");
//        return parkingLot.park(this.car);
//    }

    public Car getMyCar(Attendant attendant)
    {
        if (attendant == null)
            throw new NullPointerException("Traveller should get a attendant for parking.");
        return attendant.getTheCar(car.getId());
    }
}
