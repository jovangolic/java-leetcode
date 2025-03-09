package java.leetcode.trap;

public class solution {

    // Trapping Rain Water with two pointer
    public static int trap(int[] height) {
        int res = 0;
        int l = 0;
        int r = height.length - 1;
        int leftMax = height[l];
        int rightMax = height[r];
        while (l < r) {
            if (leftMax < rightMax) {
                l++;
                leftMax = Math.max(leftMax, height[l]);
                res += leftMax - height[l];
            } else {
                r--;
                rightMax = Math.max(rightMax, height[r]);
                res += rightMax - height[r];
            }
        }
        return res;
    }
}
