/**
  * Kurzes Programm zur Berechnung des Kuckuckshashings.
  * Tabelle 1: x mod 5
  * Tabelle 2: x mod 7
  * Einzufuegen: 21, 49, 52, 73, 98, 67, 102, 17, 36
  *
  * @author Max Schwarzfischer
  * @version 1.0
  */

import java.util.Arrays;

public class Kuckuck {
    private static Integer[] t1 = new Integer[5];
    private static Integer[] t2 = new Integer[7];

    private static int h1(int x) { return x % 5; }
    private static int h2(int x) { return x % 7; }

    private static void hash(Integer[] array) {
        for(Integer x : array) {
            if (t1[h1(x)] == null) {
                t1[h1(x)] = x;
                System.out.println("Added " + x + " to t1[" + h1(x) + "]");
                continue;
            }
            System.out.println("Tried to add " + x + " to t1[" + h1(x) + "] but was occupied by " + t1[h1(x)]);
            if (t2[h2(x)] == null) {
                t2[h2(x)] = x;
                System.out.println("Added " + x + " to t2[" + h2(x) + "]");
                continue;
            }
            System.out.println("Tried to add " + x + " to t2[" + h2(x) + "] but was occupied by " + t2[h2(x)]);
            
            int swaps = 0;
            Integer first = x;
            while (true) {
                if (swaps % 2 == 1) {
                    // Swap:
                    Integer temp = x;
                    x = t2[h2(x)];
                    t2[h2(temp)] = temp;
                    System.out.println("Swapped " + temp + " with " + x + " in t2[" + h2(temp) + "]");

                    if (first.equals(x)) {
                        System.out.println("Couldn't add " + first + " (cycle)");
                        break;
                    }
                } else {
                    // Swap:
                    Integer temp = x;
                    x = t1[h1(x)];
                    t1[h1(temp)] = temp;
                    System.out.println("Swapped " + temp + " with " + x + " in t1[" + h1(temp) + "]");
                }
                if (x == null) {
                    System.out.println("Swapping caused by " + first + " successfully completed");
                    break;
                }
                swaps++;
            }
        }
    }

    public static void main(String[] args) {
        hash(new Integer[] {21, 49, 52, 73, 98, 67, 102, 17, 36});

        System.out.println();
        System.out.println(Arrays.toString(t1));
        System.out.println(Arrays.toString(t2));
    }
}
