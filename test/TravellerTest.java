import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Created by shrikant on 4/22/2015.
 */
public class TravellerTest {

    @Test(expected=NullPointerException.class)
    public void shouldNotAbleToParkCarWithIfTravellerDontHaveAnyCar(){
        Traveller traveller= new Traveller(null);
        traveller.parkCarToParkingLot();
    }

    @Test
    public void travellerShouldBeAbleToParkACar()
    {
        Car car = new Car("C002");
        Traveller traveller = new Traveller(car);
        assertTrue("Car is parked by traveller.", traveller.parkCarToParkingLot());
    }




}