import org.junit.Test;


import static org.junit.Assert.*;

/**
 * Created by shrikant on 4/22/2015.
 */
public class CarTest {

    @Test
    public void shouldBeAbleToParkCar()
    {
        Car car = new Car();
        assertTrue("Should be able to park a car.", car.park());
    }

    @Test(expected=RuntimeException.class)
    public void shouldNotBeAbleToParkCarIfParkedOnce()
    {
        Car car = new Car();
        car.park();
        car.park();
    }
}