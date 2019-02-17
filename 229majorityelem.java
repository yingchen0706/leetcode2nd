class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new LinkedList<>();
        
        if (nums.length == 0) {
            return result;
        }
        
        int cnt1 = 0, cnt2 = 0;
        int num1 = nums[0], num2 = nums[0];
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num1) {
                cnt1++;
            } else if (nums[i] == num2) {
                cnt2++;
            } else if (cnt1 == 0) {
                num1 = nums[i];
                cnt1++;
            } else if (cnt2 == 0) {
                num2 = nums[i];
                cnt2++;
            } else {
                cnt1--;
                cnt2--;
            }
        }
        cnt1=0;
        cnt2=0;
        for (int nm: nums) {
            if (nm == num1) {
                cnt1++;
            } else if (nm == num2) {
                cnt2++;
            }
        }
        if (cnt1 > nums.length/3) {
            result.add(num1);
        }
        if (cnt2 > nums.length/3) {
            result.add(num2);
        }
        return result;
    }
    
}
