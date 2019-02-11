class Solution {
    private int findIndex(int[] nums, int target, boolean left) {
        int lo = 0, hi = nums.length;
        
        while(lo < hi) {
            int mid = (lo+hi)/2;
            if (target<nums[mid] || (left && target == nums[mid])) {
                hi = mid;
            } else {
                lo = mid+1;
            }
        }
        return lo;
    }
    public int[] searchRange(int[] nums, int target) {
        int left = -1, right = -1;
        left = findIndex(nums, target, true);
        
        if (left == nums.length || nums[left] != target) {
            return new int[]{-1, -1};
        }
        right = findIndex(nums, target, false) - 1;
        return new int[]{left, right};
    }
}
