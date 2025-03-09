package java.leetcode.removeDuplicates;

import java.util.HashMap;
import java.util.Map;

public class solution {

    // uklanjanje duplikata
    public static int removeDuplicates(int[] nums) {
        // prvi nacin
        /*
         * int k = 0;
         * for (int i = 1; i < nums.length; i++) {
         * if (nums[i] != nums[k]) {
         * k++;
         * nums[k] = nums[i];
         * }
         * }
         * return k + 1;
         */
        // drugi nacin
        int k = 1;
        for (var i = 1; i < nums.length; i++) {
            if (nums[i] != nums[k - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    // uklanjanje duplikata,tako da ostanu neki duplikati
    public static int removeDuplicates2(int[] nums) {
        /*
         * int k = 2;
         * for(var i = 2; i < nums.length; i++){
         * if(nums[i] != nums[k - 2]){
         * nums[k] = nums[i];
         * k++;
         * }
         * }
         * return k;
         */
        int k = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            // Ažuriramo broj ponavljanja broja
            map.put(i, map.getOrDefault(i, 0) + 1);
            // Dozvoljavamo najviše 2 ponavljanja
            if (map.get(i) <= 2) {
                nums[k] = i;
                k++;
            }
        }
        return k;
    }
}
