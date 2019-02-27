class Solution {
    public boolean canCross(int[] stones) {
        if (stones[1] - stones[0] != 1) {
            return false;
        }
        Map<Integer, Set<Integer>> stoneMap = new HashMap<>();
        for (int i: stones) {
            stoneMap.put(i, new HashSet<Integer>());
        }
        int lastJump = 1;
        stoneMap.get(1).add(1);
        for (int i = 1; i < stones.length -1; i++) {
            Set<Integer> lastStep = stoneMap.get(stones[i]);
            if (lastStep.size() == 0) {
                continue;
            }
            for (int step: lastStep) {
                for (int s = step-1; s <= step+1; s++) {
                    if (s <=0) {
                        continue;
                    }
                    if (stoneMap.get(stones[i] + s)!=null) {
                        stoneMap.get(stones[i] + s).add(s);
                    }
                }
            }
        }
        if (stoneMap.get(stones[stones.length-1]).size() == 0) {
            return false;
        } 
        return true;
    }
}
