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
        ParkingLot parkinglot = new ParkingLot(5);
        ArrayList<ParkingLot> parkingLotList = new ArrayList<ParkingLot>();
        parkingLotList.add(parkinglot);

        Attendant attendant = mock(Attendant.class);
        when(attendant.getFreeParkingLot(parkingLotList)).thenReturn(parkinglot);
        ParkingLot parkingLotFree = attendant.getFreeParkingLot(parkingLotList);


        traveller.parkCarToParkingLot(parkinglot);


    }

    @Test
    public void travellerShouldBeAbleToParkACar()
    {
        Car car = new Car("C002");
        ParkingLot parkinglot = new ParkingLot(5);
        Traveller traveller = new Traveller(car);
        ArrayList<ParkingLot> parkingLotList = new ArrayList<ParkingLot>();
        parkingLotList.add(parkinglot);

        Attendant attendant = mock(Attendant.class);
        when(attendant.getFreeParkingLot(parkingLotList)).thenReturn(parkinglot);
        ParkingLot parkingLotFree = attendant.getFreeParkingLot(parkingLotList);

        traveller.parkCarToParkingLot(parkingLotFree);

        verify(attendant).getFreeParkingLot(parkingLotList);
    }


    @Test(expected=NullPointerException.class)
    public void travellerShouldNotBeAbleToParkACarIfParkingLotEmpty()
    {
        Car car = new Car("C002");
        ParkingLot parkinglot = null;
        Traveller traveller = new Traveller(car);

        ArrayList<ParkingLot> parkingLotList = new ArrayList<ParkingLot>();
        parkingLotList.add(parkinglot);
        Attendant attendant = mock(Attendant.class);
        when(attendant.getFreeParkingLot(parkingLotList)).thenReturn(parkinglot);
        ParkingLot parkingLotFree = attendant.getFreeParkingLot(parkingLotList);


        traveller.parkCarToParkingLot(parkingLotFree);
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
        when(attendant.getFreeParkingLot(parkingLotList)).thenReturn(parkinglot);
        ParkingLot parkingLotFree = attendant.getFreeParkingLot(parkingLotList);

        traveller.parkCarToParkingLot(parkingLotFree);
        Car myCar = traveller.getMyCar(parkingLotFree);
        assertEquals(car, myCar);

    }

    @Test(expected=NullPointerException.class)
    public void travellerShouldNotBeAbleToUnparkHisCarIfParkingLotEmpty()
    {
        Car car = new Car("C002");
        ParkingLot parkinglot = new ParkingLot(5);
        Traveller traveller = new Traveller(car);

        ArrayList<ParkingLot> parkingLotList = new ArrayList<ParkingLot>();
        parkingLotList.add(parkinglot);
        Attendant attendant = mock(Attendant.class);
        when(attendant.getFreeParkingLot(parkingLotList)).thenReturn(parkinglot);
        ParkingLot parkingLotFree = attendant.getFreeParkingLot(parkingLotList);

        traveller.parkCarToParkingLot(parkingLotFree);
        parkinglot = null;
        Car myCar = traveller.getMyCar(parkinglot);
        assertEquals(car,myCar);

    }

    @Test
    public void travellerShouldNotAbleToParkCarIfAllParkingLotFull()
    {
        Car car = new Car("C002");
        Traveller traveller = new Traveller(car);

        Attendant attendant = mock(Attendant.class);
        traveller.parkCarToParkingLot(attendant);

        verify(attendant).parkTheCar();
    }




}