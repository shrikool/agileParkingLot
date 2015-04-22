import java.util.HashMap;

/**
 * Created by shrikant on 4/22/2015.
 */
public class ParkingLot {
    private static HashMap<String , Car> parkingArea;

    static
    {
        parkingArea = new HashMap<String, Car>();
    }

    public static boolean park(Car car) {
        return parkingArea.put(car.getId(), car) == null;
    }

    public static Car getCar(String id) {
        return parkingArea.get(id);
    }
}
