package java.leetcode.productExceptSelf;

public class solution {

    // Product of Array Except Self
    public int[] productExceptSelf(int[] niz) {
        // pravi se levi niz i u njega se stavljaju elementi sem nultog koji je
        // postavljen na jedan
        int[] left = new int[niz.length];
        // pravi se desni niz i u njega se stavljaju elementi sem poslednjeg koji je
        // postavljen na jedan
        int[] right = new int[niz.length];
        left[0] = 1;
        for (var i = 1; i < niz.length; i++) {
            left[i] = left[i - 1] * niz[i - 1];
        }
        right[niz.length - 1] = 1;
        for (var i = niz.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * niz[i + 1];
        }
        int[] total = new int[niz.length];
        for (var i = 0; i < niz.length; i++) {
            total[i] = left[i] * right[i];
        }
        return total;
    }
}
