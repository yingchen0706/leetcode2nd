class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int max = 1;
        int len = 1;
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > prev) {
                len++;
            } else {
                max = Math.max(max, len);
                len = 1;
            }
            prev = nums[i];
        }
        max = Math.max(max, len);
        return max;
    }
}
