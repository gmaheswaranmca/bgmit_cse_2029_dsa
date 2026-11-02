class Solution {
    public int singleNumber(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>(); 
        for(int i = 0; i < n; i++) {
            if(map.containsKey(nums[i]))
                map.put(nums[i], map.get(nums[i]) + 1);
            else
                map.put(nums[i], 1);
        }
        for(Integer num : map.keySet()) {
            if(map.get(num) == 1)
                return num;
        }
        return -1;
    }
}