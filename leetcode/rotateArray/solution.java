package java.leetcode.rotateArray;

public class solution {

    // metoda za rotiranje niza
    /*
     * Input: nums = [1,2,3,4,5,6,7], k = 3
     * Output: [5,6,7,1,2,3,4]
     */
    public static int[] rotateArray(int[] niz, int k) {
        if (niz.length == 0 && k < 0) {
            return niz;
        }
        int j = k % niz.length;
        reverse(niz, 0, niz.length - 1);
        reverse(niz, 0, j - 1);
        reverse(niz, j, niz.length - 1);
        return niz;
    }

    private static void reverse(int[] niz, int left, int right) {
        while (left < right) {
            swap(niz, left, right);
            left++;
            right--;
        }
    }

    private static void swap(int[] niz, int i, int j) {
        int temp = niz[i];
        niz[i] = niz[j];
        niz[j] = temp;
    }

    // drugi nacin
    public static int[] rotateNiz(int[] niz, int k) {
        int len = niz.length;
        int j = k % len;
        int[] pomNiz = new int[len];
        for (var i = 0; i < niz.length; i++) {
            pomNiz[(i + j) % len] = niz[i];
        }
        for (var i = 0; i < niz.length; i++) {
            niz[i] = pomNiz[i];
        }
        return niz;
    }
}
