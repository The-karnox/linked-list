import java.util.*;

public class Primes {

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void checkSumOfTwoPrimes(int num) {
        boolean found = false;

        for (int i = 2; i <= num / 2; i++) {
            if (isPrime(i)) {
                if (isPrime(num - i)) {
                    System.out.println(num + " can be written as " + i + "+" + (num - i));
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println(num + " cannot be expressed as the sum of two prime numbers.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        checkSumOfTwoPrimes(num);
        sc.close();
    }
}
