import org.junit.Assert;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by shrikant on 4/22/2015.
 */
public class OwnerTest {
    private Owner owner;
    private Car car;

    @Before
    public void setup(){
        owner=new Owner();
        car = new Car("C001");
    }

    @Test
    public void shouldPutFullSignIfFullMessageIsReceived()
    {
        Owner owner = new Owner();
        owner.update(null, new Boolean(true));
        assertEquals(owner.checkParkingStatus(), "FULL");
    }

    @Test
    public void shouldPutAvailableSignIfAvailableMessageIsReceived()
    {
        Owner owner = new Owner();
        owner.update(null, new Boolean(false));
        assertEquals(owner.checkParkingStatus(), "NOT FULL");
    }


}