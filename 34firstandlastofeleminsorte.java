class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length <= 0) {
            return new int[]{-1,-1};
        }
        int lo = 0, hi = nums.length-1;
        while (lo < hi) {
            int mid = (lo + hi)/2;
            if (target == nums[mid]) {
                int left = mid;
                int right = mid;
                while(left>=0 && nums[left] == target) left--;
                while(right<nums.length && nums[right] == target) right++;
                return new int[]{++left, --right};
            }
            if (target > nums[mid]) {
                lo = mid+1;
            } else {
                hi = mid-1;
            }
        }
        if (nums[lo] ==  target) {
            return new int[]{lo, lo};
        }
        return new int[]{-1, -1};
    }
}
