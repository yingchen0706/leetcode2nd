class Solution {
    private static List<List<Integer>> result;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new LinkedList<>();
        Arrays.sort(candidates);
        traverse(candidates, target, new LinkedList<Integer>(), 0);        
        return result;
    }
    private void traverse(int[] candidates, int target, LinkedList<Integer> list, int start) {
        for (int i = start; i < candidates.length; i++) {
            int num = candidates[i];
            if (num == target) {
                LinkedList<Integer> item = (LinkedList<Integer>)list.clone();
                item.add(num);
                result.add(item);
                return;
            } else if (target<num) {
                if (!list.isEmpty()) {
                    list.remove();   
                }
                return;
            } else {
                LinkedList<Integer> item =(LinkedList<Integer>)list.clone();
                item.add(num);
                traverse(candidates, target-num, item, i);
            }
        }
        return;
    }
}
