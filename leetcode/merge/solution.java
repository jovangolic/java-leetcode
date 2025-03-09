package java.leetcode.merge;

public class solution {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1; // nums1
        int j = n - 1; // nums2
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    // drugi nacin
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int len = nums1.length - 1;
        int i = m - 1;
        int j = n - 1;
        for (var k = 0; k < nums1.length; k++) {
            if (i >= 0 && j >= 0) {
                if (nums1[i] > nums2[j]) {
                    nums1[len--] = nums1[i--];
                } else {
                    nums1[len--] = nums2[j--];
                }
            }
        }
    }
}
