import static java.lang.Integer.parseInt;

/**
 * Created by sahin on 11.07.17.
 */
public class primes {

    public static boolean[] primes(int n) {

        boolean[] isPrime = new boolean[n];

        for (int i = 0; i < isPrime.length; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i < isPrime.length; i++) {

            if (isPrime[i] == true) {
                int currentPrime = i;
                int index = currentPrime + i;
                while (index < n) {
                    isPrime[index] = false;
                    index += currentPrime;
                }
            }

        }

        return isPrime;

    }

    public static void main(String[] args) {

        try {
            boolean[] primeValues = primes(parseInt(args[0]) + 1);

            for (int i = 0; i < primeValues.length; i++)
                System.out.printf("%1$d is a prime:\t%2$b \n", i, primeValues[i]);

        } catch (NumberFormatException e) {

        }

    }

}
