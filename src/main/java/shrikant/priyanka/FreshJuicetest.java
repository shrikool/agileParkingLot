package shrikant.priyanka;

/**
 * Created by shrik on 3/5/2017.
 */
public class FreshJuicetest {
    public static void main(String[] args) {
        FreshJuice juice= new FreshJuice();
        juice.size= FreshJuice.juicesize.small;
        System.out.println("size:" +juice.size);

        FreshJuice juice1 =new FreshJuice(3);
juice1.setJuiceNmae("Mango");
        System.out.println("Juice Name :" +   juice1.getJuicename());

    }
}
