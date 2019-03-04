class Solution {
    public boolean canPartition(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        int sum = 0;
        for (int elem: nums) {
            sum += elem;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        int target = sum/2;
        int numLen = nums.length;
        boolean dp[][] = new boolean[numLen + 1][target + 1];
        dp[0][0] = true;
        for (int i = 1; i <= numLen; i++) {
            dp[i][0] = true;
        }
        for(int i = 1; i <= numLen; i++) {
            for (int j = 1; j <= target; j++) {
                dp[i][j] = dp[i-1][j] || 
                    (j>=nums[i-1] ? dp[i-1][j-nums[i-1]] : false);
            }
        }
        return dp[numLen][target];
    }
}
