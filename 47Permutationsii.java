class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);
        traverse(result, nums, new LinkedList<Integer>(), new boolean[nums.length]);
        return result;
    }
    
    private void traverse(List<List<Integer>> result, int[] nums, LinkedList<Integer> list, boolean[] used) {
        if (list.size() == nums.length) {
            result.add(new LinkedList<Integer>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i] && (i==0 || nums[i] != nums[i-1] || used[i-1])) {
                list.add(nums[i]);
                used[i] = true;
                traverse(result, nums, list, used);
                list.remove(list.size() -1 );
                used[i] = false;
            }
        }
    }
}
