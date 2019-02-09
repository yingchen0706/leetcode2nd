class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length-3; i++) {
            int target1 = target - nums[i];
            if (i>0 && nums[i] == nums[i-1]) {
                continue;
            }
            for (int j = i+1; j < nums.length-2; j++) {
                 if (j>i+1 && nums[j] == nums[j-1]) {
                    continue;
                }
                int target2 = target1 - nums[j];
                int p = j+1, q = nums.length-1;
                while(p<q) {
                    if (nums[p] + nums[q] < target2) {
                        p++;
                    } else if (nums[p] + nums[q] > target2) {
                        q--;
                    } else {
                        List<Integer> list = new LinkedList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[p]);
                        list.add(nums[q]);
                        result.add(list);
                        while(p< nums.length-1 && nums[p] == nums[++p]) ;
                        while(q>j+1 && nums[q] == nums[--q]) ;
                    }
                }
            }
        }
        return result;
    }
}
