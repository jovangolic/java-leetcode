package java.leetcode.summaryRanges;

import java.util.ArrayList;
import java.util.List;

public class solution {

    // Summary Ranges
    /*
     * Input: nums = [0,1,2,4,5,7]
     * Output: ["0->2","4->5","7"]
     */
    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            int start = nums[i];
            // da se ne dobije greska outBoundOfIndex error,i da se poveca i
            // ovo je za interval, tu ce biti ovo [0,1,2]
            while (i < nums.length - 1 && nums[i] + 1 == nums[i + 1]) {
                i++;
            }
            if (start != nums[i]) {
                result.add(start + "->" + nums[i]);
            } else {
                result.add("->" + nums[i]);
            }
            i++;
        }
        return result;
    }

    // drugi nacin
    /*
     * Input: nums = [0,1,2,4,5,7]
     * Output: ["0->2","4->5","7"]
     */
    public static List<String> summaryRanges2(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        int start = nums[0];
        for (var i = 1; i <= nums.length; i++) {
            if (i == nums.length || nums[i] != nums[i - 1] + 1) {
                if (start == nums[i - 1]) {
                    res.add(String.valueOf(start));
                } else {
                    res.add(start + "->" + nums[i - 1]);
                }
                // azuriranje novog pocetka
                if (i < nums.length) {
                    start = nums[i];
                }
            }
        }
        return res;
    }
}
