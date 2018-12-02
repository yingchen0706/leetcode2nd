class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        
        int res = 0;
        
        int[] num = new int[s.length()];
        
        for (int i = 0; i < s.length(); i++) {
            num[i] = map.get(s.charAt(i));
            if (i>0 && num[i] > num[i-1]) {
                num[i-1] = -1*num[i-1];
            }
        }
        
        for (int i = 0; i < s.length(); i++) {
            res+= num[i];
        }
        return res;
    }
}
