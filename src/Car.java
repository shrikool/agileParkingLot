/**
 * Created by shrikant on 4/22/2015.
 */
public class Car {
    private boolean parked;

    public Car()
    {
        this.parked = false;
    }

    public boolean park() {
        if (this.parked == true)
            throw new RuntimeException("Can't park the parked car.");
        this.parked = true;
        return this.parked;
    }
}
