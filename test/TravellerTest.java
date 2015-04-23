import org.junit.Assert;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by shrikant on 4/22/2015.
 */
public class TravellerTest {

    @Test(expected=NullPointerException.class)
    public void shouldNotAbleToParkCarWithIfTravellerDontHaveAnyCar(){
        Traveller traveller= new Traveller(null);
        traveller.parkCar(null);
    }

    @Test
    public void travellerShouldBeAbleToParkACar()
    {
        Car car = new Car("C002");
        ParkingLot parkinglot = new ParkingLot(5);
        Traveller traveller = new Traveller(car);

        Attendant attendant = mock(Attendant.class);
        when(attendant.parkTheCar(car)).thenReturn(true);
        boolean isCarParked = traveller.parkCar(attendant);
        assertTrue("Should be able to park the car", isCarParked);
    }


    @Test
    public void travellerShouldNotBeAbleToParkACarIfParkingLotEmpty()
    {
        Car car = new Car("C002");
        Traveller traveller = new Traveller(car);
        Attendant attendant = mock(Attendant.class);
        when(attendant.parkTheCar(car)).thenReturn(false);
        boolean isCarParked = traveller.parkCar(attendant);

        assertFalse("Traveller shouldn't be able to park a car if parking lot empty",isCarParked);
    }

    @Test
    public void travellerShouldBeAbleToUnparkHisCar()
    {
        Car car = new Car("C002");
        ParkingLot parkinglot = new ParkingLot(5);
        Traveller traveller = new Traveller(car);

        ArrayList<ParkingLot> parkingLotList = new ArrayList<ParkingLot>();
        parkingLotList.add(parkinglot);

        Attendant attendant = mock(Attendant.class);
        when(attendant.parkTheCar(car)).thenReturn(true);
        when(attendant.getTheCar(car.getId())).thenReturn(car);

        traveller.parkCar(attendant);
        Car carOnUnPark = traveller.getMyCar(attendant);

        assertEquals("Traveller should be able to unpark his car.", car, carOnUnPark);
    }



//    @Test
//    public void travellerShouldNotAbleToParkCarIfAllParkingLotFull()
//    {
//        Car car = new Car("C002");
//        Traveller traveller = new Traveller(car);
//
//        Attendant attendant = mock(Attendant.class);
//        traveller.parkCarToParkingLot(attendant);
//
//        verify(attendant).parkTheCar();
//    }




}