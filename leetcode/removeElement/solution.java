package java.leetcode.removeElement;

public class solution {

    public static int removeElement(int[] nums, int val) {
        int[] newArr = new int[0];
        int k = 0;
        for (var i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                newArr[k++] = nums[i++];
            }
        }
        return newArr.length;
    }
}
