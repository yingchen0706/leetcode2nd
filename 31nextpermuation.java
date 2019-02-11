class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if (len <=1) {
            return;
        }
        int j;
        for (j = len-2; j >=0; j--) {
            if (nums[j] < nums[j+1]) {
                break;
            }
        }
        if (j>=0) {
            for (int i = len-1; i > j; i--) {
                if (nums[i] > nums[j]) {
                    int t = nums[j];
                    nums[j] = nums[i];
                    nums[i] = t;
                    break;
                }
            }
        }
        reverse(nums, j+1, len-1);
    }
    
    private void reverse(int[] nums, int start, int end) {
        int len = end-start+1;
        for (int i = start; i < len/2 + start; i++) {
            int t = nums[i];
            nums[i] = nums[end-i+start];
            nums[end - i+start] = t;
        }
    }
}
