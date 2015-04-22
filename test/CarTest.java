import org.junit.Test;


import static org.junit.Assert.*;

/**
 * Created by shrikant on 4/22/2015.
 */
public class CarTest {

    @Test
    public void shouldBeAbleToGetBackTheSameCarIdentificationForSameCar()
    {
        Car car = new Car("C002");
        assertEquals("Should get the same car back", "C002", car.getId());
    }
}