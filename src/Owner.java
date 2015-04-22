import javafx.beans.Observable;

import java.util.Observer;

/**
 * Created by shrikant on 4/22/2015.
 */
public class Owner implements Observer{
    boolean isParkingLotFull;

    @Override
    public void update(java.util.Observable o, Object parkingLotStatus) {
        isParkingLotFull=(Boolean)parkingLotStatus;

    }

    public String checkParkingStatus() {
        if(isParkingLotFull)
            return "FULL";
        return "NOT FULL";
    }
}
