/**
 * Created by sahin on 11.07.17.
 */
public class iterativeFunctions {

    public static int f (int n) {

        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {

            int fibMinus1 = 0;
            int fib = 1;

            int iterator = 2;

            int nextFibMinus1, nextFib;

            while (iterator <= n) {

                nextFibMinus1 = fib;
                nextFib = fibMinus1 + fib;

                fibMinus1 = nextFibMinus1;
                fib = nextFib;

                iterator++;
            }

            return fib;

        }

    }

    public static int p (int n) {

        int base = 2;
        int iterator = 1;
        int result = 1;

        while (iterator <= n) {
            result = result * base;
            iterator ++;
        }

        return result;

    }

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            System.out.format("Fibonacci of %1$d is: %2$d\n", i, f(i));
        }

        for (int i = 0; i < 10; i++) {
            System.out.format("Two to the power of %1$d is: %2$d\n", i, p(i));
        }


    }



}
