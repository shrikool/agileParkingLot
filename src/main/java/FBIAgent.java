

/**
 * Created by shrikant on 4/23/2015.
 */
public class FBIAgent implements Observer {
    private boolean isParkingLotNeededSecurity;

    public void update(Observable parkingLot, Object parkingLotStatus) {
        isParkingLotNeededSecurity=(Boolean)parkingLotStatus;
    }

    public String checkSecurityNeededInParkingLot() {
        if(isParkingLotNeededSecurity)
            return "NEED SECURITY";
        return "NO SECURITY";
    }
}
