class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }
        int indexS = 0, indexT = 0;
        while (indexT <= t.length()-1) {
            if (s.charAt(indexS) == t.charAt(indexT)) {
                indexS++;
                if (indexS == s.length()) {
                    return true;
                }
                indexT++;
            } else {
                indexT++;
            }
        }
        return false;
    }
}
