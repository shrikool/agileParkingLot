package shrikant.algorithms.dynamicprogramming;

public class CoinsProblem {

    public static int[] getCoins() {
        return new int[]{1, 2};
    }

    public static void main(String[] args) {
        int amount = 5;
        System.out.println("Minimum number of coins required to do the change is : " + Coin.getNumberOfCoins(amount, getCoins()));
    }
}

class Coin {

    // The problem is given there are n number of coins
    // repetition allowed , such that there denomination is
    // v1 < v2 < v3 ...... < vn
    // where v1 is one , so that we can find change for any value
    // Our problem is to find the change for the given C , so that we have
    // as less denominations as possible.
    // Formula for the above problem would be
    // let us say that K(j) is the minimum number of coins required for the change of j
    // so we can say that
    // K(j) = Min<<i from 1 to n>> K(j-v(i)) + 1
    static boolean onlytrue = true;
    static int[] denominationForValue;

    public static int getNumberOfCoins(int amount, int[] coins) {
        if (amount <= 0)
            return 0;

        if (coins == null || coins.length == 0)
            return 0;

        if (onlytrue) {
            doItOnce(amount);
            onlytrue = false;
        }

        if (denominationForValue[amount] != 0)
            return denominationForValue[amount];

        int sum = Integer.MAX_VALUE;
        for (int i = coins.length - 1; i >= 0; i--) {
            if (amount >= coins[i]) {
                int numberOfCoins = getNumberOfCoins(amount - coins[i], coins) + 1;
                sum = Integer.min(sum, numberOfCoins);
            }
        }

        denominationForValue[amount] = sum;

        return denominationForValue[amount];
    }

    private static void doItOnce(int amount) {
        denominationForValue = new int[amount + 1];
    }

}
