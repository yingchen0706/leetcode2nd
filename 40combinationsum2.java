class Solution {
    private static List<List<Integer>> result;
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new LinkedList<>();
        Arrays.sort(candidates);
        traverse(candidates, target, new LinkedList<Integer>(), 0);
        return result;
    }
    private void traverse(int[] candidates, int target, LinkedList<Integer> list, int start) {
        if (target<0) {
            return;
        }
        if (target == 0) {
            result.add(new LinkedList<Integer>(list));
        }
        for (int i = start; i < candidates.length; i++) {
            if (i == start || candidates[i] != candidates[i-1]) {
                list.add(candidates[i]);
                traverse(candidates, target-candidates[i], list, i+1);
                list.remove(list.size() - 1);
            }
        }
    }
}
