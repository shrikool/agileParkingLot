package shrikant;

public class PrimeNumber {
    public static void main(String[] args) {
        System.out.println(findPrime(2));
    }

    static int findPrime(int number){
        if (number == 1) return 1;
        int tempNumber = number- 1;
        while (!isPrime(tempNumber)){
            tempNumber--;
        }
        return tempNumber;
    }

    private static boolean isPrime(int tempNumber) {
        for (int i = 2; i<tempNumber; i++){
            if (tempNumber % i == 0){
                return false;
            }
        }
        return true;
    }

}
