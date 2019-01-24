import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numIndexMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int numTemp = target - nums[i];
            if(numIndexMap.containsKey(numTemp) && numIndexMap.get(numTemp) != i){
                return new int[] {i, numIndexMap.get(numTemp)};
            }
        }
        return null;
    }
}