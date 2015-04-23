/**
 * Created by shrikant on 4/22/2015.
 */
public class Traveller {
    private Car car;
    private String carId;

    public Traveller(Car car)
    {
        this.car = car;
    }


    public boolean parkCar(Attendant attendant) {
        if (attendant == null)
            throw new NullPointerException("Traveller should get a attendant for parking.");
        if (this.car == null)
            throw new NullPointerException("Traveller should have atleast one car.");
        boolean isCarParked = attendant.parkTheCar(this.car);

        if (isCarParked) {
            this.carId = car.getId();
            this.car = null;
        }
        return isCarParked;
    }

    public Car getMyCar(Attendant attendant)
    {
        if (attendant == null)
            throw new NullPointerException("Traveller should get a attendant for parking.");
        return attendant.getTheCar(carId);
    }
}
