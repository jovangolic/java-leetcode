package java.leetcode.threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class solution {

    // 3sum
    /*
     * Input: nums = [-1,0,1,2,-1,-4]
     * Output: [[-1,-1,2],[-1,0,1]]
     * Explanation:
     * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
     * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
     * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
     * The distinct triplets are [-1,0,1] and [-1,-1,2].
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // [-4,-1,-1,0,1,2]
        Arrays.sort(nums);
        for (var i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int total = nums[i] + nums[j] + nums[k];
                if (total > 0) {
                    k--;
                } else if (total < 0) {
                    j++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    while (nums[j] == nums[j - 1] && j < k) {
                        j++;
                    }
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> threeSumProblem(int[] niz) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(niz);
        for (var i = 0; i < niz.length - 2; i++) {
            // proverava da li i nije duplikat
            if (i > 0 && niz[i] == niz[i - 1])
                continue;
            int l = i + 1;
            int r = niz.length - 1;
            while (l < r) {
                int sum = niz[i] + niz[l] + niz[r];
                if (sum == 0) {
                    result.add(Arrays.asList(niz[i], niz[l], niz[r]));
                    // proverava da li l nije duplikat
                    while (l < r && niz[l] == niz[l + 1])
                        l++;
                    // proverava da li r nije duplikat
                    while (l < r && niz[r] == niz[r - 1])
                        r--;
                    l++;
                    r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return result;
    }
}
