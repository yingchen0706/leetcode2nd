class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] s = str.toCharArray();
            Arrays.sort(s);
            String sorted = new String(s);
            if (map.get(sorted)!= null) {
                int index = map.get(sorted);
                result.get(index).add(str);
            } else {
                List<String> list = new LinkedList<>();
                list.add(str);
                result.add(list);
                map.put(sorted, count);
                count++;
            }
        }
        return result;
    }
}
