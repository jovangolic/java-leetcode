package java.leetcode.maxArea;

public class solution {

    // container with most water
    /*
     * Input: height = [1,8,6,2,5,4,8,3,7]
     * Output: 49
     */
    // resenje koje koristi brute-force, vreme je O(n^2)
    public static int maxArea(int[] height) {
        int res = 0;
        for (var i = 0; i < height.length; i++) {
            int maxArea = 0;
            for (var j = i + 1; j < height.length; j++) {
                maxArea = (j - i) * Math.min(height[i], height[j]);
            }
            if (res < maxArea) {
                res = maxArea;
            }
        }
        return res;
    }

    // drugi nacin, koristeci linearno resenje, O(n)
    public static int maxArea2(int[] height) {
        int res = 0;
        int l = 0;
        int r = height.length - 1;
        int maxArea = 0;
        while (l < r) {
            maxArea = (r - l) * Math.min(height[l], height[r]);
            res = Math.max(res, maxArea);
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }
}
