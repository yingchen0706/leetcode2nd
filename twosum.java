class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i =0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i =0; i < nums.length; i++) {
            int left = target - nums[i];
            Integer leftElem = map.get(left);
            if ( leftElem!= null && leftElem != i) {
                return new int[]{i, leftElem};
            }
        }
        return new int[]{-1,-1};
    }
}
