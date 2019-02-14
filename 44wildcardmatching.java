class Solution {
    public boolean isMatch(String s, String p) {
        int starIndex = -1;
        int match = -1;
        int sIndex = 0, pIndex = 0;
        int sLen = s.length(), pLen = p.length();
        char[] sArr = s.toCharArray();
        char[] pArr = p.toCharArray();
        while (sIndex < sLen) {
            if (pIndex < pLen && (sArr[sIndex] == pArr[pIndex] || pArr[pIndex] == '?')) {
                sIndex++;
                pIndex++;
            } else if (pIndex < pLen && pArr[pIndex] == '*'){
                starIndex = pIndex;
                pIndex++;
                match = sIndex; 
            } else {
                if (starIndex != -1) {
                    match++;
                    sIndex = match;
                    pIndex = starIndex+1;
                } else {
                    return false;
                }
            }
        }
        while(pIndex<pLen) {
            if (pArr[pIndex++] != '*') {
                return false;
            }
        }
        return true;
    }
}
