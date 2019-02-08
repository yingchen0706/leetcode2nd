class Solution {
    private static Map<Character, char[]> keyMap;
    static {
        keyMap = new HashMap<>();
        keyMap.put('2', new char[]{'a','b', 'c'});
        keyMap.put('3', new char[]{'d', 'e', 'f'});
        keyMap.put('4', new char[]{'g', 'h', 'i'});
        keyMap.put('5', new char[]{'j', 'k', 'l'});
        keyMap.put('6', new char[]{'m', 'n', 'o'});
        keyMap.put('7', new char[]{'p', 'q', 'r', 's'});
        keyMap.put('8', new char[]{'t', 'u', 'v'});
        keyMap.put('9', new char[]{'w', 'x', 'y', 'z'});
        
    }
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        
        if (digits == null) {
            return result;
        }
        
        return letterCombinationsRecur(digits.toCharArray(), digits.length() -1);
    }
    
    private List<String> letterCombinationsRecur(char digits[], int end) {
        List<String> result = new ArrayList<>();
        
        if (end < 0 || end > digits.length -1) {
            return result;
        }
        
        List<String> subResult = letterCombinationsRecur(digits, end-1);
        
        char[] curChar = keyMap.get(digits[end]);
        for(int i = 0; i < curChar.length; i++) {
            char c = curChar[i];
            if (subResult.size() > 0) {
                for (String str: subResult) {
                    result.add(str+c);
                }
            } else {
                result.add(String.valueOf(c));
            }
        }
        return result;
        
    }
}
