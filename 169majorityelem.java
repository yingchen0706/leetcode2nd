class Solution {
    public int majorityElement(int[] nums) {
        return subMajority(nums, 0, nums.length -1);
    }
    private int subMajority(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int mid = (left+right)/2;
        int leftN = subMajority(nums, left, mid);
        int rightN = subMajority(nums, mid+1, right);
        if (left == right) {
            return left;
        }
        int cntLN = 0;
        int cntRN = 0;
        for (int i = left; i<= right; i++) {
            if (nums[i] == leftN) {
                cntLN++;
            } else if (nums[i] == rightN) {
                cntRN++;
            }
        }
        if (cntLN > cntRN) {
            return leftN;
        } 
        return rightN;
    }
}
