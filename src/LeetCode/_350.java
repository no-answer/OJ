package LeetCode;

import java.util.Arrays;

public class _350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] nums = new int [nums1.length];
        int index1 = 0, index2 = 0, count = 0;
        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] == nums2[index2]) {
                nums[count] = nums1[index1];
                count++;
                index1++;
                index2++;
            }
            else if (nums1[index1] < nums2[index2]) {
                index1++;
            }
            else if (nums1[index1] > nums2[index2]) {
                index2++;
            }
        }
        return Arrays.copyOfRange(nums, 0, count);
    }
}
