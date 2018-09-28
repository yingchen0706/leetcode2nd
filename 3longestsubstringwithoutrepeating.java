class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> indexMap = new HashMap<>();
        int i = 0;
        int max = Integer.MIN_VALUE;
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            Integer index = indexMap.get(c);
            if ( index != null && index >= i) {
                max = Math.max(max, j - i);   
                i = index + 1;
            } else {
                max = Math.max(max, j - i + 1);   
            }
            indexMap.put(c, j);
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }
}
