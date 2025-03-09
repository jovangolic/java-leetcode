package java.leetcode.isHappy;

import java.util.HashSet;
import java.util.Set;

public class solution {

    // happy number
    /*
     * Input: n = 19
     * Output: true
     * Explanation:
     * 12 + 92 = 82
     * 82 + 22 = 68
     * 62 + 82 = 100
     * 12 + 02 + 02 = 1
     */
    public static boolean isHappy(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        Set<Integer> visited = new HashSet<>();
        while (!visited.contains(n)) {
            visited.add(n);
            n = sumOfSquare(n);
            if (n == 1) {
                return true;
            }
        }
        return false;
    }

    private static int sumOfSquare(int n) {
        int suma = 0;
        while (n != 0) {
            int n1 = n % 10;
            suma += (n1 * n1);
            n = n / 10;
        }
        return suma;
    }
}
