import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Test;

/**
 * Created by shrikant on 4/22/2015.
 */
public class TravellerTest {

    @Test(expected=NullPointerException.class)
    public void shouldNotAbleToParkCarWithIfTravellerContHaveAnyCar(){
        Traveller traveller= new Traveller(null);
        traveller.parkCar();
    }

    @Test
    public void travellerShouldBeAbleToParkACar()
    {
        Car car = new Car();
        Traveller traveller = new Traveller(car);
        Assert.assertTrue("Car is parked by traveller.", traveller.parkCar());
    }

    @Test(expected=RuntimeException.class)
    public void shouldNotBeAbleToParkTheCarByTwoTravellers()
    {
        Car car = new Car();
        Traveller traveller = new Traveller(car);
        Traveller traveller1 = new Traveller(car);
        traveller.parkCar();
        traveller1.parkCar();
    }
}