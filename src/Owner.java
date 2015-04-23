

/**
 * Created by shrikant on 4/22/2015.
 */
public class Owner implements Observer{
    private boolean isParkingLotFull;

    @Override
    public void update(Observable parkingLot, Object parkingLotStatus) {
        isParkingLotFull=(Boolean)parkingLotStatus;


    }

    public String checkParkingStatus() {
        if(isParkingLotFull)
            return "FULL";
        return "NOT FULL";
    }
}
