package LeetCode;

import java.util.HashMap;

public class o56 {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Boolean> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i]) && hashMap.get(nums[i]) == false)
                hashMap.replace(nums[i], true);
            else if (hashMap.containsKey(nums[i]) && hashMap.get(nums[i]) == true)
                hashMap.remove(nums[i]);
            else hashMap.put(nums[i], false);
        }
        return hashMap.keySet().iterator().next();
    }
}
