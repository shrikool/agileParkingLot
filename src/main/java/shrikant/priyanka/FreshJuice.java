package shrikant.priyanka;

/**
 * Created by shrik on 3/5/2017.
 */
public class FreshJuice {
 String juicename;
    public FreshJuice()
    {}
    public FreshJuice( int numberofjuice)
    {
        System.out.println("Number Of Juice:"+ numberofjuice);
    }
    enum juicesize {small,medium,large}
    juicesize size;

    public void  setJuiceNmae(String name)
    {
        juicename= name;
    }

    public String getJuicename() {
        return juicename;
    }
}
